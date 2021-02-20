package com.chaochaogu.daily.utils.azure;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.google.common.base.Throwables;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 导出Excel并上传至Azure工具类
 *
 * @author chaochao Gu
 * @date 2020/1/15
 * @see com.alibaba.excel.annotation.ExcelProperty
 * TODO 该工具类需要在导出实体类属性上添加@ExcelProperty注解
 */
@Slf4j
public class CreateExcelAndUploadAzureUtils {
    private static CloudStorageAccount storageAccount;

    public static <T> String createExcelAndUploadAzure(List<T> list, String fileName, StorageConfig storageConfig, String containerName) throws Exception {
        String blobName = fileName + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "/" + ".xls";
        Class clazz = list.get(0).getClass();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        EasyExcel.write(out, clazz).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("sheet1").doWrite(list);
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        CloudBlobContainer container = getContainer(containerName, storageConfig);
        CloudBlockBlob blob = container.getBlockBlobReference(blobName);
        blob.upload(in, out.toByteArray().length);
        out.close();
        return blob.getUri().toString();
    }

    private static CloudBlobContainer getContainer(String containerName, StorageConfig storageConfig) throws Exception {
        String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.Chinacloudapi.cn", storageConfig.getAccountName(), storageConfig.getAccountKey());
        storageAccount = CloudStorageAccount.parse(connectionString);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer container;
        container = blobClient.getContainerReference(containerName);
        container.createIfNotExists();
        setUpContainer(container);
        return container;
    }

    /**
     * 对container设置允许外部读取
     *
     * @param container
     * @throws StorageException
     */
    private static void setUpContainer(CloudBlobContainer container) throws StorageException {
        BlobContainerPermissions permissions = new BlobContainerPermissions();
        permissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
        container.uploadPermissions(permissions);
    }

    public String download(String fileName, String path, StorageConfig storageConfig) {
        try {
            String sufix;
            if (path.endsWith("xlsx")) {
                sufix = ".xlsx";
            } else {
                sufix = ".xls";
            }
            File file = newTempFile("member", "supply-rule-import-", sufix);
            String connectionString = String.format("DefaultEndpointsProtocol=https;AccountName=%s;AccountKey=%s;EndpointSuffix=core.Chinacloudapi.cn", storageConfig.getAccountName(), storageConfig.getAccountKey());
            storageAccount = CloudStorageAccount.parse(connectionString);
            CloudBlobClient client = storageAccount.createCloudBlobClient();
            CloudBlobContainer container = client.getContainerReference(path);
            OperationContext opContext = new OperationContext();
            opContext.setLoggingEnabled(Boolean.TRUE);
            CloudBlob blob = container.getBlobReferenceFromServer(fileName, null, null, null, opContext);
            if (!blob.exists()) {
                return null;
            }
            blob.downloadToFile(file.getPath());
            return file.getPath();
        } catch (Exception e) {
            log.error("failed to download {}/{} from oss, cause: {}", path, fileName, Throwables.getStackTraceAsString(e));
            return null;
        }
    }

    private File newTempFile(String path, String prefix, String suffix) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = File.createTempFile(prefix, suffix, dir);
        log.info("file exist: {}", file.exists());
        log.info("file path: {}", file.getPath());
        if (!log.isDebugEnabled()) {
            file.deleteOnExit();
        }
        return file;
    }
}

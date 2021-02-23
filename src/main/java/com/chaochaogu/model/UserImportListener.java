package com.chaochaogu.model;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * easyExcel的importListener不能被spring管理，如有用到springBean构造方法传递即可
 *
 * @author chaochao Gu
 * @date 2021/2/20
 */
public class UserImportListener extends AnalysisEventListener<UserImportVO> {

    @Override
    public void invoke(UserImportVO userImportVO, AnalysisContext analysisContext) {
        // 一行行读，校验数据 ...
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 保存导入记录 ...
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
    }
}

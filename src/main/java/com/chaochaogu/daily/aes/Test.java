package com.chaochaogu.daily.aes;

import java.util.Objects;

/**
 * @author chaochao Gu
 * @date 2020/10/12
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        System.out.println(EncryptUtil.match("123456", "986b@f4a0cf5147218c4efc05"));
//        String encryptString = "UKmhC8MWVJMs4TN2u/SskwtSfWsNfNQdOg/GgNCZY6NgMzXnWnIkX1OM0KraMeYrzVM58wDRJkCd\n" +
//                "qBTT2tJ5TVKhnhdqaVXeFMW8T3KelO8qB3kqcR1jNHP9xxbAYWXNn9hdSEoB6mcBS8TSq/JFDIB7\n" +
//                "qQ/zUVQkOKmO2KRefQcorWIgLiM1BRnov46yKxFECuUwjpS0OyoQRBokLg3lkzs7yl7BYmvFPIOS\n" +
//                "1oleKucouVi0W4VydNbpSqw06zANAI02ScFlxFXXPzWi5D1/KA==";
//        String expectOriginJson = "{\"receiveUserName\":\"林柏谷\",\"mobile\":\"0919707728\",\"province\":\"臺灣\",\"city\":\"彰化縣\",\"region\":\"福興鄉\",\"detail\":\"外埔村外埔巷11-25號\",\"extra\":{\"handleResult\":\"{\\\"success\\\":false}\"}}";
//        System.out.println(aesCompare(encryptString, expectOriginJson));
        String normal = "UKmhC8MWVJMs4TN2u/Ssk+07bCQjG5qUBDqO70FeDOEdWxuIaWiyxIF7YX34Y2NfS9xdmplldtbd\n" +
                "9CUZYqaWuZSzjvFHS/SEA/qAEentq1D/M2Fas0PMTY1qjpkybfZiuf6rpTPTaywc/rSVdQDPsWyF\n" +
                "pog/lbs0CfaaEe1l35wsy395hEdVB0wek/OKu1oa6PQ8UCtp3f0IeimjjtGGIxH/+RpPz1oza3C1\n" +
                "JYAtz6DcfMQITn2KJ6SCh9RbB2+XmAIrfmVvmPicjFt06cSULaltwp807rlZUJ8bQzCeMrV/+omL\n" +
                "SXUISRsBT3kbPMGC";
        System.out.println(decrypt(normal));
        Short a = 1;
    }

    /**
     * AES加密
     *
     * @param originJson
     * @return
     * @throws Exception
     */
    public static String encrypt(String originJson) throws Exception {
        return AESEncryptUtil.aesEncrypt(originJson, AESEncryptUtil.RECEIVER_INFO_ENCRYPT_KEY);
    }

    /**
     * AES解密
     *
     * @param encryptString
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptString) throws Exception {
        return AESEncryptUtil.aesDecrypt(encryptString, AESEncryptUtil.RECEIVER_INFO_ENCRYPT_KEY);
    }

    /**
     * 比较加密字符串的解密结果是否与期望得到的结果一致
     *
     * @param encryptString
     * @param expectOriginJson
     */
    public static boolean aesCompare(String encryptString, String expectOriginJson) throws Exception {
        String decryptJson = AESEncryptUtil.aesDecrypt(encryptString, AESEncryptUtil.RECEIVER_INFO_ENCRYPT_KEY);
        return Objects.equals(decryptJson, expectOriginJson);
    }
}

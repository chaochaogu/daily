package com.chaochaogu.daily.aes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5密码加密
 */
class Md5Utility {
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static MessageDigest messagedigest = null;

    private static String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }

    private static String getMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; ++l) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[((bt & 0xF0) >> 4)];
        char c1 = hexDigits[(bt & 0xF)];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    static boolean checkPassword(String password, String md5PwdStr) {
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException nsaex) {
            nsaex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getMD5String("123456"));
    }
}
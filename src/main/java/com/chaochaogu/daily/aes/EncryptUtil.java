package com.chaochaogu.daily.aes;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.util.UUID;

/**
 * Description: 单向加密
 * User: lt
 * Date: 29/06/2017
 */
public class EncryptUtil {
    private static final HashFunction SHA512 = Hashing.sha512();
    private static final Splitter SPLITTER = Splitter.on('@').trimResults();
    private static final Joiner JOINER = Joiner.on('@').skipNulls();
    private static final HashFunction MD5 = Hashing.md5();


    /**
     * 对密码进行混淆
     *
     * @param plain         明文
     * @param mask          混淆的字符
     * @param startPlainLen 头部保留明文的位数
     * @return 混淆后的字符串
     */
    public static String mask(String plain, char mask, int startPlainLen) {
        if (plain == null || plain.length() == 0) {
            return plain;
        }

        StringBuilder sb = new StringBuilder(plain.length());
        if (plain.length() >= startPlainLen) {
            sb.append(plain.substring(0, startPlainLen));
            for (int i = 0; i < plain.length() - startPlainLen; i++) {
                sb.append(mask);
            }
        }
        return sb.toString();
    }

    /**
     * 对密码进行加密
     *
     * @param password 明文密码
     * @return 加密后的密码
     */
    public static String encrypt(String password) {
        String salt = MD5.newHasher().putString(UUID.randomUUID().toString(), Charsets.UTF_8)
                .putLong(System.currentTimeMillis()).hash()
                .toString().substring(0, 4);
        String realPassword = SHA512.hashString(password + salt, Charsets.UTF_8).toString().substring(0, 20);
        return JOINER.join(salt, realPassword);
    }

    /**
     * 密码匹配
     *
     * @param password          明文密码
     * @param encryptedPassword 加密后的密码
     * @return 匹配成功返回true, 反之false
     */
    public static boolean match(String password, String encryptedPassword) {
        Iterable<String> parts = SPLITTER.split(encryptedPassword);
        String salt = Iterables.get(parts, 0);
        String realPassword = Iterables.get(parts, 1);
        return Objects.equal(SHA512.hashString(password + salt, Charsets.UTF_8)
                .toString().substring(0, 20), realPassword);
    }
}
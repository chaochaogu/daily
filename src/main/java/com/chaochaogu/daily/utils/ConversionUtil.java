package com.chaochaogu.daily.utils;

import com.chaochaogu.model.UtilsException;
import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串转换工具类
 *
 * @author chaochao Gu
 * @date 2020/6/16
 */
public class ConversionUtil {

    public static void main(String[] args) {
        System.out.println(convertToShortPinyin("这个简体繁体对应字典内容太少，只有2000多个"));
    }

    /**
     * 中文繁体转中文简体
     *
     * @param traditional 繁体中文
     * @return
     */
    public static String convertToSimplifiedChinese(String traditional) {
        if (StringUtils.isEmpty(traditional)) {
            return StringUtils.EMPTY;
        }
        try {
            return ChineseHelper.convertToSimplifiedChinese(traditional);
        } catch (Throwable e) {
            throw new UtilsException("ConversionUtil.convertToSimplifiedChinese has an error!", e);
        }
    }

    /**
     * 中文简体转换中文繁体
     *
     * @param simplified 简体中文
     * @return
     */
    public static String convertToTraditionalChinese(String simplified) {
        if (StringUtils.isEmpty(simplified)) {
            return StringUtils.EMPTY;
        }
        try {
            return ChineseHelper.convertToTraditionalChinese(simplified);
        } catch (Throwable e) {
            throw new UtilsException("ConversionUtil.convertToTraditionalChinese has an error!", e);
        }
    }

    /**
     * 中文转拼音（不带音标）
     *
     * @param chinese   中文字符串
     * @param separator 拼音间隔符
     * @return
     */
    public static String convertToPinyin(String chinese, String separator) {
        if (StringUtils.isEmpty(chinese)) {
            return StringUtils.EMPTY;
        }
        try {
            return PinyinHelper.convertToPinyinString(chinese, separator, PinyinFormat.WITHOUT_TONE);
        } catch (Throwable e) {
            throw new UtilsException("ConversionUtil.convertToPingyin has an error!", e);
        }
    }

    /**
     * 中文转拼音（不带音标）
     *
     * @param chinese 中文字符串
     * @return
     */
    public static String convertToPinyin(String chinese) {
        if (StringUtils.isEmpty(chinese)) {
            return StringUtils.EMPTY;
        }
        try {
            return convertToPinyin(chinese, " ");
        } catch (Throwable e) {
            throw new UtilsException("ConversionUtil.convertToPingyin has an error!", e);
        }
    }

    /**
     * 中文转拼音首字母
     *
     * @param chinese
     * @return
     */
    public static String convertToShortPinyin(String chinese) {
        if (StringUtils.isEmpty(chinese)) {
            return StringUtils.EMPTY;
        }
        try {
            return PinyinHelper.getShortPinyin(chinese);
        } catch (Throwable e) {
            throw new UtilsException("ConversionUtil.convertToShortPinyin has an error!", e);
        }
    }
}

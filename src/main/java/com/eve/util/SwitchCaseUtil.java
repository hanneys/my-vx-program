package com.eve.util;

/**
 * @Author hanneys
 * @Date 2021/4/15 15:18
 * @Version 1.0
 */
public class SwitchCaseUtil {

    //32为是char类型大小写的差数，-32是小写变大写，+32是大写变小写

    /**
     * 首字母小写
     *
     * @param str
     * @return
     */
    public static String lowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        //首字母小写方法，大写会变成小写，如果小写首字母会消失
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 首字母大写
     *
     * @param str
     * @return
     */
    public static String upperFirstCase(String str) {
        char[] chars = str.toCharArray();
        //首字母小写方法，大写会变成小写，如果小写首字母会消失
        chars[0] -= 32;
        return String.valueOf(chars);
    }

}

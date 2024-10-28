package com.programmer.carl.string;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 15:59
 * @description:
 */
public class T1844ReplaceDigits {

    /**
     * 将所有数字用字符替换
     * @param s
     * @return
     */
    public String replaceDigits(String s) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i+=2) {
            chars[i] = (char)(chars[i - 1] + (int) (chars[i] - '0'));
        }
        return new String(chars);
    }
}

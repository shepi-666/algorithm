package com.programmer.carl.string;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 20:33
 * @description:
 */
public class T459RepeatedSubString {

    /**
     * 重复的字符子串
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        String trim = t.substring(1, t.length() - 1);
        return trim.contains(s);
    }

    @Test
    public void testSolution() {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }
}

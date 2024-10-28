package com.programmer.carl.string;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 15:25
 * @description:
 */
public class T344ReverseString {

    /**
     * 反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        if (s.length <= 1) return;
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}

package com.programmer.carl.string;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 15:34
 * @description:
 */
public class T541ReverseStringII {

    /**
     * 反转字符串II
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if (s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 2 * k - 1;
        while (r < s.length()) {
            // 窗口内的前k个字符反转
            int i = l;
            int j = l + k - 1;
            while (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            }
            l = r + 1;
            r = l + 2 * k - 1;
        }
        r = s.length() - 1; // r 置位为末尾
        // 判断 l 和 r 之间窗口的大小
        if (r - l + 1 >= k) {
            // 反转前 k 个字符
            r = l + k - 1;
        }
        while (l < r) {
            swap(chars, l, r);
            l++; r--;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
    }

    @Test
    public void testSolution() {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}

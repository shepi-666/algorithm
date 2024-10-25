package com.programmer.carl.array;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 15:48
 * @description:
 */
public class T844Backspace {

    /**
     * 比较两个含有退格元素 # 的字符串是否相同
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        if (s == null || t == null) return false;
        Stack<Character> sQ = new Stack<>();
        Stack<Character> tQ = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#' ) {
                if (!sQ.isEmpty()) {
                    sQ.pop();
                }
            } else {
                sQ.push(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#' ) {
                if (!tQ.isEmpty()) {
                    tQ.pop();
                }
            } else {
                tQ.push(c);
            }
        }

        // 判断两个队列是否相同
        if (sQ.size() != tQ.size()) return false;
        while (!sQ.isEmpty()) {
            if (sQ.pop() != tQ.pop()) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void testSolution() {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompareII(s, t));
    }

    /**
     * 快慢双指针
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompareI(String s, String t) {
        int f1 = 0;
        int f2 = 0;
        int s1 = 0;
        int s2 = 0;
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        
        // 有效区间范围为[0, slow)
        while (f1 < c1.length) {
            if (c1[f1] == '#') {
                s1 = s1 == 0 ? 0 : s1 - 1;
            } else {
                c1[s1++] = c1[f1];
            }
            f1++;
        }

        while (f2 < c2.length) {
            if (c2[f2] == '#') {
                s2 = s2 == 0 ? 0 : s2 - 1;
            } else {
                c2[s2++] = c2[f2];
            }
            f2++;
        }

        if (s1 != s2) return false;
        for (int i = 0; i < s1; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
        
        
    }

    /**
     * 使用 StringBuilder 构建操作之后的字符串
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompareII(String s, String t) {
        return operation(s).equals(operation(t));
    }

    private String operation(String s) {
        StringBuilder sb = new StringBuilder();
        int p = 0; // 表示有效位数
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (p > 0) {
                    sb.deleteCharAt(--p);
                }
            } else {
                sb.append(c);
                p++;
            }
        }
        return sb.toString();
    }
}

package com.programmer.carl.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 16:19
 * @description:
 */
public class T1047RemoveDuplicates {

    /**
     * 删除字符串中所有相邻的重复项
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        if (s.length() <= 1) return s;
        ArrayDeque<Character> q = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!q.isEmpty() && c == q.peekLast()) {
                q.removeLast();
            } else {
                q.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : q) {
            sb.append(c);
        }
        return sb.toString();
    }
}

package com.programmer.carl.stackqueue;

import java.util.Stack;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 16:07
 * @description:
 */
public class T20ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (c - stack.peek()) <= 2 && (c - stack.peek()) > 0) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

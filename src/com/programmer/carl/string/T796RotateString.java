package com.programmer.carl.string;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 16:19
 * @description:
 */
public class T796RotateString {

    /**
     * 旋转字符串
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String t = s + s;
        return t.contains(goal);
    }
}

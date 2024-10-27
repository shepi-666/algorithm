package com.programmer.carl.hashmap;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 15:19
 * @description:
 */
public class T242Anagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
     * 字母异位词
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 边界条件判断
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            dict[c - 'a']--;
        }

        for (int counts : dict) {
            if (counts != 0) return false;
        }

        return true;
    }
}

package com.programmer.carl.hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 09:47
 * @description:
 */
public class T438AllAnagrams {

    /**
     * 从 S 中找到 p 的所有字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s.length() < p.length()) return anagrams;
        int n = p.length();
        int[] winDict = new int[26];
        int[] pDict = new int[26];

        // pDict 和winDict 初始化
        for (char c : p.toCharArray()) {
            pDict[c - 'a']++;
        }
        int r = 0;
        int l = 0;
        while (r < n) {
            winDict[s.charAt(r++) - 'a']++;
        }
        // 先判断是否是为 异位词
        if (isAnagram(winDict, pDict)) {
            anagrams.add(l);
        }

        // 窗口为一个左闭右开的区间[l, r)
        while (r < s.length()) {
            // 窗口右移
            winDict[s.charAt(r++) - 'a']++;
            winDict[s.charAt(l++) - 'a']--;
            // 判断是否为 异位词
            if (isAnagram(winDict, pDict)) {
                anagrams.add(l);
            }
        }
        return anagrams;

    }

    /**
     * 判断两个字符数组是否相同
     * @param winDict
     * @param pDict
     * @return
     */
    private boolean isAnagram(int[] winDict, int[] pDict) {
        for (int i = 0; i < winDict.length; i++) {
            if (winDict[i] != pDict[i]) {
                return false;
            }
        }
        return true;
    }
}

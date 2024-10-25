package com.programmer.carl.array;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 21:49
 * @description:
 */
public class T76CoverSubstring {

    /**
     * 判断 s 中涵盖 t 的最小子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";
        int[] subDict = new int[128];

        // 初始化模式串的词频表
        int[] tDict = new int[128];
        for (char c : t.toCharArray()) {
            tDict[c]++;
        }

        int l = 0;
        int r = 0;
        int[] candidates = {0, s.length() + 1};
        while (r < s.length()) {
            // 将当前字符加入窗口
            subDict[s.charAt(r++)]++;
            while (isCovered(subDict, tDict)) {
                // 如果当前窗口小于已经记录的最大窗口
                if (r - l < candidates[1] - candidates[0]) {
                    candidates[0] = l;
                    candidates[1] = r;
                }
                // 从里面移出元素
                subDict[s.charAt(l++)]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (candidates[1] == s.length() + 1) return sb.toString();
        for (int i = candidates[0]; i < candidates[1]; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 判断 subDict 是否涵盖 tDict
     * @param subDict
     * @param tDict
     * @return
     */
    private boolean isCovered(int[] subDict, int[] tDict) {
        for (int i = 0; i < subDict.length; i++) {
            if (subDict[i] < tDict[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSolution() {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
}

package com.programmer.carl.hashmap;

import java.util.*;

/**
 * @author: DongShaowei
 * @create: 2024-10-26 15:33
 * @description:
 */
public class T49GroupAnagrams {

    /**
     * 字符异位词分组
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length <= 1) {
            res.add(Arrays.asList(strs));
            return res;
        }
        Map<String, List<String>> dict = new HashMap<>();

        for (String str : strs) {
            String code = compress(str);
            if (dict.containsKey(code)) {
                dict.get(code).add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                dict.put(code, temp);
            }
        }

        // 遍历 map, 获取结果
        for (Map.Entry<String, List<String>> entry : dict.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    /**
     * 从字符串中获取其压缩编码：
     * teed -> d1e2t1
     * @param str
     * @return
     */
    private String compress(String str) {

        // 记录当前字符串的字符出现频率
        int[] dict = new int[26];
        for (char c : str.toCharArray()) {
            dict[c - 'a']++;
        }

        // 获取词频表的压缩字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dict.length; i++) {
            if (dict[i] != 0) {
                sb.append((char)('a' + i)).append(dict[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 优化方法
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsI(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length <= 1) {
            res.add(Arrays.asList(strs));
            return res;
        }
        Map<String, List<String>> dict = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if (!dict.containsKey(key)) {
                dict.put(key, new ArrayList<>());
            }
            dict.get(key).add(str);
        }

        // 遍历结果集
        res.addAll(dict.values());
        return res;
    }
}

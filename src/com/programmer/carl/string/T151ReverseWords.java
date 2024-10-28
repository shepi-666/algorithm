package com.programmer.carl.string;

/**
 * @author: DongShaowei
 * @create: 2024-10-28 16:07
 * @description:
 */
public class T151ReverseWords {

    /**
     * 反转字符串中的单词
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}

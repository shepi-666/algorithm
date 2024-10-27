package com.programmer.carl.hashmap;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 16:05
 * @description:
 */
public class T383RansomNote {

    /**
     * 赎金信
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() >  magazine.length()) return false;

        int[] noteDict = new int[26];
        for (char c : magazine.toCharArray()) {
            noteDict[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            noteDict[c - 'a']--;
        }


        for (int j : noteDict) {
            if (j < 0) return false;
        }
        return true;
    }
}

package online.labuladong.algo.doublepointer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 16:37
 * @description:
 */
public class T438Anagrams {


    /**
     * 判断字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        if (s.length() < p.length()) return resList;


        // 初始化两个字符字典
        int[] pDict = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pDict[p.charAt(i) - 'a']++;
        }
        int[] winDict = new int[26];
        int l = 0; int r = 0;
        while (r < p.length()) {
            winDict[s.charAt(r++) - 'a']++;
        }
        // 如果两个字符串相等的情况
        if (covering(winDict, pDict) && r == s.length()) {
            resList.add(l);
            return resList;
        }

        while (r < s.length()) {

            // 涵盖住了，添加
            if (covering(winDict, pDict)) {
                resList.add(l);
            }
            // 右滑
            winDict[s.charAt(r++) - 'a']++;
            winDict[s.charAt(l++) - 'a']--;
        }
        // 最后一个窗口右滑跳出循环了
        if (covering(winDict, pDict)) {
            resList.add(l);
        }
        return resList;

    }


    /**
     * 判断 winDict 是否涵盖 pDict
     * @param winDict
     * @param pDict
     * @return
     */
    private boolean covering(int[] winDict, int[] pDict) {
        for (int i = 0; i < winDict.length; i++) {
            if (winDict[i] - pDict[i] < 0) {
                return false;
            }
        }

        return true;
    }
}

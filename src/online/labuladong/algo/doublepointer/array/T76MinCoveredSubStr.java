package online.labuladong.algo.doublepointer.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 15:34
 * @description:
 */
public class T76MinCoveredSubStr {


    /**
     * 最小覆盖字串
     * @param s 母串
     * @param t 字串
     * @return
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String minWin = "";
        Map<Character, Integer> tDict = new HashMap<>();
        Map<Character, Integer> winDict = new HashMap<>();

        // 获得子串的词频表
        for (char c : t.toCharArray()) {
            if (!tDict.containsKey(c)) {
                tDict.put(c, 1);
            } else {
                tDict.put(c, tDict.get(c) + 1);
            }
        }

        int l = 0; int r = 0;
        while (r < s.length()) {
            // 如果覆盖不了，就往窗口里头加字符
            if (!isCovering(winDict, tDict)) {
                char rChar = s.charAt(r);
                winDict.put(s.charAt(r), winDict.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
            if (isCovering(winDict, tDict)) {
                // 说明已经覆盖了目标字符串，需要对窗口进行剪枝
                while (isCovering(winDict, tDict)) {
                    // 窗口收缩
                    char lChar = s.charAt(l);
                    winDict.put(lChar, winDict.getOrDefault(lChar, 0) - 1);
                    l++;
                }
                // 窗口回溯
                l--;
                winDict.put(s.charAt(l), winDict.getOrDefault(s.charAt(l), 0) + 1);
                StringBuilder sb = new StringBuilder();
                for (int i = l; i < r; i++) {
                    sb.append(s.charAt(i));
                }
                // 判断是不是最短的字串
                if ("".equals(minWin)) {
                    minWin = sb.toString();
                } else {
                    minWin = sb.length() < minWin.length() ? sb.toString() : minWin;
                }
                // 得到当前最短串之后，窗口缩小，继续滑动
                winDict.put(s.charAt(l), winDict.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
        }
        return minWin;
    }

    /**
     * 判断 winDict 是否包含 tDict
     * @param winDict
     * @param tDict
     * @return
     */
    private boolean isCovering(Map<Character, Integer> winDict, Map<Character, Integer> tDict) {

        // 如果 当前窗口字典没有含有目标字典的字符 或者 字符频次小于目标字符，就返回false
        for (Map.Entry<Character, Integer> tEntry : tDict.entrySet()) {
            if (!winDict.containsKey(tEntry.getKey()) || winDict.get(tEntry.getKey()) < tEntry.getValue()) {
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

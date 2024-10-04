package online.labuladong.algo.doublepointer.array;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-03 17:06
 * @description:
 */
public class T3LongestSubString {

    /**
     * 最长无重复字符串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 1) {
            return s == null ? 0 : s.length();
        }

        int maxLen = 0;
        int[] winDict = new int[128];
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);

            // 如果winDict中含有当前字符 c
            if (isContain(winDict, c))  {
                // 说明已经含有 c 了, 记录此时的长度
                maxLen = Math.max(maxLen, r - l);

                // 从左边移出多余的字符 c
                while (isContain(winDict, c)) {
                    winDict[s.charAt(l++)]--;
                }

            }
            // 添加新字符
            winDict[c]++;
            r++;
        }
        // 如果无重复的，可能会出现数组越界的情况导致循环结束，判断最后的窗口
        maxLen = Math.max(maxLen, r - l);

        return maxLen;
    }

    /**
     * 判断 winDict 中是否 含有 c
     * @param winDict
     * @return
     */
    private boolean isContain(int[] winDict, char c) {
        return winDict[c] == 1;
    }

    @Test
    public void testSolution() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

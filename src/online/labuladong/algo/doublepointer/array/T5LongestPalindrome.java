package online.labuladong.algo.doublepointer.array;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-04 16:47
 * @description:
 */
public class T5LongestPalindrome {

    /**
     * 找到最长的回文字串 [超时]
     * @param s
     * @return
     */
    public String longestPalindromeI(String s) {
        if (s == null || s.length() <= 1) return s;

        int l = 0, r = s.length() - 1;
        return findPalindrome(l, r, s);
    }

    /**
     * 在 [l, r] 范围之内寻找回文串
     * @param l
     * @param r
     * @param s
     * @return
     */
    private String findPalindrome(int l, int r, String s) {
        if (isPalindrome(l, r, s)) {
            return s.substring(l, r + 1);
        }
        String lp = findPalindrome(l + 1, r, s);
        String rp = findPalindrome(l, r - 1, s);
        return lp.length() >= rp.length() ? lp : rp;
    }

    /**
     * 判断[l, r]字符串是否为回文串
     * @param l
     * @param r
     * @param s
     * @return
     */
    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    @Test
    public void testSolution() {
        String s = "cccc";
        System.out.println(longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String res = "";

        for (int i = 0; i <= s.length() - 2; i++) {
            String pOdd = getPalindrome(i, i, s);
            String pEven = getPalindrome(i, i + 1, s);
            String p = pOdd.length() > pEven.length() ? pOdd : pEven;
            res = p.length() > res.length() ? p : res;
        }
        return res;
    }

    /**
     * 从 i 和 j 开始扩散寻找回文串
     * @param i
     * @param j
     * @param s
     * @return
     */
    private String getPalindrome(int i, int j, String s) {
        int l = i;
        int r = j;
        while (l >= 0 && r <= s.length() - 1) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        // 循环结束之后，肯定是左右各多了一个字符的长度

        return s.substring(l + 1, r);
    }
}

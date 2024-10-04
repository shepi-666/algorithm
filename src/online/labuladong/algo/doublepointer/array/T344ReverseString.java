package online.labuladong.algo.doublepointer.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-04 16:35
 * @description:
 */
public class T344ReverseString {

    /**
     * 反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;

        int l = 0, r = s.length - 1;
        while (l < r) {
            // 交换 s[l] 和 s[r]
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++; r--;
        }
    }
}

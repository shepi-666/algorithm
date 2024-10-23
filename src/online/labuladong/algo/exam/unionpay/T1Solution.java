package online.labuladong.algo.exam.unionpay;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-22 20:33
 * @description:
 */
public class T1Solution {

    /**
     * 使用 x y 组成 n < m 之间最大的数字
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    public int maxVal(int m, int n, int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        boolean smaller = false;
        boolean bigger = false;

        String lower = m + "";
        String upper = n + "";
        int diff = upper.length() - lower.length();
        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            zeros.append("0");
        }
        String low = zeros.append(lower).toString();

        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < upper.length(); i++) {
            int upperNum = upper.charAt(i) - '0';
            int lowNum = low.charAt(i) - '0';

            if (!bigger && !smaller) {
                // 返回0的情况
                if (lowNum > 0 && (max < lowNum || min > upperNum)) {
                    return 0;
                } else if (lowNum == 0 && min > upperNum) { // 补零的情况
                    // 补零，但是没必要
                    smaller = true;
                } else if (max > upperNum ) { // 选择小的情况
                    numStr.append(min);
                    smaller = min < upperNum;
                    bigger = min > lowNum;
                } else { // 选择大的情况
                    numStr.append(max);
                    smaller = max < upperNum;
                    bigger = max > lowNum;
                }
            } else if (bigger && smaller) {
                // 无脑选择最大的
                numStr.append(max);
            } else if (smaller) {
                // 有下界
                if (lowNum > 0 && max < lowNum) { // 直接返回 0
                    return 0;
                } else { // 选择最大的
                    numStr.append(max);
                    bigger = max > lowNum;
                }
            } else if (bigger) {
                // 有上界
                if (min > upperNum) { // 返回 0
                    return 0;
                } else if (max > upperNum) { // 选择小的
                    numStr.append(min);
                    smaller = min < upperNum;
                } else {
                    // 选择最大的
                    numStr.append(max);
                    smaller = max < upperNum;
                }
            }
        }
        return Integer.parseInt(numStr.toString());

    }

    @Test
    public void testSolution() {
        int m = 3742;
        int n = 45220;
        int x = 4;
        int y = 8;
        System.out.println(maxVal(m, n, x, y));
    }

}

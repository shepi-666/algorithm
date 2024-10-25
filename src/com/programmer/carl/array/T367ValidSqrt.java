package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 11:08
 * @description:
 */
public class T367ValidSqrt {

    /**
     * 如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;

        int l = 1;
        int r = num / 2 + 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            long powMid = ((long) mid * mid);
            if (powMid == num) {
                return true;
            } else if (powMid < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}

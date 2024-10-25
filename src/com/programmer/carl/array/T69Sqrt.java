package com.programmer.carl.array;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-24 10:26
 * @description:
 */
public class T69Sqrt {

    /**
     * 计算并返回 x 的 算术平方根 。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1;
        int r = x / 2 + 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            long powMid = (long) mid * mid;
            if (powMid > x) { // 溢出风险
                r = mid;
            } else if (powMid == x) {
                return mid;
            } else if (powMid < x) {
                l = mid + 1;
            }
        }
        return --l;
    }

    @Test
    public void testSolution() {
        int x = 2147395599;
        System.out.println(mySqrt(x));
    }

    /**
     * 袖珍计算器
     * @param x
     * @return
     */
    public int mySqrtI(int x) {
        if (x <= 1) return x;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


}

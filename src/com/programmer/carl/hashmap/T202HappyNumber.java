package com.programmer.carl.hashmap;

import org.junit.Test;

/**
 * @author: DongShaowei
 * @create: 2024-10-27 10:34
 * @description:
 */
public class T202HappyNumber {

    /**
     * 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) return true;
        int slow = n;
        int fast = squareSum(n);
        while (slow != fast) {
            if (fast == 1) return true;
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        }
        return false;
    }

    /**
     * 计算数字的平方和
     * @param n
     * @return
     */
    private int squareSum(int n) {
        int sum = 0;
        int remainder = 0;
        while (n != 0) {
            remainder = n % 10;
            sum += remainder * remainder;
            n = n / 10;
        }
        return sum;
    }

    @Test
    public void testSolution() {
        int n = 19;
        System.out.println(isHappy(n));
    }


}

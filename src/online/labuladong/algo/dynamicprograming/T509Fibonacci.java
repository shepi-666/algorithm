package online.labuladong.algo.dynamicprograming;

/**
 * @author: DongShaowei
 * @create: 2024-10-05 09:33
 * @description:
 */
public class T509Fibonacci {


    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        int dp = 1;
        int dp_1 = 1;
        if (n <= 2) return n == 0 ? 0 : 1;
        for (int i = 3; i <= n; i++) {
            int temp = dp;
            dp = dp + dp_1;
            dp_1 = temp;
        }
        return dp;

    }
}

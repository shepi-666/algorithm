package online.labuladong.algo.exam.hand;

import java.util.Scanner;

/**
 * @author: DongShaowei
 * @create: 2024-10-09 20:31
 * @description:
 */
public class T1FindThree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] nums = new int[n];
        int count = 0;
        while (count < n) {
            String input = in.nextLine();
            nums[count++] = Integer.parseInt(input);
        }

        // 一个数分为3个3的倍数的数，共有几种分法？
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < 9) {
                System.out.println(0);
            } else {
                System.out.println(cascadeMultiply(nums[i] / 3 - 2));
            }
        }
    }

    private static int cascadeMultiply(int num) {
        int res = 0;
        for (int i = num; i >= 1; i--) {
            res = res + i;
        }
        return res;
    }
}

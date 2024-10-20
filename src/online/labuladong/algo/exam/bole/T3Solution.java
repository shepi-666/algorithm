package online.labuladong.algo.exam.bole;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: DongShaowei
 * @create: 2024-10-10 21:19
 * @description:
 */
public class T3Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param bonuses int整型一维数组 总奖金列表
     * @param k long长整型 参与分奖金的人数
     * @return int整型
     */
    public int maximumBonuses (int[] bonuses, long k) {
        // write code here
        long sum = 0;
        for (int bonus : bonuses) {
            sum += bonus;
        }

        long max = sum / k;
        while (max > 0) {
            int count = 0;
            for (int bonus : bonuses) {
                if (bonus >= max) {
                    while (bonus >= max) {
                        count++;
                        bonus -= max;
                    }
                }
            }
            if (count >= k) return (int)max;
            else max--;
        }
        return 0;

    }
}

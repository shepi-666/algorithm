package online.labuladong.algo.dynamicprograming;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: DongShaowei
 * @create: 2024-10-05 16:23
 * @description:
 */
public class T354Envelopes {


    /**
     * 俄罗斯套娃信封问题
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes.length == 1) {
            return envelopes == null ? 0 : envelopes.length;
        }

        // 信封大小进行排序，假设第一个为长，第二个为宽
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1]; //这样是为了防止一个同样长的信封互相嵌套
            }
        });

        // 取出宽数组
        int[] widths = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            widths[i] = envelopes[i][1];
        }

        // 现在需要对width数组求 单调的递增子序列，需要使用到二分法排序
        int[] piles = new int[widths.length];
        int count = 0; // 堆数
        for (int i = 0; i < widths.length; i++) {
            // 取出当前的宽度
            int width = widths[i];
            // 二分法寻找需要放置的地方
            int l = 0, r = count;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (piles[mid] < width) {
                    l = mid + 1;
                } else if (piles[mid] > width) {
                    r = mid;
                } else if (piles[mid] == width) {
                    r = mid;
                }
            }
            if (l == count) count++;
            piles[l] = width;
        }
        return count;
    }

    @Test
    public void testSolution() {
        int[][] envelopes = { {46,89},{50,53},{52,68},{72,45},{77,81} };
        System.out.println(maxEnvelopes(envelopes));
    }




}

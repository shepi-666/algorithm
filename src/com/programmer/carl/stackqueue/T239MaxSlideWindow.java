package com.programmer.carl.stackqueue;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author: DongShaowei
 * @create: 2024-10-29 16:52
 * @description:
 */
public class T239MaxSlideWindow {

    /**
     * 滑动窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        int r = 0;
        while (r < k) {
            pq.add(nums[r++]);
        }
        res[l] = pq.peek();
        while (r < nums.length) {
            pq.add(nums[r]);
            pq.remove(nums[l]);
            r++;
            l++;
            res[l] = pq.peek();

        }
        return res;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowI(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];

        int l = 0;
        int r = 0;
        while (r < k) {
            while (!dq.isEmpty() && nums[r] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(r++);
        }

        res[l] = nums[dq.peekFirst()];

        while (r < n) {
            // 如果队尾索引指向的元素小于或者等于准备的入队的元素，直接弹出
            while (!dq.isEmpty() && nums[r] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(r++);
            l++;
            // 如果队首索引不在窗口中
            while (dq.peekFirst() < l) {
                dq.pollFirst();
            }
            res[l] = nums[dq.peekFirst()];
        }
        return res;
    }

    @Test
    public void testSolution() {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindowI(nums, k)));
    }
}

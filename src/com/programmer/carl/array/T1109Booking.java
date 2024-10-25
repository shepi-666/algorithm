package com.programmer.carl.array;

/**
 * @author: DongShaowei
 * @create: 2024-10-25 16:43
 * @description:
 */
public class T1109Booking {

    /**
     * 差分数组
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] seats = new int[n];
        int[] diff = new int[n];

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int amount = booking[2];
            diff[i] += amount;
            if (j + 1 < n) {
                diff[j + 1] -= amount;
            }
        }

        seats[0] = diff[0];
        for (int i = 1; i < n; i++) {
            seats[i] = seats[i - 1] + diff[i];
        }
        return seats;
    }
}

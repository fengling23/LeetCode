package com.leetcode.array.diffsum;

public class CorpFlightBookings_1109 {

    //差分数组
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] diffsum = new int[n+1];

        for (int[] booking:bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int count = booking[2];
            diffsum[start] += count;
            diffsum[end+1] -= count;
        }

        int[] res = new int[n];
        res[0] = diffsum[0];
        for (int i = 1; i < n; i++) {
            res[i] = diffsum[i] + res[i-1];
        }
        return res;
    }

    //空间优化后
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] diffsum = new int[n];

        for (int[] booking:bookings) {
            diffsum[booking[0]-1] += booking[2];
            if(booking[1] < n) diffsum[booking[1]] -= booking[2];
        }

        for (int i = 1; i < n; i++) {
            diffsum[i] += diffsum[i-1];
        }
        return diffsum;
    }
}

package com.leetcode.array.diffsum;

public class CorpFlightBookings_1109 {

    //差分数组
    //这样构造差分数组diff，就可以快速进行区间增减的操作，如果你想对区间nums[i..j]的元素全部加 3，那么只需要让diff[i] += 3，然后再让diff[j+1] -= 3即可：
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

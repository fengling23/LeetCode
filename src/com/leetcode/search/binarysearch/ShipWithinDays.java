package com.leetcode.search.binarysearch;

public class ShipWithinDays {

    //最小值为max(weights)
    //days等于1时,最大可能值为sum(weights)
    //二分查找左边界
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight:weights) {
            low =  Math.max(low, weight);
            high += weight;
        }

        if(days == 1)
            return high;
        if(days == weights.length)
            return low;

        while(low < high) {
            int mid = low + (high -low)/2;
            if (canFinish(weights, mid,days)) {
                high = mid;
            } else {
                low = mid +1;
            }
        }
        return low;
    }

    private int getCost(int[] weights, int cap) {
        int cost = 0, sum = 0;
        for(int weight: weights) {
            sum += weight;
            if(sum >= cap) {
                cost += 1;
                sum = sum == cap ? 0: weight;
            }
        }
        cost += (sum > 0 ? 1 : 0);
        return cost;
    }

    //某些情况下不用计算出完整的cost days, 当依次计算的cost days不满足的时候, 直接返回false; 优化时间复杂度
    private boolean canFinish(int[] weights, int cap, int days){
        int cost = 0, sum = 0;
        for (int weight: weights) {
            sum += weight;
            if(sum > cap) {
                ++cost;
                sum = weight;
                //考虑最后一轮sum刚好等于cap的情况
                if(cost>= days) { return false; }
            }
        }
        return true;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for(int weight: weights) { sum += weight; }
        return sum;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int weight:weights) { max =  Math.max(max, weight); }
        return max;
    }


}

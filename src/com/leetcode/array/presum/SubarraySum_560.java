package com.leetcode.array.presum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {

    //前缀和
    /*public int subarraySum(int[] nums, int k) {
        int res =0;
        int [] preSum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        for (int i = 1; i <= nums.length; i++){
            for (int j = 0; j < i; j++){
                if (preSum[i]-preSum[j]==k) res++;
            }
        }
        return res;
    }*/

    //暴力解法
    /*public int subarraySum(int[] nums, int k) {
        int res = 0, l = nums.length;

        for (int i = 0; i < l; i++){
            int sum = nums[i];
            if(sum == k) { res ++; }
            for (int j = i+1; j < l; j++) {
                sum += nums[j];
                if(sum == k) { res ++; }
            }
        }

        return res;
    }*/

    /*
        前缀和优化
        用一个 HashMap来建立连续子数组之和跟其出现次数之间的映射
        解题思路是遍历数组中的数字，用 sum 来记录到当前位置的累加和，建立 HashMap 的目的是为了可以快速的查找 sum-k 是否存在，即是否有连续子数组的和为 sum-k，如果存在的话，那么和为k的子数组一定也存在，
        这样当 sum 刚好为k的时候，那么数组从起始到当前位置的这段子数组的和就是k，满足题意，
        初始化要加入 {0,1} 这对映射, 如果 HashMap 中事先没有 m[0] 项的话，这个符合题意的结果就无法累加到结果 res 中
    */
    public int subarraySum(int[] nums, int k) {
        int res = 0, sum=0;

        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            res += map.getOrDefault(sum-k,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return res;
    }
}

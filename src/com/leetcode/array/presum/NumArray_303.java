package com.leetcode.array.presum;

public class NumArray_303 {

    private int[] preSum;
    public NumArray_303(int[] nums) {
        preSum = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                preSum[i] = nums[i];
            } else{
                preSum[i] = preSum[i-1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        if(left ==0) {
            return preSum[right];
        } else {
            return preSum[right] - preSum[left-1];
        }
    }

    /*public NumArray_303(int[] nums) {
        preSum = new int[nums.length+1];

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }*/
}

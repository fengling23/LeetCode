package com.leetcode.array;

public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int fast = 0, slow = 0;
        while(fast < nums.length) {
            if(nums[fast] != nums[slow]) nums[++slow] = nums[fast];
            ++fast;
        }
        return slow+1;
    }
}

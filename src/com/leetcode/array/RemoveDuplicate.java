package com.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicate {
	//快慢指针记录
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
        int j = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int length = removeDuplicates(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		System.out.println(nums.length);

	}

}

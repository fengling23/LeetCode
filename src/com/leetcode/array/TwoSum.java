package com.leetcode.array;

import java.util.HashMap;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if (m.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = m.get(target - nums[i]);
                break;
            }
            //避免sum = 2 * num(i)
            m.put(nums[i], i);
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(nums, target);
		for (int i : res) {
			System.out.println(i);
		}
		
		
	}

}

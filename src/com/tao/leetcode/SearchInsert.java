package com.tao.leetcode;

public class SearchInsert {
    public  static int solution1(int[] nums, int target){
        for ( int i = 0; i < nums.length; i++) {
            if(nums[i]>= target) {return i;}
        }
         return  nums.length;
    }

    public  static int solution2(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
package com.leetcode.search.binarysearch;

public class SearchInsert_35 {
    //遍历查找
    public  static int searchInsert(int[] nums, int target){
        for ( int i = 0; i < nums.length; i++) {
            if(nums[i]>= target) { return i; }
        }
        return  nums.length;
    }


    //二分查找
    public  static int searchInsert1(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n - 1, pos = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

}
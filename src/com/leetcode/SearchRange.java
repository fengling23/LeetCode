package com.leetcode;

public class SearchRange {

    public  static int[] solution1(int[] nums, int target){
        int[] res = {-1,-1};
        if (nums.length == 0 ){ return res;}
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        if (nums[left] != target) { return res; }
        res[0] = left;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] <= target){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        res[1] = left-1;
        return res;
    }

    public  static int[] solution2(int[] nums, int target){
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}

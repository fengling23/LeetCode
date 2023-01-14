package com.leetcode.search.binarysearch;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//如果数组中不存在目标值 target，返回 [-1, -1]
//实现时间复杂度为 O(log n) 的算法解决此问题
public class SearchRange_34 {

    public  static int[] solution1(int[] nums, int target){
        int[] res = {-1,-1};
        if (nums.length == 0 ){ return res;}
        int left = 0, right = nums.length-1;
        //先二分查找到最左边(或插入位置)的一个
        while (left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] >= target) {
                //往左逼近左边界
                right = mid;
            } else {
                left = mid+1;
            }
        }
        //不存在时
        if (nums[left] != target) { return res; }
        res[0] = left;

        //从左边界开始二分查找右边界
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


        //或者从左边界开始遍历查找右边界
        right = left+1;
        while (right < nums.length && nums[right] == target) { right++;}
        res[1] = right -1;
        return res;
    }

    //递归解法
    public  static int[] solution2(int[] nums, int target){
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        //判断出界或者不存在的情况
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    //lower为真, 寻找左边界的时候当相等时应该向左逼近
    //lower为假, 寻找右边界的时候当相等时应该向右逼近
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

package com.leetcode.search.binarysearch;

//二分查找
//要求有序
public class BinarySearch {

    //递归
    public int binarySearch1(int[] array, int e) {
        if(array.length == 0 || e < array[0] || e > array[array.length-1]){
            return -1;
        }
        return help(array, e, 0, array.length-1);
    }

    public int help(int[] array, int e, int left, int right){
        if(left < right) {
            int mid = (left + right)/2;
            if (array[mid] == e) {
                return  mid;
            } else if (array[mid] < e) {
                return help(array, e, mid+1, right);
            } else {
                return help(array, e, left, mid -1);
            }
        }
        return -1;
    }

    //非递归查找
    //每次搜索闭区间
    public int binarySearch(int[] array, int e) {
        if(array.length == 0 || e < array[0] || e > array[array.length-1]){
            return -1;
        }

        int left = 0, right = array.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = (left + right)/2;
            if (array[mid] == e) {
                return  mid;
            } else if (array[mid] < e) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    //有多个相同的值时. 返回最左边的index
    //每次搜索的时候是左闭右开区间
    public int binarySearch_left(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;

        //退出条件为left == right
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //找到 target 时不要立即返回，而是缩小「搜索区间」的上界right，在区间[left, mid)中继续搜索，即不断向左收缩，达到锁定左侧边界的目的
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        // target 比所有数都大时会, 单向递增left == right(length)
        if (left == nums.length) return -1;
        // target 比所有数都小时, 单向递减right == left(0)
        // 搜索的值不存在时, 当前的元素左右以及当前都没有找到
        return nums[left] == target ? left : -1;
    }

    //每次搜索闭区间
    public int binarySearch_left1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    //有多个相同的值时. 返回最右边的index
    //每次搜索的时候是左闭右开区间
    public int binarySearch_right(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                //找到 target 时不要立即返回，而是扩大「搜索区间」的下界left，在区间[mid+1, right)中继续搜索，即不断向右收缩，达到锁定右侧边界的目的
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (right == 0) return -1;
        return nums[right-1] == target ? (right-1) : -1;
    }

    //每次搜索闭区间
    public int binarySearch_right1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}

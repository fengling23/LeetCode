package com.leetcode.array;

//https://leetcode.cn/problems/merge-sorted-array/

public class Merge2SortedArray_88 {
    //从前往后加的时候会覆盖,转换思路从后往前加
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;
        while (i >=0 & j >= 0) {
            //相同值时需要保证nums1中的数据在前
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        //nums1中多出来的无变化
        while (j >= 0) nums1[k--] = nums2[j--];
    }

    //合并merge
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = (i>=0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }

}

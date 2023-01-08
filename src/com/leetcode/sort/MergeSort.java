package com.leetcode.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,2,6,9,1,3,4,8,7,10};
        int[] temp = new int[arr.length];
        System.out.println("交换之前：");
        Sort.show(arr);
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println("交换之后：");
        Sort.show(arr);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, temp, left, mid, right);
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        //双指针合并有序数组
        int i = left, j = mid + 1;
        int t = 0;
        while (i <= mid & j <= right) {
            if(arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }  else {
                temp[t++] = arr[j++];
            }
        }

        while (i<= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将合并后的有序数组复制到原数组中
        t = 0;
        while(left<= right){
            arr[left++] = temp[t++];
        }
    }
}

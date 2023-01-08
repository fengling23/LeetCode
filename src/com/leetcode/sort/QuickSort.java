package com.leetcode.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,6,9,1,3,4,8,7,10};
        System.out.println("交换之前：");
        Sort.show(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println("交换之后：");
        Sort.show(arr);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int k = arr[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= k) j--;
            if ( i != j ) {
                //如果右边的小于基准值,则与基准值交换位置
                arr[i] = arr[j];
                arr[j] = k;
            }


            while (i < j && arr[i] <= k) i++;
            if (i != j) {
                //如果左边的大于基准值,则与基准值交换位置
                arr[j] = arr[i];
                arr[i] = k;
            }
        }
        quickSort(arr,left, i-1);
        quickSort(arr,i+1, right);

    }
}

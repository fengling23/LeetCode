package com.leetcode.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 45, 65, 33, 1, 12};
        System.out.println("交换之前：");
        Sort.show(arr);
        insertSort(arr);
        System.out.println("交换之后：");
        Sort.show(arr);
    }

    private static void insertSort(int[] arr) {
        int curr;
        int pos;
        for (int i = 1; i < arr.length; i++){
            curr = arr[i];
            //大于当前元素的都后移
            for (pos = i; pos > 0 && arr[pos-1] > curr; pos--){
                arr[pos] = arr[pos-1];
            }
            arr[pos] = curr;
        }
    }
}

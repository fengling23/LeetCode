package com.leetcode.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：");
        Sort.show(arr);
        selectionSort(arr);
        System.out.println("交换之后：");
        Sort.show(arr);
    }

    public static void selectionSort(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
             if (arr[j] < arr[minIndex]) minIndex = j;
            }

            //交换本轮起始位置和最小值位置的值
            int temp = 0;
            if (minIndex != i){
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }


}

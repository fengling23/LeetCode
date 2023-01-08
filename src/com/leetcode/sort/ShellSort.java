package com.leetcode.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 45, 65, 33, 1, 12};
        System.out.println("交换之前：");
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println("交换之后：");
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int curr;
        int pos;
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                curr = arr[i];
                //同组内大于当前元素的都后移
                for (pos = i; pos - gap >= 0 && arr[pos - gap] > curr; pos -= gap) {
                    arr[pos] = arr[pos - gap];
                }
                arr[pos] = curr;
            }
        }
    }
}

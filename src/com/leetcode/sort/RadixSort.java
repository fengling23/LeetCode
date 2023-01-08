package com.leetcode.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 高位优先法
     *
     * @param arr 待排序列，必须为自然数
     */
    private static void radixSort(int[] arr) {
        //待排序列最大值
        int max = arr[0];
        int exp;//指数

        //计算最大值
        for (int anArr : arr) {
            if (anArr > max) {
                max = anArr;
            }
        }

        //从个位开始，对数组进行排序
        //每一位的排序使用计数排序
        for (exp = 1; max / exp > 0; exp *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将出现的次数存储在buckets中
            for (int value : arr) {
                buckets[(value / exp) % 10]++;
            }

            //计算小于个数
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            //稳定排序, 保证当前位相同时, 保持前一位的排序结果
            for (int i = arr.length - 1; i >= 0; i--) {
                int index = (arr[i] / exp) % 10;
                buckets[index]--;
                temp[buckets[index]] = arr[i];
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp, 0, arr, 0, arr.length);
        }

    }
}

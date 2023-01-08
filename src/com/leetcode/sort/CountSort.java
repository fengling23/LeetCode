package com.leetcode.sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 12, 45, 65, 33, 1, 12};
        System.out.println("交换之前：");
        System.out.println(Arrays.toString(arr));
        int[] res = countSort(arr);
        System.out.println("交换之后：");
        System.out.println(Arrays.toString(res));
    }

    private static int[] countSort(int[] arr) {
        if(arr.length <= 1) return arr;
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }

        int range = max - min + 1;
        int[] counts = new int[range];

        //计算元素出现次数
        for (int value: arr) {
            counts[value-min] += 1;
        }

        //计算小于当前元素的出现次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i-1];
        }

        //元素在新数组中的位置对应为counts数组中的value-1
        int[] res = new int[arr.length];
        //倒序遍历的时候是稳定排序, 即相同元素的数据前后顺序不变
        for (int i = arr.length-1; i >=0 ; i--) {
            int cIndex = arr[i] - min;
            counts[cIndex]--;
            res[counts[cIndex]] = arr[i];
        }
        //正序遍历的时候是非稳定排序
        /*for(int value: arr) {
            //处理多个相同值
            counts[value-min]--;
            res[counts[value-min]] = value;
        }*/
        return res;
    }


}

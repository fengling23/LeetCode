package com.leetcode.sort;

//二分查找
//要求有序
public class BinarySearch {

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
}

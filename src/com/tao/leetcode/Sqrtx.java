package com.tao.leetcode;

public class Sqrtx {
    public static int solution(int x) {
        if (x <= 1) {return x;}
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(left+","+mid+","+right);
            if (x/mid < mid) {right=mid;}
            else {left = mid+1;}
        }
        return right-1;
    }

}
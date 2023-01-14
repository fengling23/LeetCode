package com.leetcode.doublepointer.collisionpointer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MostContainerWater_11 {
	


    //暴力解法
    //超时
    public static int maxArea(int[] height) {
		int res = 0;
		for (int i = 1; i < height.length; i++) {
			for (int j = 0; j < i; j++) {
				res = Math.max(res, Math.min(height[i], height[j]) * (i - j));
			}
		}

        return res;
    }

    //对撞指针
    public static int maxArea1(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            //从较矮的那端寻找下一个
            if (height[left] < height[right]) ++left;
            else --right;
        }
        return res;
    }

    //对上面的方法进行了小幅度的优化，对于相同的高度们直接移动i和j就行了，不再进行计算容量了
    public static int maxArea2(int[] height) {
        int res = 0, left = 0, right = height.length - 1;
        int h;
        while (left < right) {
            h = Math.min(height[left], height[right]);
            res = Math.max(res, h * (right - left));
            while (left < right && h == height[left]) ++left;
            while (left < right && h == height[right]) --right;
        }
        return res;
    }


	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));

	}

}

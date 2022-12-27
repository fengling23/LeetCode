package com.leetcode.array;

public class MostContainerWater {
	
	public static int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) ++i;
            else --j;
        }
        return res;
    }
	
//	public static int maxArea(int[] height) {
//		int res = 0;
//		for (int i = 1; i < height.length; i++) {
//			for (int j = 0; j < i; j++) {
//				res = Math.max(res, Math.min(height[i], height[j]) * (i - j));
//			}
//		}
//        
//        return res;
//    }
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}

}

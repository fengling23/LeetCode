package com.leetcode.doublepointer.collisionpointer;

//升序数组
//下标从1开始
public class TwoSum_167 {

    //二分法搜索target-nums[left]
    //时间复杂度O(N*logN)
    public int[] twoSum1(int[] numbers, int target) {
        int left, right, mid;
        for (int i = 0; i < numbers.length-1; i++) {
            int diff = target - numbers[i];

            left = i+1;
            right = numbers.length-1;
            while (left <= right) {
                mid = left + (right -left)/2;
                if (numbers[mid] == diff) { return new int[]{i+1, mid+1};}
                else if (numbers[mid] < diff) { left = mid + 1;}
                else { right = mid - 1; }
            }
        }
        return  new int[]{-1, -1};
    }

    //对撞指针
    //复杂度O(n)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1 ;
        int sum;
        while ( left < right){
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return  new int[]{-1, -1};
    }
}

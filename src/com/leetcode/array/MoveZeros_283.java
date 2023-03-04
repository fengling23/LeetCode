package com.leetcode.array;

public class MoveZeros_283 {

    //快慢指针
    //相当于移除所有0的元素(27题), 再将slow之后所有元素都赋值0
    public void moveZeroes(int[] nums) {
        int fast = 0, slow = 0;
        while(fast < nums.length){
            if(nums[fast] != 0) nums[slow++] = nums[fast];
            ++fast;
        }
        while(slow < nums.length) {nums[slow++] = 0;}
    }

    //快慢指针交换
    //一个不停的向后扫，找到非零位置，然后和前面那个指针交换位置即可
    public void moveZeroes1(int[] nums) {
        int fast = 0, slow = 0;
        int temp;
        while(fast < nums.length){
            if(nums[fast] != 0) {
                //说明已经出现了0元素
                if (fast != slow) {
                    temp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = temp;
                }
                slow++;
            }
            ++fast;
        }
    }
}

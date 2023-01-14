package com.leetcode.doublepointer.collisionpointer;

public class ReverseString {

    public void reverseString(char[] s) {
        char temp;
        for(int i = 0, j = s.length -1; i < j; i++, j--){
             temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }

    public void reverseString1(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while(left < right){
            temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
    }
}

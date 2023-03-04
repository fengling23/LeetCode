package com.leetcode.stack;

public class MinAddToMakeValid_921 {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        for(char c :chars) {
            if (c == '(') {
                //需要一个右括号
                right++;
            } else {
                //右括号次数-1
                right--;
                //右括号多于左括号的时候, 左括号次数加1
                if (right == -1) {
                    right = 0;
                    left ++;
                }
            }
        }
        return left + right;
    }
}

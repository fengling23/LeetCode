package com.leetcode.stack;

import java.util.Stack;

public class IsValidParentheses_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (Character c: chars){
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && leftof(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Character leftof(Character c) {
        if(c == ')') return '(';
        else if (c == '}') return  '{';
        else return '[';
    }
}

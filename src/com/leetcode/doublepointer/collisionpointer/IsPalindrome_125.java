package com.leetcode.doublepointer.collisionpointer;

//去除非字母数字
//统一使用小写

public class IsPalindrome_125 {

    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right){
            while(left < right && !Character.isLetterOrDigit(chars[left])) { left++; }
            while(left < right && !Character.isLetterOrDigit(chars[right])) { right--; }

            if(Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
              return false;
            }

            left++;
            right--;
        }
        return true;
    }

    //删掉其他字符后反转再对比
    public static boolean isPalindrome1(String s) {
        String f = s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();
        String rf = new StringBuffer(f).reverse().toString();
        return f.equals(rf);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1("A man, a plan, a canal: Panama"));
    }
}

package com.leetcode.doublepointer.collisionpointer;

//https://leetcode.cn/problems/longest-palindromic-substring/
public class LongestPalindrome_5 {

    private static int start = 0,  end = 0, longestLen = 0;
    //中心字符向两边搜索,考虑下面2种情况
    //aba,中心字符为b
    //noon,中心字符为oo
    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() -1; i++) {
            searchPalindrome(s, i, i);
            searchPalindrome(s, i, i+1);
        }
        return s.substring(start, end);
    }

    private static void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left; ++right;
        }
        if (longestLen < right - left - 1) {
            start = left + 1;
            end = right;
            longestLen = right -left - 1;
        }
    }

    //非递归实现
    //
    public static String longestPalindrome_1(String s) {
        if (s.length() < 2) return s;
        int start = 0,  end = 0, longestLen = 0;
        int l = s.length();
        //以最后一个字符为中心的回文字符串最大长度为1
        for (int i = 0; i < l - 1; i++) {
            //右边的长度少于最长回文串的一半时,结束计算
            if(l - i <= longestLen/2) break;
            int left = i, right = i;
            //跳过重复的
            while (right < l-1 && s.charAt(right) == s.charAt(right+1)) right++;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                --left; ++right;
            }
            if (longestLen < right - left -1){
                start = left + 1;
                end = right;
                longestLen = right -left - 1;
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome_1("bb"));
    }
}

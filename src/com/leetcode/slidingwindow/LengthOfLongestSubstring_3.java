package com.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LengthOfLongestSubstring_3 {
	//https://www.cnblogs.com/grandyang/p/4480780.html
	public static int lengthOfLongestSubstring1(String s) {
		int res = 0, left = -1;
	    Map<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < s.length(); ++i) {
	        if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > left) {
	            left = map.get(s.charAt(i));
	        }
	        map.put(s.charAt(i), i);
	        res = Math.max(res, i - left);            
	    }
	    return res;
	}

	public static int lengthOfLongestSubstring2(String s) {
		int[] m = new int[256];
		Arrays.fill(m, -1);
		int res = 0, left = -1;
		for (int i = 0; i < s.length(); ++i) {
			left = Math.max(left, m[s.charAt(i)]);
			m[s.charAt(i)] = i;
			res = Math.max(res, i - left);
		}
		return res;
	}

	//滑动窗口
	public static int lengthOfLongestSubstring3(String s) {
		int res = 0, left = 0, right = 0;
		HashSet<Character> t = new HashSet<Character>();//去重

		while (right < s.length()) {
			if (!t.contains(s.charAt(right))) {
				//未检测到重复的时候,加入右指针的元素,右指针+1, 同时更新最大字符串的值
				t.add(s.charAt(right));
				right++;
				res = Math.max(res, t.size());
			} else {
				//检测到重复的时候,证明以当前左指针位置的最长字符串计算已完成,移除左指针元素同时左指针+1,计算下一位置起始的字符串长度
				t.remove(s.charAt(left));
				left++;
			}
		}
		return res;
	}


	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring1("abcabcbb"));
		System.out.println(lengthOfLongestSubstring1("bbbb"));
		System.out.println(lengthOfLongestSubstring1("pwwkew"));
	}

}
;
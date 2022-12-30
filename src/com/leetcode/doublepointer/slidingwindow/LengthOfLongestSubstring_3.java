package com.leetcode.doublepointer.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LengthOfLongestSubstring_3 {
	//https://www.cnblogs.com/grandyang/p/4480780.html
	/*
	建立一个 HashMap，建立每个字符和其最后出现位置之间的映射，然后需要定义两个变量 res 和 left，其中 res 用来记录最长无重复子串的长度，left 指向该无重复子串左边的起始位置的前一个，由于是前一个，所以初始化就是 -1，
	然后遍历整个字符串，对于每一个遍历到的字符，如果该字符已经在 HashMap 中存在了，并且如果其映射值大于 left 的话，那么更新 left 为当前映射值。然后映射值更新为当前坐标i，这样保证了 left 始终为当前边界的前一个位置，
	然后计算窗口长度的时候，直接用 i-left 即可，用来更新结果 res
	*/
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
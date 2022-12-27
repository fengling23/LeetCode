package com.leetcode.hashtable;

import java.util.Arrays;


public class NoRepeatLongestSubString {
	
//	public static int lengthOfLongestSubstring(String s) {
//        int res = 0, left = 0, right = 0;
//        HashSet<Character> t = new HashSet<Character>();
//        while (right < s.length()) {
//            if (!t.contains(s.charAt(right))) {
//                t.add(s.charAt(right));
//                right++;
//                res = Math.max(res, t.size());
//            } else {
//                t.remove(s.charAt(left));
//                left++;
//            }
//        }
//        return res;
//    }
	
//	public static int lengthOfLongestSubstring(String s) {
//		int res = 0, left = -1;
//	    Map<Character, Integer> map = new HashMap<>();
//	    for (int i = 0; i < s.length(); ++i) {
//	        if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > left) {
//	            left = map.get(s.charAt(i));
//	        }
//	        map.put(s.charAt(i), i);
//	        res = Math.max(res, i - left);            
//	    }
//	    return res;
//	}
	
	public static int lengthOfLongestSubstring(String s) {
		 int[] m = new int[128];
	     Arrays.fill(m, -1);
	     int res = 0, left = -1;
	     for (int i = 0; i < s.length(); ++i) {
	         left = Math.max(left, m[s.charAt(i)]);
	         m[s.charAt(i)] = i;
	         res = Math.max(res, i - left);
	     }
	     return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

}
;
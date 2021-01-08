package com.java.ds;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatChar {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcabcd"));
	}

	public static int lengthOfLongestSubstring(String s) {

		HashSet<Character> store = new HashSet<Character>();
		int max = 0;
		for (int i = 0, j = 0; i < s.length();) {
			if (!store.contains(s.charAt(i))) {
				store.add(s.charAt(i));
				i++;
			} else {
				i = j++;
				max = Math.max(max, store.size());
				store.clear();
			}
		}
		max = Math.max(max, store.size());
		return max;
	}
}

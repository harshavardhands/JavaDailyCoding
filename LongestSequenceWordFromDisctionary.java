package com.java.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSequenceWordFromDisctionary {

	public static void main(String[] args) {

		System.out.println(findLongestWord("abpcplea", new String[] { "ale", "apple", "monkey", "plea" }));
	}

	public static String findLongestWord(String s, String[] d) {

		if (s == null || d == null || s.isEmpty()) {
			return "";
		}

		String result = "";
		int max = 0;
		for (String str : d) {
			int count = 0;
			for (int i = 0, j = 0; i < str.length() && j < s.length(); j++) {
				if (str.charAt(i) == s.charAt(j)) {
					i++;
					count++;
				}
			}
			if (count == str.length()) {
				if (count == max) {
					if (result.compareTo(str) > 0) {
						result = str;
					}
				} else {
					max = Math.max(max, count);
					if (count == max) {
						result = str;
					}
				}
			}
		}

		return result;
	}
}

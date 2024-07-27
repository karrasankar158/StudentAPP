package com.in.utils;

import org.springframework.stereotype.Component;

@Component
public class StudentUtils {

	private static String words[] = { "NONE","ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN" };

	public static String findCount(Integer count) {
		String result = "NONE";
		if (count < 7)
			result = words[count];
		return result;
	}
}

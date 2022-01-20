package com.qa.util;

public class UtilApi {

	/**
	 * generate RandomNumber with in user provided Range. getRandomNumber(2l,
	 * 9999999999L) here L stands for Long, 'L' must be provided at the end of each
	 * Arguments
	 */
	public static long getRandomNumber(long mini_Range, long max_Range) {
		long randomNum = (long) (Math.random() * (max_Range - mini_Range + 1) + mini_Range);
		return randomNum;
	}
}

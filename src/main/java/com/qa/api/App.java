package com.qa.api;

import java.util.Random;

public class App {
	public static void main(String[] args) {
		randomAlphabeticString();
	}

	/**
	 * generate RandomNumber with in user provided Range. getRandomNumber(2l,
	 * 9999999999L) here L stands for Long, 'L' must be provided at the end of each
	 * Arguments
	 */
	public static long getRandomNumber(long mini_Range, long max_Range) {
		long randomNum = (long) (Math.random() * (max_Range - mini_Range + 1) + mini_Range);
		return randomNum;
	}
	
	
	public static String randomAlphabeticString() {
	    int leftLimit = 97; // letter 'A' 65 to 90 -> A-Z
	    int rightLimit = 122; // letter 'z' 97 to 122 -> a-z
	    int targetStringLength = 16;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit)
	      .filter(i -> (i <= 122 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println("randomAlphabeticWithUpperAndLowerString is : "+generatedString);
	    return generatedString;
	}
}

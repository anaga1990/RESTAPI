package com.qa.api.util;

import java.util.Random;
public class GenerateRandomData {
	
	public static String randomAlphabeticString() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println(generatedString);
	    return generatedString;
	}
	
	public static String randomAlphanumericString() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println(generatedString);
	    return generatedString;
	}
	
	public static String randomAlphabeticWithUpperAndLowerString() {
	    int leftLimit = 65; // letter 'A' 65 to 90 -> A-Z
	    int rightLimit = 122; // letter 'z' 97 to 122 -> a-z
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit)
	      .filter(i -> (i<= 90 || i >= 65) && (i <= 122 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    System.out.println("randomAlphabeticWithUpperAndLowerString is : "+generatedString);
	    return generatedString;
	}
	
}

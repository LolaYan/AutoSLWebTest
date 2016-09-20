package com.LottoNZ.AutoSLTest.Utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class DataGenerator {
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyz";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyz";
	public static final String numberChar = "0123456789";

	public static boolean biggerThanMaxNum(int[] zipcodelist,int max)
	{
	  for (int i : zipcodelist)
	  {
	    if (i>max) return true;
	  }
	  return false;
	}
	
	public static boolean duplicates(int[] zipcodelist)
	{
	  Set<Integer> lump = new HashSet<Integer>();
	  for (int i : zipcodelist)
	  {
	    if (lump.contains(i)) return true;
	    lump.add(i);
	  }
	  return false;
	}
	// Generate random gmail email address
	public static String generateEmail(int length) {
		String ccxl = generateString(length);
		StringBuffer sb = new StringBuffer(ccxl);
		sb.append("@autotest.com");
		System.out.println(sb);
		return sb.toString();
	}
		
	// Generate the string with the length required
	public static String generateLetters(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}

	// Generate the string with the length required
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}

	// Generate guid
	private static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

		// System.out.println("Random UUID String = " + randomUUIDString);
		// System.out.println("UUID version       = " + uuid.version());
		// System.out.println("UUID variant       = " + uuid.variant());

		return randomUUIDString;
	}

	/* */
	public static void main(String[] args) {
		// String ccxl=generateEmail(5);
		// System.out.print(ccxl);
		String uuid = generateUUID();
	}

	public static String PaddingLeftWithZero(int num, int length) {
		String number = StringUtils.leftPad(Integer.toString(num), length, "0");
		return number;
	}

	public static String PaddingLeftWithZero(String num, int length) {
		String number = StringUtils.leftPad(num, length, "0");
		return number;
	}

}

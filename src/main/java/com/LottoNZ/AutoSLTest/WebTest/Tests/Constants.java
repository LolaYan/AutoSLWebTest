package com.LottoNZ.AutoSLTest.WebTest.Tests;

import com.LottoNZ.AutoSLTest.Utils.DataGenerator;

/**
 * 
 */

/**
 * @author MRawal
 *
 */
public final class Constants {

	public static final String amount = "40";

	public static final String bankAccountAccountNum = "";
	public static final String bankAccountBankNum = "";
	public static final String bankAccountBranchNum = "";
	public static final String bankAccountSuffixNum = "";

	public static final String baseURL = "https://new1.cat.mylotto.co.nz/";
	public static final String cardNum = "4242424242424242";
	public static final String cvc = "123";
	public static final String day = "25";
	public static final String email = DataGenerator.generateEmail(8);
	public static final String existingemail = "peppa.pig@gmail.com";
	// ////////////////////////////////////////////////////
	//
	// User data is created here
	// ////////////////////////////////////////////////////
	public static final String firstname = DataGenerator.generateLetters(10);
	public static final String genderStr = "male";
	public static final String jackpotAmt = "All";
	public static final String lastname = DataGenerator.generateLetters(10);
	public static final String locStr = "Marlborough";
	public static final String lottoDipsURL = baseURL + "lotto/dips/";
	public static final String lottoPYOURL = baseURL + "lotto/pick-your-own/";
	public static final String MM = "02";
	public static final String mobileNetworkNum = "022";

	public static final String mobileNumberNum = "1234576";
	public static final String month = "February";
	public static final String password = "password1";

	public static final String regionStr = "Marlborough";
	public static final String registrationURL = baseURL + "registration/";
	public static final String securityAnswerText = DataGenerator
			.generateLetters(10);

	public static final String securityQuestionText = "What was the make of my first car?";
	public static final String topUpURL = baseURL + "top-up/";
	public static final String year = "1990";
	public static final String YY = "20";

}

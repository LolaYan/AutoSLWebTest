package com.LottoNZ.AutoSLTest.Utils.Verification;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class, TestMethodListener.class })
public class VerifyTests {
	@Test
	public void verifyEqualsTest() {

		// verify pass
		Verify.verifyEquals("test1", "test1", "test1 doesn't match");

		// verify fail (continue)
		Verify.verifyEquals("test!", "test2", "test2 doesn't match");

		// verify pass
		Verify.verifyEquals("test3", "test3", "test3 doesn't match");

		// verify fail (continue)
		Verify.verifyEquals("test#", "test4", "test4 doesn't match");

		// verify pass
		Verify.verifyEquals("test5", "test5", "test5 doesn't match");

		// verify pass
		Verify.verifyEquals("test6", "test6", "test6 doesn't match");

		// assert fail (exit)
		Assert.assertEquals("test$", "test7", "test7 doesn't match");

		// assert not run!
		Assert.assertEquals("test8", "test8", "test8 doesn't match");

		// verify not run!
		Verify.verifyEquals("test9", "test9", "test9 doesn't match");
	}
}

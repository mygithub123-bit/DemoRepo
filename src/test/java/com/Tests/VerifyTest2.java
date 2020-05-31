package com.Tests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.utility.BaseClass;
import com.utility.CustomSoftAssert;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;



public class VerifyTest2 extends BaseClass {

 
	@Test
	public void m1() {
		
		CustomSoftAssert sa1 = new CustomSoftAssert(driver);
		logger = report.startTest("VerifyCreateAccount WhitBread  Test",
				"This test will Verify Login details");
		String expected = "ABOUs";
		String actual = "ABOU";
		sa1.assertEquals(actual, expected, "passed123");
		logger.log(LogStatus.INFO, "Browser Started");

		logger.log(LogStatus.INFO, "Application Started");
		String expected1 = "VIDEOSpppa";
		String actual1 = "VIDEOSppp";
		sa1.assertEquals(actual1, expected1, "passsded456");
		sa1.assertAll();
		
	}
	
	@Parameters({ "browser" })
	@BeforeClass
	public void startBrowser(String browser) {
		System.out.println("========Test Started=========");

		driver = BrowserFactory.startBrowser(browser);

		driver.get(DataProviderFactory.getConfig().getTestURL3());

		System.out.println("=======Application launched=====");
	}
	
	
}


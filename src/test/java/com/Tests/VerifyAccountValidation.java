package com.Tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.pages.Test2;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.BaseClass;
import com.utility.BaseClass1;
import com.utility.CustomSoftAssert;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import com.utility.HelperClass;

public class VerifyAccountValidation extends BaseClass {

	@Test
	public void verifyAccountvalidation() throws InterruptedException {
		
		
	
		try {
			logger = report.startTest("Verify  Test", "This test will Verify Account Validation details");
		} catch (Exception ex) {
			System.out.println(ex.getMessage() + "/n" + ex.getStackTrace());
		}
		Test2 Validation = PageFactory.initElements(driver, Test2.class);

		logger.log(LogStatus.INFO, "Browser Started");

		logger.log(LogStatus.INFO, "Application Started");
//        try {
		Validation.LoginToGmailusername();
		//Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Username Entered");
//        }
		/*catch(Exception e) {
			
			//String base64Image=Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
			String pathOfScreenShot = com.utility.HelperClass.takeScreenshotWithTimeStamp(driver);
		logger.log(LogStatus.FAIL, e.getMessage()+ logger.addScreenCapture(pathOfScreenShot));
			//logger.log(LogStatus.FAIL, e.getMessage(),logger.addBase64ScreenShot("pathOfScreenShot"));
		}*/
        
		

		Validation.GmailNextbutton();
		logger.log(LogStatus.INFO, "clicked on Next button");

		Validation.LoginToGmailpassword();

		logger.log(LogStatus.PASS, "Password Entered");

		Validation.GmailPasswordNext();

		logger.log(LogStatus.PASS, "clicked on Next button");

		Validation.GamilGoogle_apps();

		logger.log(LogStatus.INFO, "clicked on Google_apps button");

		Validation.Gmailgmailicon();
//
		Thread.sleep(5000);

		logger.log(LogStatus.INFO, "clicked on gmailicon button");

		Validation.getTextFromElements();

		logger.log(LogStatus.INFO, "Account is Validated - User is connected to WhitBread Wifi");

		logger.log(LogStatus.INFO, "Test Completed");

		Thread.sleep(9000);

	}
	
	@Parameters({ "browser" })
	@BeforeClass
	public void startBrowser(String browser) {
		System.out.println("========Test Started=========");

		driver = BrowserFactory.startBrowser(browser);

		driver.get(DataProviderFactory.getConfig().getTestURL1());

		System.out.println("=======Application launched=====");
	}

}
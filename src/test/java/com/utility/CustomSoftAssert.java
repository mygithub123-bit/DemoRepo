package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class CustomSoftAssert extends SoftAssert {
	WebDriver driver;

	public CustomSoftAssert(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void onAssertFailure(IAssert assertCommand)  {
		String base64Image="data:image/png;base64,";
		BaseClass.logger.log(LogStatus.FAIL,
				"Failed :: Reason for Failure :: This Test Step is Failed due to Title is not displayed as Expected.");
		String pathOfScreenShot = HelperClass.takeScreenshotWithTimeStamp(driver);
		File file=new File(pathOfScreenShot);       
        try {
			 base64Image=base64Image+Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.logger.log(LogStatus.FAIL,
				"Expected Title is: " + assertCommand.getExpected() + " but Actual Title displayed is: "
						+ assertCommand.getActual() + "\n" + BaseClass.logger.addBase64ScreenShot(base64Image));
		BaseClass.logger.log(LogStatus.INFO, "End of Validation.");
	}

	@Override
	public void onAssertSuccess(IAssert assertCommand) {
		BaseClass.logger.log(LogStatus.PASS, "Passed :: Expected Title is: " + assertCommand.getExpected()
				+ " and Actual Title displayed is: " + assertCommand.getActual());
		// BaseClass.logger.log(LogStatus.INFO, "End of Validation.");
	}
	
	
	
}













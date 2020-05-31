package com.utility;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Factory.BrowserFactory;
import Factory.DataProviderFactory;

public class BaseClass1 {

	protected WebDriver driver;
	protected ExtentReports report;
	protected static ExtentTest logger1;

	@BeforeSuite
	public void setupReport() {
		report = new ExtentReports(
				System.getProperty("user.dir") + "\\Report\\" + "Wifisparks" + System.currentTimeMillis() + ".html");
	}

	@AfterSuite
	public void closeAll() {
		report.flush();
		// report.endTest(BaseClass1.logger1);
	}

	@AfterMethod
	public void tearDownReport(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = HelperClass.takeScreenshotWithTimeStamp(driver);
			BaseClass1.logger1.log(LogStatus.INFO, "Captured screenshot", BaseClass1.logger1.addScreenCapture(path));
			BaseClass1.logger1.log(LogStatus.FAIL, "TC Failed");

		}

		driver.quit();
	
	}
	@Parameters({ "browser" })
	@BeforeClass
	public void startBrowser(String browser) {
		System.out.println("========Test Started=========");

		driver = BrowserFactory.startBrowser(browser);

		driver.get(DataProviderFactory.getConfig().getTestURL1());

		System.out.println("=======Application launched=====");
	}

	@AfterClass
	public void tearDown() {

		report.endTest(BaseClass1.logger1);
		//report.endTest(BaseClass.logger);
		report.flush();

		BaseClass1.logger1.log(LogStatus.INFO, "Portal is closed");
		//BaseClass.logger.log(LogStatus.INFO, "Portal is closed");
		System.out.println("=======Test Completed===========");
	}

}

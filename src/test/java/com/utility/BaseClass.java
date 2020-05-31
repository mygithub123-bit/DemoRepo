package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class BaseClass {

	protected WebDriver driver;
	protected static ExtentReports report;
	protected static ExtentTest logger;

	@BeforeSuite
	public void setupReport() {
		report = new ExtentReports(

				System.getProperty("user.dir") + "\\Report\\" + "Wifispark" + System.currentTimeMillis() + ".html");
		//report.startReporter(reporterType., filePath)

	 
	}

	@AfterSuite
	public void closeAll() {
		
		report.flush();
		report.close();
	}

	@AfterMethod
	public void tearDownReport(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			String path = HelperClass.takeScreenshotWithTimeStamp(driver);
            File file=new File(path);        
            String base64Image=Base64.encodeBase64String(FileUtils.readFileToByteArray(file));
			logger.log(LogStatus.FAIL, "test.Captured screenshot", result.getThrowable().getMessage()+logger.addBase64ScreenShot("data:image/png;base64,"+base64Image));
			logger.log(LogStatus.FAIL, (result.getName() + " FAILED "));

			Reporter.log("browser session end", true);
	

		}
		driver.quit();
		// report.flush();
		// report.endTest(BaseClass.logger);
		// report.flush();
	}

	@Parameters({ "browser" })
	@BeforeClass
	public void startBrowser(String browser) {
		System.out.println("========Test Started=========");

		driver = BrowserFactory.startBrowser(browser);

		driver.get(DataProviderFactory.getConfig().getTestURL());

		System.out.println("=======Application launched=====");
	}

	@AfterClass
	public void tearDown() {

		report.endTest(logger);
		logger=null;
		//report.flush();

		System.out.println("=======Test Completed===========");
	}

}


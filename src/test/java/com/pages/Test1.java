package com.pages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import Factory.DataProviderFactory;
//import Testcases.whitbread_brewersfayer_autotests.utility.WhitBreadCommonMethods;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;
import com.utility.BaseClass;

public class Test1{

	//private static final String Baseclass = null;

	SoftAssert sa1 = new SoftAssert();

	WebDriver driver;

	public Test1(WebDriver ldriver) {
		driver = ldriver;
	}

	/*
	 * public CreateAccountPage_WhitBread() { PageFactory.initElements(driver,
	 * this); }
	 */

	@FindBy(css = "#checkboxSpan")
	WebElement checkbox1;

	@FindBy(css = "body.no-js:nth-child(2) section.container:nth-child(4) div.registration.col-xs-12.col-sm-offset-2.col-sm-8.col-md-offset-1.col-md-5.start div.tab-content:nth-child(3) div.tab-pane.fade.active.in:nth-child(2) form:nth-child(2) div.form-group.has-feedback:nth-child(2) label.marketing:nth-child(2) > span:nth-child(1)")
	WebElement checkbox2;

	@FindBy(xpath = "//button[contains(text(),'Create account')]")
	WebElement loginButton;

	@FindBy(xpath = "//input[@placeholder='Email address*']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password*']")
	WebElement password;

	@FindBy(xpath = "//input[@placeholder='Confirm password*']")
	WebElement confpassword;

	@FindBy(xpath = "//button[contains(text(),'Create account')]")
	WebElement ContinueButton;

	@FindBy(linkText = "Connect to Free WiFi")
	WebElement Connectfreeewifibutton;

	// below is the x-path for terms and conditions link of Registration page.
	@FindBy(xpath = "//a[text()='terms and conditions']")
	WebElement Termscondition;

	// below x-path for terms and conditions link header
	@FindBy(xpath = "//h3[@css='1']")
	WebElement TermsTitle;

	// below x-path for cross mark of terms and conditions page x mark
	@FindBy(xpath = "//a[@class='close-button']")
	WebElement Crossmark;

	// below x-path for SignIn tab
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement SignInTab;

	// below x- path for forgotten password link
	@FindBy(xpath = "//a[@class='misc-link']")
	WebElement ForgotPassword;

	// below xpath is for BacktoSign filed

	@FindBy(xpath = "//a[@class='btn btn-register']")
	WebElement BackToSignIn;

	// below x path for Continue button of forgot password page

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Continue;

	// below is the x path for ResendActivationEmail button
	@FindBy(xpath = "//a[contains(text(),'Resend activation email')]")
	WebElement ResendActivationEmail;

	/*
	 * @FindBy(xpath="//input[@id='identifierId']") WebElement
	 * ResendActivationEmail;
	 */

	// below is the x-path for Your email address of resend-Activation email
	@FindBy(xpath = "//input[@placeholder='Your email address :']")
	WebElement Youremailaddress;

	// below is the x-path for Verify email button of resend-Activation email
	@FindBy(xpath = "//button[@type='submit']")
	WebElement VerifyEmail;

	// below is the x-path for register device again
	@FindBy(xpath = "//a[@class='btn btn-register']")
	WebElement Registerdevice;
	
	
	//below xpath is for signin tab
	@FindBy(xpath="//a[@id='sign-in-tab']")
	WebElement SigninTab;

	// below is the x-path for Register Device Again for Email not validated page
	@FindBy(xpath = "//a[contains(text(),'Register device again')]")
	WebElement Registerdeviceagain;

	@FindBy(xpath = "//a[contains(text(),'Gmail')]")
	WebElement Gmail;

	public void gmail() {

		Gmail.click();

	}

	@FindBy(xpath = "//a[@class='btn btn-register']")
	WebElement Welcomeback;

	public boolean homepagedisplayed() {

		System.out.println("hii");

		boolean b = driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).isDisplayed();

		return b;

	}

	// below method is for to check whether Email is not validated page is diplayed
	// or not

	public boolean EmailnotValidated() {

		boolean b = driver.findElement(By.xpath("//a[contains(text(),'Resend activation email')]")).isDisplayed();
		return b;
	}

	public void clickOnContinueButton() {
		ContinueButton.click();

		System.out.println("clicked on Continue button");
	}

	public void LoginToApplication() throws InterruptedException {
		username.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Login", 0, 0));

		System.out.println("username entered");

		password.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Login", 0, 1));

		System.out.println("password entered");

		confpassword.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Login", 0, 2));

		System.out.println("conf password entered");

		ContinueButton.click();

		System.out.println("clicked on Continue button");

		Thread.sleep(9000);
		// verifyPageTitle();

	}

	public void LogintoResendActivationPageEmail() {

		Youremailaddress.sendKeys(DataProviderFactory.getExcelconfig().getStringData("ResendActivationEmail", 0, 0));

	}

	public boolean verifyPageTitle() {

		String expectedTitle = "You now have temporary access1";

		String actualTitle = driver.findElement(By.xpath("//h3[@class='page-header']")).getText();

		System.out.println(actualTitle);

		if (expectedTitle.equals(actualTitle)) {

			return true;
		} else {

			return false;
		}

	}

	public boolean verifyRegisterPageTitle() {

		String expectedTitle = "Register for our Free WiFippp";
		String actualTitle = driver.findElement(By.xpath("//h3[text()=' Register for our Free WiFi']")).getText();
		System.out.println("helllooo");

		if (expectedTitle.equals(actualTitle)) {

			return true;
		} else {

			return false;
		}
	}

	public void clickOncheckbox1() {
		checkbox1.click();

		System.out.println("clicked on checkbox1 button");
	}

	public void clickOncheckbox2() {
		checkbox2.click();

		System.out.println("clicked on checkbox2 button");
	}

	public void clickOnLoginButton() {
		loginButton.click();

		System.out.println("clicked on login button");
	}

	public void clickOnConnectButton() throws InterruptedException {
		Connectfreeewifibutton.click();
		System.out.println("clicked on Connect to free wifi button");

	}

	public boolean buttondisplayed1() {
		boolean b = driver
				.findElement(
						By.xpath("//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'VIDEOS')]"))
				.isDisplayed();
		/*
		 * String expected="VIDEOS"; String actual=driver.findElement(By.xpath(
		 * "//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'VIDEOS')]"
		 * )).getText(); System.out.println(actual); if(expected.equals(actual)) {
		 */
		if (b = true) {
			return true;
		} else {

			return false;

		}
	}

	public boolean buttondisplayed() {

		// String expected="ABOUT";
		boolean c = driver
				.findElement(
						By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/nav[1]/ul[1]/li[8]/a[1]/span[1]/span[1]"))
				.isDisplayed();
		// System.out.println(actual);
		/*
		 * sa1.assertEquals(actual, expected, "Page Title is displaying as : " +
		 * "actualTitle"); if(sa1.equals(false)) { if (((ITestResult) sa1).getStatus()
		 * == ITestResult.FAILURE) { String path =
		 * HelperClass.takeScreenshotWithTimeStamp(driver); }
		 */

		if (c = true) {
			return true;
		} else {

			return false;

		}
	}

	// below method is for validating tems and conditions link
	public void Termlink() {

		// Termscondition.click();

		String hompage = driver.getWindowHandle();
		System.out.println(hompage);
		driver.findElement(By.xpath("//a[text()='terms and conditions']")).click();

		String popup = driver.getWindowHandle();
		System.out.println(popup);

		java.util.Set<String> Windows = driver.getWindowHandles();
		System.out.println(Windows.size());
		// return Windows;

	}

	public String TermlinkText() {

		String termactual = TermsTitle.getText();
		return termactual;

	}

	public void Clickoncross() {

		Crossmark.click();
	}

	public void InvalidEmailLogin() {

		username.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Invalid-Login", 0, 0));
	}

	// below method is for Sign-in Tab

	public void SignInTab() {

		SignInTab.click();
	}

	// below method is for to click on forgotten password link

	public void ForgotPasswordLink() {
		ForgotPassword.click();
	}

	// below method for prividing a email address after performing a forgot password
	// link

	public void ForgotPasswordEmailLogin() {

		username.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Forgotpassword-Login", 0, 0));
	}

	// below method for clicking in BackToSignin button

	public void BacktoSignInButton() {

		BackToSignIn.click();
	}

	// below method for clicking on continue button

	public void ClickonContinue() {

		Continue.click();
	}

	// below is the method for ResendActivationEmail click

	public void ClickonResendActivationEmail() {

		ResendActivationEmail.click();
	}

	// below is the method for VerifyEmail button click

	public void VerifyEmailbutton() {

		VerifyEmail.click();
	}

	// below is the method for to click on register device again

	public void ClickonRegister() {
		Registerdevice.click();

	}

	// below is the method for to click on the Register Device Again for Email not
	// validated page
	public void ClickonRegisterDevice() {
		Registerdeviceagain.click();
	}

	// below method is for welcome back page is displayed or not

	public boolean WelcomeBackPage() {

		boolean b1 = driver.findElement(By.xpath("//h3[@class='page-header']")).isDisplayed();
		return b1;

	}

	public void WelcomebackClick() {

		Welcomeback.click();
	}

}

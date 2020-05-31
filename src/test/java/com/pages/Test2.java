package com.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Factory.DataProviderFactory;



public class Test2  {

	WebDriver driver;

	public Test2(WebDriver ldriver) {
		driver = ldriver;
	}

	@FindBy(xpath = "//input[@id='identifierId']")
	WebElement email_phone;

	@FindBy(id = "identifierNext")
	WebElement Nextbutton;

	@FindBy(xpath = "//input[@name='password']")
	WebElement Passwordgmail;

	@FindBy(id = "passwordNext")
	WebElement PasswordNext;

	// @FindBy(className = "gb_b")
	@FindBy(className = "gb_ne")
	WebElement Google_apps;

	@FindBy(xpath = "//*[@id=\"gb23\"]/span[1]")
	WebElement gmailicon;

	@FindBy(xpath = "//img[@class='ajT']")
	WebElement dotted;

	@FindBy(xpath = "//a[text()='Proceed']")
	WebElement proceed;

	public void waittest() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	public void GmailNextbutton() {

		Nextbutton.click();

		System.out.println("clicked on Nextbutton button");
	}

	public void GmailPasswordNext() {
		PasswordNext.click();

		System.out.println("clicked on PasswordNext button");
	}

	public void GamilGoogle_apps() {
		Google_apps.click();

		System.out.println("clicked on Google_apps button");
		WebDriverWait wait1 = new WebDriverWait(driver, 40);
	}

	public void Gmailgmailicon() throws InterruptedException {
		gmailicon.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		Thread.sleep(50);

		System.out.println("clicked on gmailicon button");
	}

	public void LoginToGmailusername() {
		email_phone.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Login", 0, 0));

		System.out.println("Gmail username is entered");
	}

	public void LoginToGmailpassword() {
		Passwordgmail.sendKeys(DataProviderFactory.getExcelconfig().getStringData("Login", 0, 1));

		System.out.println("Gmail password is entered");

	}

	public static void waitForElementToBeClickable(WebDriver driver, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

	}

	public void AccountsuccessValidation() throws InterruptedException {
		// driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// driver.navigate().refresh();

		Thread.sleep(9000);
	}

	public void getTextFromElements() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(16000);

		Set<String> wndHandles = driver.getWindowHandles();
		System.out.println("window handles" + wndHandles);
		String MainWindoW1 = driver.getWindowHandle();

		Iterator<String> ita1 = wndHandles.iterator();
		while (ita1.hasNext())

		{
			String Childwindow1 = ita1.next();
			System.out.println(Childwindow1);
			if (!MainWindoW1.equalsIgnoreCase(Childwindow1)) {
				driver.switchTo().window(Childwindow1);

				System.out.println("switched to child");

				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

				Thread.sleep(16000);
				List<WebElement> a = driver.findElements(By.xpath("//span[@class='bA4']"));

				Thread.sleep(15000);
				System.out.println(a.size());
				for (int i = 0; i < a.size(); i++) {
					/*
					 * try { System.out.println(a.get(i).getText()); }catch(Exception e) {
					 * e.printStackTrace(); }
					 */
					Thread.sleep(12000);
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					String getMessage = null;
					try {

						getMessage = a.get(i).getText();
					} catch (Exception e) {

						e.getMessage();
					}

					if ("welcome".equals(getMessage)) {
						a.get(i).click();

						Thread.sleep(9000);
						driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

						WebElement threedots = null;
						try {
							threedots = driver.findElement(By.xpath("//img[@class='ajT']"));
							// WebElement threedots = driver.findElement(By.xpath("//img[@class='ajT']"));

							if (threedots != null) 
							{
								//Thread.sleep(5000);
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("arguments[0].scrollIntoView();", threedots);
								threedots.click();
							}

						} catch (Exception e) {
							System.out.print(e.getMessage());
						}

						System.out.println("dotted displayed");
						Thread.sleep(4000);

						WebElement Link = driver.findElement(By.linkText("Please click here to validate your account."));

						Link.click();

						System.out.println("wait executed");
						Thread.sleep(9000);

						driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

						Set<String> AllWindowHandles = driver.getWindowHandles();
						int index = AllWindowHandles.size();
						System.out.println(index);
						System.out.println(AllWindowHandles);
						String window1 = (String) AllWindowHandles.toArray()[0];
						System.out.print("window1 handle \n= " + AllWindowHandles.toArray()[0] + "\n");

						String window2 = (String) AllWindowHandles.toArray()[1];
						System.out.print("window2 handle = " + AllWindowHandles.toArray()[1] + "\n");

						String window3 = (String) AllWindowHandles.toArray()[2];
						System.out.print("window3 handle  = " + AllWindowHandles.toArray()[2] + "\n");

						driver.switchTo().window(window3);
						Thread.sleep(5000);

						// WebElement proceed=driver.findElement(By.xpath("//a[text()='Proceed']"));

						WebElement proceed = null;
						try {
							proceed = driver.findElement(By.xpath("//a[text()='Proceed']"));

							if (proceed != null) {
								proceed.click();
								Thread.sleep(9000);
								break;
							}

						} catch (Exception e) {
							System.out.print(e.getMessage());
						}
					}
				}
			}
		}
	}
}
					

						//Thread.sleep(6000);
					
				
			
		
	


					

				

			

		

	


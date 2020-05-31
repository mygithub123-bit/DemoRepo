package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataprovider.ConfigReader;

public class BrowserFactory {

	public static WebDriver driver;

	public static WebDriver startBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("Chrome")) {
			ConfigReader config = new ConfigReader();

			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());

			driver = new ChromeDriver();
			((JavascriptExecutor) driver).executeScript("window.focus();");
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

}

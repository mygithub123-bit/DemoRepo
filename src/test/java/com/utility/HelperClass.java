package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	public static String takeScreenshotWithTimeStamp(WebDriver ldriver) {
		TakesScreenshot ts = (TakesScreenshot) ldriver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\Screenshots\\" + System.currentTimeMillis() + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("can not capture screen shot");
		}
		return path;

	}

}

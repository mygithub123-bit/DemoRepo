package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);

			System.out.println("Config file is loaded");
		} catch (Exception e) {

			System.out.println("unable to load config file" + e.getMessage());

		}
	}

	public String getChromePath() {
		return pro.getProperty("ChromePath");
	}

	public String getApplicationURL() {
		return pro.getProperty("url1");
	}

	public String getProductionURL() {
		return pro.getProperty("url2");
	}

	public String getTestURL() {
		return pro.getProperty("testurl");
	}

	public String getTestURL1() {
		return pro.getProperty("testurl1");
	}

	public String getTestURL2() {

		return pro.getProperty("testurl2");
	}

	public String getTestURL3() {

		return pro.getProperty("testurl3");
	}

	public String getTestURL4() {

		return pro.getProperty("testurl4");
	}

	public String getBrowser() {
		return pro.getProperty("Browser");
	}

}

package configdataReading;

import org.testng.annotations.Test;

import dataprovider.ConfigReader;

public class readDataConfig {
	
	@Test
	public void test1()
	
	{
		ConfigReader reader=new ConfigReader();
		
		System.out.println("Test will start on browser "+ reader.getBrowser());
		
		System.out.println("Test will start on URL "+ reader.getApplicationURL());
		
		System.out.println("Test will start on PROD URL "+ reader.getProductionURL());
	}

}

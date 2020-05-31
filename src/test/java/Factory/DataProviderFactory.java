package Factory;

import dataprovider.ConfigReader;
import dataprovider.Excelconfig;

public class DataProviderFactory {
	
	public static ConfigReader getConfig()
	{
		ConfigReader reader=new ConfigReader();
		
		return reader;
	}
	
	
	public static Excelconfig getExcelconfig()
	{
		Excelconfig reader=new Excelconfig();
		
		return reader;
	}

}

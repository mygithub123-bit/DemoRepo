package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelconfig {

	XSSFWorkbook wb;

	public Excelconfig() {
		File src = new File("./Application_TestData/Appdata.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
			System.out.println("Excel is loaded and ready to use");

		} catch (Exception e) {
			
			
			System.out.println("unable to load excel sheet");
		
		}

	}
	
	public String getStringData(String sheetName, int rowIndex, int columnIndex)
	
	{
		String data=wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	
	     return data;
	}
	
	public int getNumericData(String sheetName,int rowIndex, int columnIndex)
	{
		int data=(int)wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
		return data;
	}
	
	public void setExcelData(String sheetName, int rowIndex,int columnIndex, String result)
	{
		
		wb.getSheet(sheetName).getRow(rowIndex).createCell(columnIndex).setCellValue(result);
	}
	
	public void getData(String sheetName,int rowIndex, int columnIndex)
	{
				
		int type=wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getCellType();
	
	switch (type)
	{
	case Cell.CELL_TYPE_STRING:
	
	System.out.println("string data method has to be called");
	
	break;
	
	case Cell.CELL_TYPE_NUMERIC:
		System.out.println("Numeric data method has to be called");
		break;
	
	default:
		break;
	}
	}

}

package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main (String [] args) throws IOException{
		File source = new File("/home/iwasse/workspace/SIGAA_Automation/TestData/Inputdata.xlsx");
		
		FileInputStream fis = new FileInputStream(source);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowCount = sheet1.getLastRowNum();
	
	
		
		
		System.out.println(rowCount);
		
		for(int i = 0; i<rowCount; i++){
			
			String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
			String data1 = sheet1.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println("Data from Row " + i + " is " + data0);
			System.out.println("Data from Row " + i + " is " + data1);
		}
		
		
		wb.close();
		
	}
	
	
}

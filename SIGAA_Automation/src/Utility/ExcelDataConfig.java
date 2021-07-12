package Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	XSSFCell cell;
	
	//Construtor que passa o caminho do arquivo por parâmetro
	public ExcelDataConfig(String excelPath){
		
		try {
			File source = new File(excelPath);
			
			FileInputStream fis = new FileInputStream(source);
			
			wb = new XSSFWorkbook(fis);
			
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//método para retornar os valores da linha
	public String getData(int sheetNumber, int row, int column){
		
		//instancia objeto que formata dados numéricos das planilhas
		DataFormatter dataFormatter = new DataFormatter();
		
		sheet1 = wb.getSheetAt(sheetNumber);
		
		String data = dataFormatter.formatCellValue(sheet1.getRow(row).getCell(column));
		
		return data;
	}
	
	public String getCellData(int sheetNumber, int row, int column){
		
		try{
			sheet1 = wb.getSheetAt(sheetNumber);
			
			cell = sheet1.getRow(row).getCell(column);
			
			String cellData = cell.getStringCellValue();
			
			return cellData;
		}catch (Exception e){
			return "fail";
		}
		
	}
	
	//método que retorna o número de linhas
	public int getRowCount(int sheetIndex){
		
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		
		return (row = row + 1);
	}
	
	//método que retorna o número de colunas
	public int getColumnCount(int sheetIndex){
		
		int column = wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		
		return column;
	}
	
}

package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcelSheet {

public static void main(String[] args) throws Throwable {
		
		//step1: path connection of the physical file
		FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData.xlsx"); 
		
		//step2: keep excel file in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3: get control of the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4: set row number
		Row row = sheet.createRow(3);
		
		//step5: set cell number
	    Cell cell = row.createCell(3);
	    
	    //step6: set cell value
	    cell.setCellValue("Ashwanth");
	    
	    //step7: Excel sheet in a write mode
	    FileOutputStream fos = new FileOutputStream("/Users/babu/Documents/TestData.xlsx");
	    book.write(fos);
	    book.close();
	  
}
}
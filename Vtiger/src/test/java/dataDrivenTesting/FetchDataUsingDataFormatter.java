package dataDrivenTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataUsingDataFormatter {
	public static void main(String[] args) throws Throwable {
		
		//step1: path connection
				FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData.xlsx"); 
				
				//step2: keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//step3: get control of the sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				//step4: get control of the row
				Row row = sheet.getRow(1);
				
				//step5: get control of the cell
			    Cell cell = row.getCell(1);
			    
			    DataFormatter format = new DataFormatter();
			    String excelData = format.formatCellValue(cell);
			    System.out.println(excelData);
	}

}

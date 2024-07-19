package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelUsingMap {
	public static void main(String[] args) throws Throwable {
		
		//step1: path connection
				FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData1.xlsx"); 
				
				//step2: keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//step3: get control of the sheet
				Sheet sheet = book.getSheet("Sheet2");
				
			//	LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
				LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer,String>();
			//	map.put("10", "Babu");
			//	map.put("20", "Ashwanth");
			//	map.put("30", "Abi");
			//	map.put("40", "Yad");
				
				map.put(10, "Babu");
				map.put(20, "Ashwanth");
				map.put(30, "Abi");
				map.put(40, "Yad");
				
				
				int rowNo=0;
			//	for (Entry<String, String> m :map.entrySet())
				for (Entry<Integer, String> m :map.entrySet())
				{
					Row row = sheet.createRow(rowNo++);
				//	row.createCell(0).setCellValue((String)m.getKey());
					row.createCell(0).setCellValue((Integer)m.getKey());
					row.createCell(1).setCellValue((String)m.getValue());
					
				}
				
				FileOutputStream fos = new FileOutputStream("/Users/babu/Documents/TestData1.xlsx");
			    book.write(fos);
			    book.close();
			    System.out.println("data added successfully");

}
}
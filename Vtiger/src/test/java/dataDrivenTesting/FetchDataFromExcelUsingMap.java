package dataDrivenTesting;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelUsingMap {

public static void main(String[] args) throws Throwable {
		
		//step1: path connection
				FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData1.xlsx"); 
				
				//step2: keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//step3: get control of the sheet
				Sheet sheet = book.getSheet("Sheet2");
				int rows=sheet.getLastRowNum();
				System.out.println(rows);
				
				LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
					
				
				for (int i=0;i<=rows;i++)
				{
					String key = sheet.getRow(i).getCell(0).toString();
					String value = sheet.getRow(i).getCell(1).toString();
					map.put(key, value);
					
				}
				
				for (Entry<String, String> m :map.entrySet())
				{
					System.out.println(m.getKey()+" "+m.getValue());
				}
				
}
}
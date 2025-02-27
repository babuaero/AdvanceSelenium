package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertMultipleDataToExcelSheet {
public static void main(String[] args) throws Throwable {
		
		//step1: path connection
				FileInputStream fis = new FileInputStream("/Users/babu/Documents/TestData1.xlsx"); 
				
				//step2: keep excel file in read mode
				Workbook book = WorkbookFactory.create(fis);
				
				//step3: get control of the sheet
				Sheet sheet = book.getSheet("Sheet1");
				
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.amazon.in");
				driver.manage().window().maximize();
				
				List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
				
				for (int i=0; i < allLinks.size(); i++)
				{
					Row row = sheet.createRow(i);
					Cell cell = row.createCell(0);
				    cell.setCellValue(allLinks.get(i).getAttribute("href"));
				}
				
				
				//step7: Excel sheet in a write mode
				FileOutputStream fos = new FileOutputStream("/Users/babu/Documents/TestData1.xlsx");
			    book.write(fos);
			    book.close();			
				
}
}

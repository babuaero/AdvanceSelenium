package Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductAndDeleteProduct {

		public static void main(String[] args) throws Throwable {
			
				WebDriver driver=new ChromeDriver();
				driver.get("http://localhost:8888/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			    driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("javasel24");
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Products")).click();
		        driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		        
		        Random ran = new Random();
				int ranNum = ran.nextInt(1000);
				//Step1:- Path Connection of the physical File
				FileInputStream fis = new FileInputStream("/Users/babu/Documents/Product1.xlsx");

				        //step2:- keep Excel_File in Read mode
				         Workbook book = WorkbookFactory.create(fis);
					
				         //step3:- get control of the sheet
				         Sheet sheet = book.getSheet("Product1");
				         
				         //step4:- get control of the Row
				         Row row = sheet.getRow(0);
				         
				         //step5:- get control of the Cell
				         Cell cell = row.getCell(0);
				         
				         String prdData = cell.getStringCellValue()+ranNum;
				
		        driver.findElement(By.name("productname")).sendKeys(prdData);
		        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		        driver.findElement(By.linkText("Products")).click();
		        
		
		     
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
		        
		driver.findElement(By.xpath("//input[@value='Delete']")).click();

		driver.switchTo().alert().accept(); 
			}

	}



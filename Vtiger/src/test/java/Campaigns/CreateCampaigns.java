package Campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;

public class CreateCampaigns {

	public static void main(String[] args) throws Throwable {
	
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyData3.properties");
//		Properties pro = new Properties();
//		
//		pro.load(fis);
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME =flib.getKeyAndValueData("username");
    	String PASSWORD = flib.getKeyAndValueData("password");
			
		driver.get(URL);  
//		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		

//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		
		//Step1:- Path Connection of the physical File
//		FileInputStream fes = new FileInputStream("/Users/babu/Documents/TestData1.xlsx");
//
//		        //step2:- keep Excel_File in Read mode
//		         Workbook book = WorkbookFactory.create(fes);
//			
//		         //step3:- get control of the sheet
//		         Sheet sheet = book.getSheet("Campaigns");
//		         
//		         //step4:- get control of the Row
//		         Row row = sheet.getRow(0);
//		         
//		         //step5:- get control of the Cell
//		         Cell cell = row.getCell(0);
//		         
//		         String campData = cell.getStringCellValue()+ranNum;
		Excel_Utility elib = new Excel_Utility();
		String campData = elib.getExcelData("Campaigns", 0, 0)+ranNum;
			
	    driver.findElement(By.name("campaignname")).sendKeys(campData);
		
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@class=\"small\"])[2]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
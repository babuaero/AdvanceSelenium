package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class InsertDataToProperties_File {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("/Users/babu/Documents/PropertyData.properties"); //readmode
		Properties pro = new Properties();
		pro.load(fis);
		pro.setProperty("url", "https://www.saucedemo.com/v1/");
	    pro.setProperty("username","standard_user");
		pro.setProperty("password","secret_sauce");
		
		FileOutputStream fos = new FileOutputStream("/Users/babu/Documents/PropertyData.properties"); //writemode
		pro.store(fos, "COMMONDATA");
		System.out.println("Data added successfully");
	//	-----------------------------------------------
		//fetching Data
		
		 FileInputStream fis1 = new FileInputStream("/Users/babu/Documents/PropertyData.properties");
		 
		 //Step2 : load data into properties class
		 
			Properties pro1 = new Properties();
			pro1.load(fis1);
			String url1 = pro1.getProperty("url");
			String username1 = pro1.getProperty("username");
			String password1 = pro1.getProperty("password");
			WebDriver driver = new ChromeDriver(); 
			driver.get(url1);
			driver.findElement(By.id("user-name")).sendKeys(username1);
			driver.findElement(By.id("password")).sendKeys(password1);	    
			driver.findElement(By.className("btn_action")).click();	  
}
}
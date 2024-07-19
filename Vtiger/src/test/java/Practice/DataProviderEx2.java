package Practice;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx2 {
	@Test(dataProvider ="getReadData")
	public  void createOrganization(String orgName,String phnNum,String email) throws Throwable
	{
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("javasel24");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	driver.findElement(By.id("phone")).sendKeys(phnNum);
	driver.findElement(By.id("email1")).sendKeys(email);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[@class=\"small\"])[2]")).click();
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	}
    @DataProvider
	public Object[][] getReadData()
	{
		Object[][] objArr = new Object[3][3];
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		objArr[0][0]="Babu"+ranNum;
		objArr[0][1]="7788899999";
		objArr[0][2]="abc@gmail.com";
		
		objArr[1][0]="BabuRam";
		objArr[1][1]="7788899988";
		objArr[1][2]="def@gmail.com";
		
		objArr[2][0]="BabuRamKumar";
		objArr[2][1]="7788899933";
		objArr[2][2]="ghi@gmail.com";
		return objArr;
			
	}	
}


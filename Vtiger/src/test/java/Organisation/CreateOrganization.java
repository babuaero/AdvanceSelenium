package Organisation;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;

import org.openqa.selenium.NoSuchElementException;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValueData("url");
		String USERNAME =flib.getKeyAndValueData("username");
    	String PASSWORD = flib.getKeyAndValueData("password");
			
		driver.get(URL);  
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("javasel24");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("[alt='Create Organization...']")).click();
//		
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		driver.findElement(By.name("accountname")).sendKeys("Qspiders"+ranNum);
		driver.findElement(By.id("phone")).sendKeys("9998885252");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(2000);
	//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("(//td[@class=\"small\"])[2]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}

	}

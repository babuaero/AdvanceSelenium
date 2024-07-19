package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DebugEx {
	
	public static void main(String[] args) {
	

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");
	
	driver.findElement(By.name("q")).sendKeys("puma");
	driver.findElement(By.xpath("//button[@type='submit']")).click();

}
}
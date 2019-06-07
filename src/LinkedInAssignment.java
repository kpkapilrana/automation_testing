

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * @author Admin
 *
 */
public class LinkedInAssignment
{
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;

 @BeforeTest
 public void TestSetup()
{
	// Set the path of the Firefox driver.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Legend's/eclipse-workspace/Java Selenium/drivers/chromedriver.exe");
        driver = new ChromeDriver();
	// Enter url.
	driver.get("http://www.linkedin.com/");
	driver.manage().window().maximize();
	
	wait = new WebDriverWait(driver,30);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	 
 @Test
public void ReadData() throws InterruptedException
 {
//		 driver.findElement(By.id("login-email")).sendKeys("patil.sushil85@gmail.com");
//		 
//		 driver.findElement(By.id("login-password")).sendKeys("Rajput12345");
//		 driver.findElement(By.id("login-submit")).click();
//		
//		 driver.findElement(By.xpath("//*[@id=\"ember33\"]/input")).sendKeys("Automation jobs");
//		 driver.findElement(By.xpath("//*[@id=\"ember33\"]/input")).sendKeys(Keys.ENTER);
//		    	
//		WebElement al =  driver.findElement(By.tagName("ul"));
//		 
//		List<WebElement> al2 = al.findElements(By.tagName("li"));
//		

	 int a[] = {2,3,3,4,5,6,7,7,7,9};
	 
	 ArrayList<Integer> al = new ArrayList<Integer>();
	 int c=0;
	 
	
	 
	 for (int i=0;i<a.length;i++) {
		 if(!al.contains(a[i])) {
			 al.add(a[i]);
		 }
		 }
	 System.out.println(al);
	
 }
 } 

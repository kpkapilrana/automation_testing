package Locators;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locate {

	
	WebDriver driver;
	//String url = "file:///C:/Users/Legend's/Downloads/LocatingMultipleElements.html";
	
	String url = "https://www.ixigo.com/trains";
	@BeforeSuite
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Legend's/eclipse-workspace/Java Selenium/drivers/chromedriver.exe");

//		System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
	}
	
	@Test
	public void test() {
		// TODO Auto-generated method stub
		
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		
//	
//	//	WebElement Fname = driver.findElement(By.name("firstname"));
//		WebElement Lname = driver.findElement(By.id("lname"));
//		
//		WebElement Designation = driver.findElement(By.id("designation"));
//		Select dropdown= new Select(Designation);
//		
//		dropdown.selectByVisibleText("Programmer");
//		
//		WebElement Gender1 = driver.findElement(By.name("gender"));
//		Gender1.click();
////		WebElement Gender2 = driver.findElement(By.name("gender"));
////		
//		WebElement Fname = driver.findElement(By.xpath("//input[@type='text'or @name='firstnames']"));
//		
//		//Gender.click();
//		WebElement Tryit = driver.findElement(By.name("theButton"));
//		
//
//		
//		Fname.sendKeys("Sushil");
//		Lname.sendKeys("Patil");
//
		
		
//		Tryit.click();

		
		
//		driver.findElement(By.linkText("1234 Hello, Naresh")).click();


//		TakesScreenshot scrShot =((TakesScreenshot)driver);
//		
//		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//
//
//		File DestFile=new File("E:/test.png");
//
//        //Copy file at destination
//
//        FileUtils.copyFile(SrcFile, DestFile);


	}

}

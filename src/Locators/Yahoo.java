package Locators;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class Yahoo {

	
	WebDriver driver;
	String url = "https://login.yahoo.com/account/create?specId=yidReg";
//	String url = "http://store.demoqa.com/";
	
	@BeforeSuite
	public void beforeTest() {
		
		System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   
	}

	
	@Test
	public void Login() throws IOException, InterruptedException {
		
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Yahoo"; 
		
		assertEquals(actualTitle, expectedTitle);
		assertTrue(driver.getTitle().contains("Yahoo"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("Yahoo"));
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText.contains("Sign in"), "Text not found!");
		
		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("akshay");
		
        driver.findElement(By.id("usernamereg-lastName")).sendKeys("pawar");
      
        driver.findElement(By.id("usernamereg-yid")).sendKeys("akshaypawar2000");
        
        driver.findElement(By.id("usernamereg-password")).sendKeys("rana1234");
        
        driver.findElement(By.id("usernamereg-phone")).sendKeys("9604920627");
	
		Select month = new Select(driver.findElement(By.id("usernamereg-month")));
 		month.selectByVisibleText("May");
	
		driver.findElement(By.id("usernamereg-day")).sendKeys("22");
			
		driver.findElement(By.id("usernamereg-year")).sendKeys("2000");
		
		driver.findElement(By.id("usernamereg-day")).sendKeys("22");
	
		driver.findElement(By.id("usernamereg-freeformGender")).sendKeys("Male");
		driver.findElement(By.id("reg-submit-button")).click();
	
		driver.findElement(By.tagName("button")).click();
	
//		driver.findElement(By.xpath("//*[@id=\"social-media\"]/ul/li[3]/a")).click();
		
	}
	 
    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite method");
    }
     
    @AfterTest
    public void afterTest() {
        System.out.println("After Test method");
        
    }
     
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class method");
    }
 
    @AfterClass
    public void afterClass() {
        System.out.println("After Class method");
    }
 
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }
 
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
  
    }
}

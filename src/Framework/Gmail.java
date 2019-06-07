package Framework;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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



public class Gmail {

	
	WebDriver driver;
	String url = "https://accounts.google.com/";
	String expected = "patil.sushil85@gmail.com";
	
	@BeforeSuite
	public void beforeTest() {
		
		System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
	}
	
	@Test
	public void Login() throws IOException, InterruptedException {
		
		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("patil.sushil85");
		WebElement submit = driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
		
		submit.click();
	
		String actual = driver.findElement(By.xpath("//*[@id=\"profileIdentifier\"]")).getText();
		System.out.println(actual);
		assertEquals(actual, expected, "Welcome");
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Rajput12345");
      

        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a")).click();
         
        driver.findElement(By.xpath("//*[@id=\"gb23\"]")).click();
		
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
        
        String actual = driver.getTitle();
        System.out.println(driver.getCurrentUrl());
        assertEquals(actual, "Inbox (11,949) - patil.sushil85@gmail.com - Gmail", "successful");
    }
}

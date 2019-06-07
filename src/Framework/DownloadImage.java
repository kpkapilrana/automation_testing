package Framework;


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


//import com.asprise.util.ocr.OCR;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class DownloadImage {

	
	WebDriver driver;
	String url = "https://www.google.com/gmail/about/#";
	
	@BeforeSuite
	public void beforeTest() {
		
		System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
	}
	
	@Test
	public void Login() throws IOException, InterruptedException {
		
		
		  List links = driver.findElements(By.tagName("img"));
		  		  
		  for (int i = 0; i < links.size(); i++) {
	            
			  
	                // Iterating through the array list and getting the URL's
	                String nextHref = ((WebElement) links.get(i)).getAttribute("src");
	                Thread.sleep(15);
	                URL imageURL = new URL(nextHref);
	                
	                String fileName = imageURL.getFile();
	                String destName = "E:/img" + fileName.substring(fileName.lastIndexOf("/"));
	             
	                InputStream is = imageURL.openStream();
	            	OutputStream os = new FileOutputStream(destName);
	           
	            	byte[] b = new byte[2048];
	            	int length;
	             
	            	while ((length = is.read(b)) != -1) {
	            		os.write(b, 0, length);
	            	}
	             
	            	is.close();
	            	os.close();
	                
	}
	}
	
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite method");
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

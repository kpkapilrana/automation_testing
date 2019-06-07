package Framework;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
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
import static org.testng.Assert.assertTrue;
 


public class AddUser {

	
	WebDriver driver;
	List<WebElement> rows;
	String url = "http://localhost:8888/connect2tech.in-Selenium-Automation-Java-1.x/users";
	int num;
	@BeforeSuite
	public void beforeTest() {
		
		System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
	}
	
	@Test
	public void Login() throws IOException, InterruptedException {
	
		rows = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr"));

		List<WebElement> columns = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td"));
		
		String color = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[5]/button[1]")).getCssValue("color");

		Boolean submitbuttonPresence=driver.findElement(By.className("btn-primary")).isEnabled();
		

		num = rows.size();
		assertTrue(num == 15);
		assertTrue(columns.size() == 5);
		assertEquals(color, "rgba(255, 255, 255, 1)");
		System.out.println("Color of query button = "+ color);
		System.out.println("Verify Update button is enabled = "+submitbuttonPresence);

		driver.findElement(By.linkText("Add User")).click();

		WebElement name = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/label"));
		WebElement email = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[2]/label"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[3]/label"));
		WebElement confPass = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[4]/label"));
		WebElement address = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[5]/label"));
		WebElement newsLetter = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[6]/label"));
		WebElement webFrame = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[7]/label"));
		WebElement sex = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[8]/label"));
		WebElement number = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[9]/label"));
		WebElement country = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[10]/label"));
		WebElement javaSkill = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[11]/label"));
		
		
		System.out.println("=="+name.getText());
		System.out.println(email.getText());
		System.out.println(password.getText());
		System.out.println(confPass.getText());
		System.out.println(address.getText());
		System.out.println(newsLetter.getText());
		System.out.println(webFrame.getText());
		System.out.println(sex.getText());
		System.out.println(number.getText());
		System.out.println(country.getText());
		System.out.println(javaSkill.getText());
		
		
	}
	 
	@Test
	public void fillForm() {
		
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Sushil");
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("patil.sushil85@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345");
		
		driver.findElement(By.name("confirmPassword")).sendKeys("12345");
		
		driver.findElement(By.xpath("//*[@id=\"address\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Pune");
		driver.findElement(By.className("btn-primary")).click();
		
		driver.findElement(By.linkText("Existing Users")).click();
		
		int temp = num;
		System.out.println("Before"+ temp);
		rows.clear();
		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr"));
	
		if(rows.size() > temp) { 
			System.out.println("Record inserted successfully"+ rows.size());
		}
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


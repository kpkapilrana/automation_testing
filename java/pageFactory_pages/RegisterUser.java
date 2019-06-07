package pageFactory_pages;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterUser {
	
	WebDriver driver;
	
	
	@FindBy(linkText="Add User")
	WebElement addUser;

	@FindBy(name="name")
	WebElement name;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="confirmPassword")
	WebElement confPassword;
	
	@FindBy(name="address")
	WebElement address;
	
	@FindBy(name="newsletter")
	WebElement news;
	 
	@FindBy(className="btn-primary")
	WebElement Save;
	
	@FindBy(linkText="Existing Users")
	WebElement existingUser;
	
	

	/* Label */
		
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[1]/label")
//	WebElement nameLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[3]/label")
//	WebElement emailLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[3]/label")
//	WebElement passLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[4]/label")
//	WebElement confPassLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[5]/label")
//	WebElement addressLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[6]/label")
//	WebElement newsLetterLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[7]/label")
//	WebElement webFrameLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[8]/label")
//	WebElement sexLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[9]/label")
//	WebElement numberLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[10]/label")
//	WebElement counttyLabel;
//	
//	@FindBy(xpath="//*[@id=\\\"userForm\\\"]/div[11]/label")
//	WebElement javaSkillLabel;

	
	public RegisterUser(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
	
	public void goToAddUser() {
		addUser.click();
		
		}
	
		 public void setName(String strName){
			 	name.clear();
		        name.sendKeys(strName);     
		    }

		 public void setEmail(String strEmail){
			 	email.clear();
		        email.sendKeys(strEmail);     
		    }

		 public void setPass(String strPass){
			 
		        password.sendKeys(strPass);     
		    }
	
		 public void setConfPass(String strConfPass){
			 
			 confPassword.sendKeys(strConfPass);     
		    }

		 public void setAddress(String strAdd){
			 	address.clear();
		        address.sendKeys(strAdd);     
		    }
		 
		 public void setNews(String answer) {
			 if(answer.equals("No")) {
				 news.click();
			 }
		 }
		 

		public void clickLogin(){

			Save.click();

		}  
		
		 public void Register(String setName, String setEmail,String setPass,String confPass,String add, String news){

		        //Fill user name
			 	
		        this.setName(setName);
		        this.setEmail(setEmail);
		        this.setPass(setPass);
		        this.setConfPass(confPass);
		        this.setAddress(add);
		        this.setNews(news);
		        this.clickLogin();  
		        
		        WebDriverWait wait2 = new WebDriverWait(driver, 10);
//		        wait2.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.id("confirmPassword.errors"))));
	        	
		        String actual = driver.findElement(By.id("confirmPassword.errors")).toString();
		        System.out.println(actual);
	        	
//		        if(!(setPass.equals(confPass))) {
//		        	String actual = driver.findElement(By.id("confirmPassword.errors")).toString();
//		        	System.out.println(actual);
//		        	assertEquals(actual, "Passwords do not match, please retype!");
//		        }

		    }
		 
			public void VerifyTitle() {
				// TODO Auto-generated method stub
				String actualTitle = driver.getTitle();
				String expectedTitle = "connect2tech.in-Selenium-Automation-Java-1.x";
				
				assertEquals(actualTitle, expectedTitle);

			}
			
	
			public void VerifyLabel() {
				goToAddUser();
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

				assertEquals(name.getText(), "Name");
				assertEquals(email.getText(), "Email");
				assertEquals(password.getText(), "Password");
				assertEquals(confPass.getText(), "confirm Password");
				assertEquals(address.getText(), "Address");
				assertEquals(newsLetter.getText(), "Newsletter");
				assertEquals(webFrame.getText(), "Web Frameworks");
				assertEquals(sex.getText(), "Sex");
				assertEquals(number.getText(), "Number");
				assertEquals(country.getText(), "Country");
				assertEquals(javaSkill.getText(), "Java Skills");
				
			}

			public void VerifyMessages() {
				// TODO Auto-generated method stub
				goToAddUser();
				name.clear();
				email.clear();
				address.clear();
				
				Save.click();
				assertEquals(driver.findElement(By.id("name.errors")).getText(), "Name is required!");
				assertEquals(driver.findElement(By.id("email.errors")).getText(), "Email is required!\nInvalid Email format!");
				assertEquals(driver.findElement(By.id("password.errors")).getText(), "Password is required!");
				assertEquals(driver.findElement(By.id("confirmPassword.errors")).getText(), "Confirm password is required!");
				assertEquals(driver.findElement(By.id("address.errors")).getText(), "Address is required!");
			}
	}

	



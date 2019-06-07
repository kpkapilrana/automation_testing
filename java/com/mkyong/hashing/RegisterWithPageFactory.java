package com.mkyong.hashing;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mkyong.hashing.ExcelFile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import pageFactory_pages.RegisterUser;

import pageFactory_pages.VerifyUserAdded;

public class RegisterWithPageFactory {

    WebDriver driver;

    RegisterUser objLogin;
    VerifyUserAdded checkUser;
    ExcelFile file;
    
    @BeforeTest
    public void setup(){

    	System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
        driver = new FirefoxDriver();
        file = new ExcelFile();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8888/connect2tech.in-Selenium-Automation-Java-1.x/users");

      //  driver.findElement(By.linkText("Add User")).click();
    }

    /**

     * This test go to http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message
     * @throws IOException 

     */

    @Test(priority=1, description="This case is to register new user")
    public void test_Home_Page_Appear_Correct() throws IOException{

        //Create Login Page object

    objLogin = new RegisterUser(driver);

    //Register to application

    Sheet sheet1 = file.readExcel("TestCase.xlsx","Sheet1");
    int rowCount = sheet1.getLastRowNum()
			- sheet1.getFirstRowNum();
    
    for (int i = 1; i < rowCount+1; i++) {
		// Loop over all the rows
		
		if (sheet1.getRow(i).getCell(0).toString().length() != 0) {
			Row row = sheet1.getRow(i);
			objLogin.Register(row.getCell(0).toString(), row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(), row.getCell(4).toString(), row.getCell(5).toString());
			objLogin.goToAddUser();
    }
		else {
			System.out.println("Record inserted");
			break;
		}
    }
    }
    
    
    
    
    @Test(priority=2, description="This case is to check user added in system or not")
    public void test_New_User_added(){

        //Create Login Page object

    checkUser = new VerifyUserAdded(driver);

    //Register to application

    checkUser.checkUserAdded("patil.sushil85@gmail.com");

    }
    

    @Test(priority=8, description="To verify title of page")
    public void test_Title() {
    	objLogin = new RegisterUser(driver);
    	
    	objLogin.VerifyTitle();
    }
    
    
    @Test(priority=7, description="To verify number of rows in screen 1")
    public void test_row_number() {
    	checkUser = new VerifyUserAdded(driver);
    	checkUser.VerifyRow();
    }
    
    @Test(priority=6, description="To verify number of Columns in screen 1")
    public void test_column_number() {
    	checkUser = new VerifyUserAdded(driver);
    	checkUser.VerifyCol();
    }
    
    @Test(priority=5, description="To verify Query button color in screen 1")
    public void test_queryButton_color() {
    	checkUser = new VerifyUserAdded(driver);
    	checkUser.VerifyButtonColor();
    
    }
    
    @Test(priority=4, description="To verify Update button enabled or disables in screen 1")
    public void test_updateButton_state() {
    	
    	checkUser = new VerifyUserAdded(driver);
    	checkUser.VerifyUpdateButton();
    
    }

    @Test(priority=3, description="To verify labels of Add User page")
    public void test_label() {
    	 objLogin = new RegisterUser(driver);
    	objLogin.VerifyLabel();
    }
    	

    @Test(priority=0, description="To verify error messages Add User page")
    public void test_error_message() {
    	 objLogin = new RegisterUser(driver);
    	 objLogin.VerifyMessages();
    }
}
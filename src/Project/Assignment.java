package Project;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * @author Admin
 *
 */
public class Assignment
{
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

 @BeforeTest
 public void TestSetup()
{
	// Set the path of the Firefox driver.
	 System.setProperty("webdriver.firefox.marionette", "geckodriver.exe");
	driver = new FirefoxDriver();
	
	// Enter url.
	driver.get("http://www.linkedin.com/");
	driver.manage().window().maximize();
	
	wait = new WebDriverWait(driver,30);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
 
 @Test(description="This is to login to linkedIn")
 public void ReadData() throws IOException
 {
	 // Import excel sheet.
	 File src=new File("TestCase.xlsx");
	 
	 // Load the file.
	 FileInputStream finput = new FileInputStream(src);
	 
	 // Load he workbook.
	Workbook workbook = new XSSFWorkbook(finput);
	 
     // Load the sheet in which data is stored.
	 Sheet sheet= workbook.getSheet("Sheet1");
	 
	 for(int i=1; i<sheet.getLastRowNum(); i++)
	 {
		 // Import data for Email.
		 cell = (XSSFCell) sheet.getRow(i).getCell(1);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
		 
		 // Import data for password.
		 cell = (XSSFCell) sheet.getRow(i).getCell(2);
		 cell.setCellType(Cell.CELL_TYPE_STRING);
		 driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
		
		 driver.findElement(By.id("login-submit")).click();
		 // Write data in the excel.
	   FileOutputStream foutput=new FileOutputStream(src);
		
		// Specify the message needs to be written.
		String message = "Data Imported Successfully.";
		

		// Create cell where data needs to be written.
		sheet.getRow(i).createCell(3).setCellValue(message);
		 
		// Specify the file in which data needs to be written.
	    FileOutputStream fileOutput = new FileOutputStream(src);
	    
	    // finally write content
	    workbook.write(fileOutput);
		
	     // close the file
	    fileOutput.close();
	    	
	 }
 } 
}
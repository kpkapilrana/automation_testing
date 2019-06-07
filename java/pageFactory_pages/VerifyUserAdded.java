package pageFactory_pages;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyUserAdded {
	
	WebDriver driver;
	
	@FindBy(linkText="Existing Users")
	WebElement existingUser;
		
	
	public VerifyUserAdded(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }   
		
		public void goToExisting() {
		existingUser.click();
		
		}

		

		public void checkUserAdded(String email) {

			goToExisting();
			
			List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr/td[3]"));
		
			 for (int column = 0; column < rows.size(); column++) {
	    	        // To retrieve text from that specific cell.
	    	        String celtext = rows.get(column).getText();
	    	        
	    	        if(celtext.contains(email)) {
	    	        	System.out.println("Record inserted successfully"+ rows.size());
	    	        	break;
	    	    }			 
		}
	}
				
		public void VerifyRow() {
			// TODO Auto-generated method stub
			 goToExisting();
			 int actual = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr")).size();
			 assertEquals(actual, 12);
		}
		
		public void VerifyCol() {
			// TODO Auto-generated method stub
			 goToExisting();
			 int actual = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td")).size();
			 assertEquals(actual, 5);
		}
		
		public void VerifyButtonColor() {
			String color = driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[5]/button[1]")).getCssValue("color");
			assertEquals(color, "rgba(255, 255, 255, 1)");
		}

		public void VerifyUpdateButton() {
		goToExisting();
		boolean actual=driver.findElement(By.className("btn-primary")).isEnabled();
			assertEquals(actual, true);
		}
		

				
}
		

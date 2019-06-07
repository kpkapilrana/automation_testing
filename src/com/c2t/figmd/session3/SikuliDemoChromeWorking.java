package com.c2t.figmd.session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SikuliDemoChromeWorking {

	public static void main(String[] args) throws FindFailed {

		
		Pattern pattern1 = new Pattern("C:/Users/Legend's/Downloads/Img-Text1.PNG");
		Pattern pattern2 = new Pattern("C:/Users/Legend's/Downloads/Img-Save1.PNG");
		Pattern path = new Pattern("C:/Users/Legend's/Downloads/path.PNG");
//		Pattern pattern3 = new Pattern("D:/nchaurasia/Automation-Architect/img/DownArrow-08.01.2019.jpg");
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:/Users/Legend's/eclipse-workspace/Java Selenium/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Legend's/Downloads/FileUpload.html");
		driver.findElement(By.name("fileToUpload")).click();
		
		Screen s = new Screen();
		
		//s.click(pattern3);
		s.wait(pattern1,5);
		
		s.type(pattern1, "hello.txt");
	 	s.click(path);
		s.wait(path,5);
	
		s.click(pattern2);
		
	}

}

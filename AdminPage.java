package com.ibm.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibm.test.Login;
import com.ibm.utilities.PropertiesFileHandler;

public class AdminPage{

	WebDriverWait wait;
	WebDriver driver;
	//PropertiesFileHandler propFileHandler;
	//HashMap<String, String> data;
		
		@Test
		public void testCase3() throws IOException, InterruptedException {
			FileInputStream file = new FileInputStream("./TestData/data.properties");
			Properties prop = new Properties();
			prop.load(file);
			String url = prop.getProperty("url");
			String username = prop.getProperty("user");
			String password = prop.getProperty("password");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 60);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Login login = new Login(driver, wait);
			
			login.enterEmailAddress(username);
			login.enterPassword(password);
			login.clickOnLogin();
			
			WebElement marketingEle=driver.findElement(By.linkText("Marketing"));
			marketingEle.click();
			
			WebElement mailEle=driver.findElement(By.linkText("Mail"));
			mailEle.click();
			Thread.sleep(3000);
			WebElement actionEle=driver.findElement(By.cssSelector("span.caret"));
			actionEle.click();
			
			WebElement editEle=driver.findElement(By.linkText("Edit"));
			editEle.click();
			
			WebElement saveEle=driver.findElement(By.cssSelector("i.fa.fa-save"));
			saveEle.click();
			
		}
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("valid")));
	}

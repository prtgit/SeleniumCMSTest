package com.testscripts;

import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cmstest.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	@BeforeClass
	public void beforeClass(){
		 System.out.println("Hi Devansh");
		 System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Selenium 2.44\\chromedriver.exe");		
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("disable-infobars");
	     options.addArguments("--disable-extensions");
	     options.addArguments("--disable-notifications");
	     options.addArguments("--start-maximized");
	     options.addArguments("--disable-web-security");
	     options.addArguments("--no-proxy-server");
	     options.addArguments("--enable-automation");
	     options.addArguments("--disable-save-password-bubble");

	     Map<String, Object> prefs = new HashMap<String, Object>();
	     prefs.put("credentials_enable_service", false);
	     prefs.put("profile.password_manager_enabled", false);
	     options.setExperimentalOption("prefs", prefs);
		System.out.println("Hi");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(capabilities);
		driver.get("http://localhost:8081/CourseManagementSystem/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest(){
		
		System.out.println(driver);
		LoginPage login = new LoginPage(driver);
		login.enterUserName("alby");
		login.enterPassword("hogwarts");
		login.hitLogin();
	}
	
	@ AfterClass
    public void afterMethod() {
		if (driver != null) {
		    driver.quit();
		}
    }

}

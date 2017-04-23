package com.cmstest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id="userName")
	private WebElement uname;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;	
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username){
//		uname.clear();
		uname.sendKeys(username);
	}
	
	public void enterPassword(String password){
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void hitLogin(){
		loginButton.click();
	}
	
	

}

package com.vtiger.comcast.pomrepositylib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")
		private WebElement usernameedt;
	
	@FindBy(name = "user_password")
	private WebElement userpasswordedt;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getUserpasswordedt() {
		return userpasswordedt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
 public void LoginToApp(String username,  String password) {
	 usernameedt.sendKeys(username);
	 userpasswordedt.sendKeys(password);
	 loginbtn.click();
 }
}



package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOut {
    WebDriver driver;
	public LogOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homepagelink;

	public WebElement getHomepagelink() {
		return homepagelink;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getSignout() {
		return signoutlink;
	}
	
	public void logOut() {
	//	homepagelink.click();
		Actions action = new Actions(driver);
		action.moveToElement(logout).perform();
		signoutlink.click();
		
	}

	

}

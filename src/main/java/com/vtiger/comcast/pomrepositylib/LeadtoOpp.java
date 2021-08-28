package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadtoOpp {
WebElement driver;
	public LeadtoOpp(WebDriver driver)  {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(linkText="Convert Lead")
	private WebElement leadtoopp;
	
	@FindBy(id="select_potential")
	private WebElement selectoppertunity;
	
	@FindBy(xpath="//img[@src='themes/images/miniCalendar.gif']")
	private WebElement calenderclick;
	
	@FindBy(xpath="(//td[@class='day selected today'])[1]")
	private WebElement date;
	
	@FindBy(name="closingdate")
	private WebElement expdateclick;
	
	@FindBy(xpath="//input[@name='amount']")
	private WebElement amount;
	
	@FindBy(name="Save")
	private WebElement save;
	
	//@FindBy(xpath="(//img[@src='themes/images/close.gif'])[3]")
	//private WebElement close;
	
	@FindBy(xpath="//input[@value='Cancel']")
	private WebElement cancelbtn;
	
	@FindBy(xpath="//td[text()='Convert Lead :  yangunde123']")
	private WebElement header;
	
	//public WebElement getClose() {
		//return close;
	//}

	@FindBy(linkText = "Organizations")
	private WebElement organizationslink;
	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getDriver() {
		return driver;
	}

	public WebElement getLeadtoopp() {
		return leadtoopp;
	}

	public WebElement getSelectoppertunity() {
		return selectoppertunity;
	}

	public WebElement getCalenderclick() {
		return calenderclick;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getExpdateclick() {
		return expdateclick;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getOrganizationslink() {
		return organizationslink;
	}
	
	public void convertlead(String expdate) {
		leadtoopp.click();
		selectoppertunity.click();
		calenderclick.click();
		expdateclick.sendKeys(expdate);
		save.click();
	}
		public void convertlead(String expdate, String validamount) {
			leadtoopp.click();
			selectoppertunity.click();
			calenderclick.click();
			expdateclick.sendKeys(expdate);
			amount.sendKeys(validamount);
			save.click();
		
	}

		public void convertlead(String expdate, String invalidamount, boolean flag) {
			leadtoopp.click();
			selectoppertunity.click();
			calenderclick.click();
			expdateclick.sendKeys(expdate);
			amount.sendKeys(invalidamount);
			save.click();		
		
	}
    
}

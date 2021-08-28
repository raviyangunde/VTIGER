package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads {

	public Leads(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		@FindBy(linkText="Leads")
		private WebElement leadlink;
		
		@FindBy(xpath="//img[@title='Create Lead...']") 
		private WebElement addleadlink;
		
		@FindBy(name="lastname")
		private WebElement lastnameEdt;
		
		@FindBy(name="company")
		private WebElement companyEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		public WebElement getLeadlink() {
			return leadlink;
		}

		public WebElement getAddleadlink() {
			return addleadlink;
		}

		public WebElement getLastname() {
			return lastnameEdt;
		}

		public WebElement getCompany() {
			return companyEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public void  CreateLead(String LastName, String company) {
			leadlink.click();
			addleadlink.click();
			lastnameEdt.sendKeys(LastName);
			companyEdt.sendKeys(company);
			saveBtn.click();
		}
		

	}



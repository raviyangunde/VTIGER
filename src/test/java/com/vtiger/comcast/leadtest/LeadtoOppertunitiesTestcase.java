package com.vtiger.comcast.leadtest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.vtiger.comcast.genricUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.Leads;
import com.vtiger.comcast.pomrepositylib.LeadtoOpp;

public class LeadtoOppertunitiesTestcase extends BaseClass {
	
	  /*1st Test case(GiveInvalidDataToExpectedCloseDate)*/
@Test
	public  void LeadtoOppertunitiesTC_31Test() throws Throwable {
		
		String parentwin = driver.getWindowHandle();
		
		String leadlastname = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Lcompanyname = eLib.getDataFromExcel("Sheet1", 1, 2);
		String expecteddate = eLib.getDataFromExcel("Sheet1", 1, 4);
		
		Leads createlead = new Leads(driver);
		createlead.CreateLead(leadlastname, Lcompanyname);
		
		LeadtoOpp convertlead = new LeadtoOpp(driver);
		convertlead.convertlead(expecteddate);
		
		String expmsg = "Please enter a valid Close Date (DATE)";
		String actualmsg = driver.switchTo().alert().getText();
		if(actualmsg.equals(expmsg)) {
			System.out.println("PASS::valid msg is displayed");
		}
		else {
			System.out.println("FAIL::valid msg is not displayed");
		}
		
		wLib.acceptAlert(driver);
		String actualtitle = driver.getTitle();
		wLib.switchToWindow(driver, actualtitle);
		convertlead.getCancelbtn().click();
		driver.switchTo().window(parentwin);
			
	}

          /*2nd Test case(GiveValidAmount to amount TextField)*/
public class LeadtoOppertunitiesTC_32 extends BaseClass {
@Test

	public void LeadtoOppertunitiesTL_32Test() throws Throwable {
	
		String parentwin = driver.getWindowHandle();
		String expecteddate = jLib.getsystemDateandTime();
		
		String leadlastname = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Lcompanyname = eLib.getDataFromExcel("Sheet1", 1, 2);
		String validamount = eLib.getDataFromExcel("Sheet1", 4, 5);
				
		Leads createlead = new Leads(driver);
		createlead.CreateLead(leadlastname, Lcompanyname);
		
		LeadtoOpp convertlead = new LeadtoOpp(driver);
		convertlead.convertlead(expecteddate, validamount );
			
			WebElement targetpg = convertlead.getOrganizationslink();
			if(targetpg.isDisplayed()) {
				System.out.println("PASS::Organization pg is displayed");
			}else {
				System.out.println("FAIL::Organization pg is not displayed");
			}
			driver.switchTo().window(parentwin);						
	}	

}
           /*3rd Test case(GiveInvalidAmount to amount Text field)*/
public class LeadtoOppertunitiesTC_33 extends BaseClass {
@Test
	public void LeadtoOppertunitiesTL_33Test() throws Throwable {
				
		String parentwin = driver.getWindowHandle();
		String expecteddt = jLib.getsystemDateandTime();
		
		String leadlastname = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Lcompanyname = eLib.getDataFromExcel("Sheet1", 1, 2);
		String invalidamount = eLib.getDataFromExcel("Sheet1", 7, 5);
				
		Leads createlead = new Leads(driver);
		createlead.CreateLead(leadlastname, Lcompanyname);
			
		LeadtoOpp convertlead = new LeadtoOpp(driver);
		convertlead.convertlead(expecteddt, invalidamount, true);
		
		String expmsg = "Potential Amount must be a number";
		if(driver.switchTo().alert().getText().equals(expmsg)) {
			System.out.println("PASS:: exp msg is displaying");
		}else {
			System.out.println("FAIL:: exp msg is not displaying");
		}
		wLib.acceptAlert(driver);
		driver.switchTo().window(parentwin);	
	}

}
}



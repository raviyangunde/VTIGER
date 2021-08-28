package com.vtiger.comcast.leadtest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.vtiger.comcast.genricUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.Leads;
import com.vtiger.comcast.pomrepositylib.LeadtoOpp;
public class LeadtoOppertunitiesTC_32 extends BaseClass {
@Test

	public void LeadtoOppertunitiesTL_32Test() throws Throwable {
	
		String parentwin = driver.getWindowHandle();
		String expecteddate = jLib.getsystemDateandTime();
		
		String leadlastname = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Lcompanyname = eLib.getDataFromExcel("Sheet1", 1, 2);
		String validamount = eLib.getDataFromExcel("Sheet1", 4, 5);
		
		/*creating lead              */
		Leads createlead = new Leads(driver);
		createlead.CreateLead(leadlastname, Lcompanyname);
		
		/*converting lead to opportunities       */
		LeadtoOpp convertlead = new LeadtoOpp(driver);
		convertlead.convertlead(expecteddate, validamount );
			 
		/*verifying organization page is displayed or not*/
			WebElement targetpage = convertlead.getOrganizationslink(); 
			Assert.assertTrue(targetpage.isDisplayed());
			
//			if(targetpg.isDisplayed()) {
//				System.out.println("PASS::Organization pg is displayed");
//			}else {
//				System.out.println("FAIL::Organization pg is not displayed");
//			}
			
			driver.switchTo().window(parentwin);						
	}	

}

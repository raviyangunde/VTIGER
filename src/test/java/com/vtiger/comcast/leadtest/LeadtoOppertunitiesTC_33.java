package com.vtiger.comcast.leadtest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vtiger.comcast.genricUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.Leads;
import com.vtiger.comcast.pomrepositylib.LeadtoOpp;
@Listeners(com.vtiger.comcast.genricUtility.ListImpClass.class)
public class LeadtoOppertunitiesTC_33 extends BaseClass{
@Test
	public void LeadtoOppertunitiesTL_33Test() throws Throwable {
				
		String parentwin = driver.getWindowHandle();
		String expecteddate = jLib.getsystemDateandTime();
		
		String leadlastname = eLib.getDataFromExcel("Sheet1", 1, 1);
		String Lcompanyname = eLib.getDataFromExcel("Sheet1", 1, 2);
		String invalidamount = eLib.getDataFromExcel("Sheet1", 7, 5);
				
		Leads createlead = new Leads(driver);
		createlead.CreateLead(leadlastname, Lcompanyname);
			
		LeadtoOpp convertlead = new LeadtoOpp(driver);
		convertlead.convertlead(expecteddate, invalidamount, true);
		
		String expmsg = "Potential Amount must be a number";
		String actualmsg = driver.switchTo().alert().getText();
		Assert.assertEquals(actualmsg, expmsg);
		
//		if(driver.switchTo().alert().getText().equals(expmsg)) {
//			System.out.println("PASS:: exp msg is displaying");
//		}else {
//			System.out.println("FAIL:: exp msg is not displaying");
//		}
		
		wLib.acceptAlert(driver);
		driver.switchTo().window(parentwin);	
	}

}

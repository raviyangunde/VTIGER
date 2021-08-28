package vtigerPractice;

import org.testng.annotations.Test;


public class CreateLead {
	@Test(groups= "Smoketesting")
	public void CreateLeadTest(){
		System.out.println("leadcreated");
	}
	@Test(groups= "regression test")
public void modifyCreateLeadtest() {
	System.out.println("lead modified");
	
}@Test(groups="regression test")
  public void deleteCreateLead() {
	  System.out.println("lead deleted");
  }

}

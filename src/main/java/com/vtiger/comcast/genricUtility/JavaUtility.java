package com.vtiger.comcast.genricUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * this class contains java specific libraries
 * @author RAVI
 *
 */
public class JavaUtility {
	/**
	 * it is used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return intData
	 */
	
	public int getRanDomNumber(){
		Random random = new Random();
		int randomNum = random.nextInt(10000);
		return randomNum;
	}
	/**
	 * it is used to get the current system date with YYYY-MM-DD format;
	 * @return
	 */
	
	public String getsystemDateandTime() {
		Date date= new Date();
		String systemDateandTime = date.toString();
		System.out.println(systemDateandTime);
		String[] arr =systemDateandTime.split(" ");
		String DD = arr[2];
		String YYYY = arr[5];
		int MM = date.getMonth()+1;
		
		String finalfromat = YYYY+"-"+MM+"-"+DD;
		return finalfromat;
	
	}
	
	
    /**
     * used to pass Virtual Key to OS
     * @throws Throwable
     */
    public void pressVurtualEnterKey() throws Throwable {
    	
    	Robot rc=new Robot();
    	rc.keyPress(KeyEvent.VK_ENTER);
    	rc.keyRelease(KeyEvent.VK_ENTER);
    }	

}




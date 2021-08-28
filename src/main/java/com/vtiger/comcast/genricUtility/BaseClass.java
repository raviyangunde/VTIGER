package com.vtiger.comcast.genricUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositylib.LogOut;
import com.vtiger.comcast.pomrepositylib.LoginPage;

public class BaseClass {
	
		public WebDriver driver;
		public static WebDriver sDriver;
		
		  /*Object Creation for Lib*/
			
			public JavaUtility jLib = new JavaUtility();
			public WebDriverUtility wLib = new WebDriverUtility();
			public FileUtility fLib = new FileUtility();
			public ExcelUtility eLib = new ExcelUtility();
		
		@BeforeSuite
		public void configBS() {
			System.out.println("========================connect to DB========================");
		}
		
//		@Parameters("BROWSER")
//		@BeforeClass
//		public void configBC(String BROWSER) {
//		
//			
//			System.out.println("=============Launch the Browser=======");
//			if(BROWSER.equals("chrome")) {
//			driver = new ChromeDriver();
//			}else if(BROWSER.equals("firefox")){
//				driver = new FirefoxDriver();
//			}else if(BROWSER.equals("opera")){
//			driver = new OperaDriver();
//			}else {
//				System.out.println("browser not found");
//			}
//     		wLib.waitUntilPageLoad(driver);
//			driver.manage().window().maximize();
//			
//		}
		
	
		@BeforeClass
		public void configBC() {
			driver = new ChromeDriver();
     		wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();
			
		}
		
		@BeforeMethod
		public void configBM() throws Throwable {
			/*common Data*/
			sDriver = driver;
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			/* Navigate to app*/
			   driver.get(URL);
		        /* step 1 : login */
			   LoginPage loginPage = new LoginPage(driver);
		        loginPage.LoginToApp(USERNAME, PASSWORD);
		}
		
		
		@AfterMethod
		public void configAM() {
		      /*step 6 : logout*/
		LogOut lgout = new LogOut(driver);
	        lgout.logOut();
		}
		
		@AfterClass
		public void configAC() {
			System.out.println("=============Close the Browser=======");
		//	driver.quit();
		}
		
		@AfterSuite
		public void configAS() {
			System.out.println("========================close DB========================");
		}
	}




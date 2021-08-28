package vtigerPractice;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class CreateOrg {
	public WebDriver driver;
	public ExtentHtmlReporter reporter;
	public ExtentReports reports;
	public ExtentTest test;
	
	@BeforeSuite
	public void ConfigBS() {
		String ldt=LocalDateTime.now().toString().replace(":", "_");
		reporter = new ExtentHtmlReporter("../VTIGER/Extentreports/SDET20_"+ldt+".html");
		System.out.println("=======BS========");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
	}
	
	@BeforeClass
	public void ConfigBC() {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@BeforeMethod
	public void ConfigBM() {
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
	}
	@Test
       public void CreateOrgTest() {
		test=reports.createTest("CreateOrgTest");
		System.out.println(driver.getTitle());
	}
	@Test
	public void OrganizationTest() {
		test=reports.createTest("CreateOrgTest");
		driver.findElement(By.linkText("Organizations")).click();
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void ConfigAM() {
		Actions action = new Actions(driver);
		WebElement logoutbutton = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(logoutbutton).perform();
		WebElement signoutlink = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		signoutlink.click();
	
	}
	@AfterClass
	public void ConfigAC() {
		driver.close();
	}
	@AfterSuite
	public void ConfigAS1() {
		System.out.println("=======AS=======");
		reports.flush();
		
	}
	
}
	
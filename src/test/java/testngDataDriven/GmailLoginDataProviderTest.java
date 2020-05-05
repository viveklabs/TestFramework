package testngDataDriven;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.utils.getDataFromExcel;

public class GmailLoginDataProviderTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "/home/vivek/Downloads/Compressed/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
	
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> data = getDataFromExcel.getExcelData();
		return data.iterator();
	
	}
	
	
	@Test(dataProvider = "getTestData")
	public void loginGmail(String url, String emailId) throws InterruptedException {
		
		driver.get(url);		
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),\"Next\")]")).click();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
		
	}

}

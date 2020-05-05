package testngDataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailLogin {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"url"})
	public void setUp(String url) {
		
		System.setProperty("webdriver.chrome.driver", "/home/vivek/Downloads/Compressed/chromedriver_linux64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
		
		driver.get(url);
		
		
	}
	
	
	@Test(threadPoolSize = 3, invocationCount = 3)
	@Parameters({"emailId"})
	public void loginGmail(String emailId) throws InterruptedException {
		
		System.out.println(Thread.currentThread().getId());		
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

package testngBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\91821\\OneDrive\\Desktop\\My Workspace\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
		
		driver.get("https://www.gmail.com");
		
		
	}
	
	@Test
	public void getTitle() {
		
		System.out.println(Thread.currentThread().getId());
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Gmail", "Title is not matched");
	}
	
	@Test(enabled = true) //enable=false will not allow the test case to execute
	public void verifyLogo() {
		
		System.out.println(Thread.currentThread().getId());
		boolean b = driver.findElement(By.xpath("//*[@id='logo']")).isDisplayed();
		Assert.assertTrue(b);
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
		
	}

}

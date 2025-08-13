package testngBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngPractice {
	
	@BeforeSuite (alwaysRun = true)
	public void beforeSuite() {
		
		System.out.println("Before Suite");
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		
		System.out.println("Before Class");
		
	}
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		
		System.out.println("Before test");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		
		System.out.println("Before Method");
		
	}
	
	//without priority keyword, Eclipse will run Test randomly
	@Test(priority=6,groups={"minor","major"})
	public void testMethod1() {
		
		System.out.println("Test Method - 1");
		
	}
	
	@Test(priority=5,groups="major")
	public void testMethod2() {
		
		System.out.println("Test Method - 2");
		
	}
	
	@Test(priority=4,groups="tiny")
	public void testMethod3() {
		
		System.out.println("Test Method - 3");
		
	}
	
	@Test(priority=3,groups="minor")
	public void testMethod4() {
		
		System.out.println("Test Method - 4");
		
	}
	
	@Test(priority=2,groups="major")
	public void testMethod5() {
		
		System.out.println("Test Method - 5");
		
	}
	
	@Test(groups="tiny")
	public void testMethod6() {
		
		System.out.println("Test Method - 6");
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		
		System.out.println("After Method");
		
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		
		System.out.println("After test");
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		
		System.out.println("After Class");
		
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		
		System.out.println("After suite");
		
	}

}

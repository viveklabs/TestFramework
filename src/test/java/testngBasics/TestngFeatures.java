package testngBasics;

import org.testng.annotations.Test;

public class TestngFeatures {
	
	@Test
	public void loginTest() {
		
		System.out.println("login Method");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void homePageTest() {
		
		System.out.println("Home Page Mthod");
	}
	
	

}

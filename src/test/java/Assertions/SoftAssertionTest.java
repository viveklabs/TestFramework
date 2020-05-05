package Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionTest {
	
	@Test
	public void test1() {
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(true, false,"its not equal");
		
		System.out.println("---------");
		
		softAssert.assertEquals("car", "boy","its not equal");
		
		System.out.println("-------");
		
		softAssert.assertEquals(true, true,"its not equal");
		
		softAssert.assertAll(); //helps in failing the test case with highligthing all assertions
		
	}

}

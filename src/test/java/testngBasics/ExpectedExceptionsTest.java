package testngBasics;

import org.testng.annotations.Test;

public class ExpectedExceptionsTest {
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void test1() {
		
		String a = "100A";
		int b = Integer.parseInt(a);
		System.out.println(b);
		System.out.println("Exception handled");
	}

}

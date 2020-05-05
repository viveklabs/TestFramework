package testngBasics;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount = 5)
	public void sum() {
		
		int a = 1;
		int b = 2;
		
		int c = a+b;
		
		System.out.println(c);
		
	}

}

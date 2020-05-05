package RetryTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RunFailedTestWise {
	
	
	@Test(retryAnalyzer = Analyser.RetryAnalyser.class)
	public void test1() {
		Assert.assertEquals(true, false);
		
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(true, true);
	}

}

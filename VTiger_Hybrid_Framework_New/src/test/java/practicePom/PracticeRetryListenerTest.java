package practicePom;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic_BaseClassUtility.BaseClass;

public class PracticeRetryListenerTest extends BaseClass {
	
	@Test(retryAnalyzer=listenerUtility.RetryListenerImplemenetation.class)
	public void activateSim() {
		Reporter.log("sim ACtivated");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Login");
		Reporter.log(actualTitle);
		Reporter.log("Step 1");
		Reporter.log("Step 2");
	}

	@Test
	public void createinvoiceWithContactTest() {
	Reporter.log("execute createinvoiceWithContactTest");
	
	}
	
}

package practicePom;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterPractice {
	
	@Test
	public void homePage(Method mtd) {
		
		
		Reporter.log(mtd.getName()+"Started");
		Reporter.log("step-1",true);
		Reporter.log("step-2");
		Reporter.log("step-3");
		Reporter.log("step-4");
		Reporter.log(mtd.getName()+"end");
	}
	
	@Test
	public void loginPage(Method mtd) {
		Reporter.log(mtd.getName()+"Started");
		Reporter.log("step-1");
		Reporter.log("step-2");
		Reporter.log("step-3");
		Reporter.log("step-4");
		Reporter.log(mtd.getName()+"end");
		
	}

}

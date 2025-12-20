package practicePom;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class PracticeReport {

	@Test
	public void createContactTest() {

		//==================ScreenShot
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		// ==Spark Report config
		spark.config().setDocumentTitle("CRM TestSuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		// =================add env inofrmarion and create test
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "Chrome-100");
		
		ExtentTest test = report.createTest("createContactTest");
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "cnavigate tp contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.addScreenCaptureFromBase64String(filepath,"Errorfile");
		}
		driver.close();
		test.log(Status.INFO, "Login to app");
		report.flush();

	}

}

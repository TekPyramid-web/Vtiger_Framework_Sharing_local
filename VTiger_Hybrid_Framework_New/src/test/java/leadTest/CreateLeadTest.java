package leadTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_BaseClassUtility.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.Lead_Info_Page;
import objectRepositoryUtility.Lead_Page;
import objectRepositoryUtility.Lead_createNewLead_Page;

@Listeners(listenerUtility.ListenerImplementation.class)
public class CreateLeadTest extends BaseClass {

	@Test
	public void createLeadTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.getLeadsLink().click();

		Lead_Page lp = new Lead_Page(driver);
		lp.getCreateLeadIcon().click();

		Lead_createNewLead_Page lcp = new Lead_createNewLead_Page(driver);
		String firstName = eLib.getDataFRomExcel("leads", 1, 2);
		String lastName = eLib.getDataFRomExcel("leads", 1, 3);
		String company = eLib.getDataFRomExcel("leads", 1, 4);
		String phoneNumber = eLib.getDataFRomExcel("leads", 1, 5);
		String email = eLib.getDataFRomExcel("leads", 1, 6);
		lcp.createLead(firstName, lastName, company, phoneNumber, email);
		Lead_Info_Page lip = new Lead_Info_Page(driver);
		String actTitle = lip.getActTitle();
		// Assert.assertEquals(actTitle, lastName);
		Assert.assertTrue(actTitle.contains(lastName));
		Reporter.log(actTitle + "===============Lead created", true);
		WebElement websiteFeild = driver.findElement(By.xpath("//td[text()='Website']/following-sibling::td"));
		String websitef = websiteFeild.getText();
		Assert.assertTrue(websitef.isEmpty());
		Reporter.log("====================Website Feild null ", true);

	}
}

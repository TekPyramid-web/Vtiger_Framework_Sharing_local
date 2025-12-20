package organizationTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.webDriverUtility.UtilityClassObject;
import generic_BaseClassUtility.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.Org_Info_Page;
import objectRepositoryUtility.Org_Page;
import objectRepositoryUtility.Org_createNewOrg_Page;

@Listeners(listenerUtility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrganizationTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to org Page");
		new HomePage(driver).getOrgLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create org Page");
		new Org_Page(driver).getCreateNewOrgIcon().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create new org Page");
		Org_createNewOrg_Page cnlp = new Org_createNewOrg_Page(driver);
		
		UtilityClassObject.getTest().log(Status.INFO, "read datafrom excel");
		String organizationName = eLib.getDataFRomExcel("organization", 1, 2) + jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO,organizationName+ "Create new org Page");
		cnlp.createOrganization(organizationName);
		
		Thread.sleep(2000);
		Org_Info_Page oip = new Org_Info_Page(driver);
		String actualOrgName = oip.getHeaderMsg().getText();
		boolean status1 = actualOrgName.contains(organizationName);
		Assert.assertEquals(status1, true);
		Thread.sleep(2000);
		String actOrgNameInFeild = oip.getTextfeildData().getText();
		boolean status2 = actOrgNameInFeild.contains(organizationName);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(status2, true);
	}
	
	@Test(groups="regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {

		new HomePage(driver).getOrgLink().click();
		new Org_Page(driver).getCreateNewOrgIcon().click();
		Org_createNewOrg_Page cnlp = new Org_createNewOrg_Page(driver);
		String organizationName = eLib.getDataFRomExcel("organization", 1, 2) + jLib.getRandomNumber();
		String industryName = eLib.getDataFRomExcel("organization", 4, 3);
		String typeNAme = eLib.getDataFRomExcel("organization", 4, 4);
		cnlp.createOrganization(organizationName, industryName, typeNAme);
		
		Org_Info_Page oip = new Org_Info_Page(driver);
		String actualOrgName = oip.getHeaderMsg().getText();

		if (actualOrgName.contains(organizationName)) {
			System.out.println(organizationName + " Org Created====TC PASS");
		} else {
			System.err.println(organizationName + " Org not Created====TC FAIL");
		}

	}

	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {

		new HomePage(driver).getOrgLink().click();
		new Org_Page(driver).getCreateNewOrgIcon().click();
		Org_createNewOrg_Page cnlp = new Org_createNewOrg_Page(driver);
		String organizationName = eLib.getDataFRomExcel("organization", 1, 2) + jLib.getRandomNumber();
		String industryName = eLib.getDataFRomExcel("organization", 4, 3);
		String typeNAme = eLib.getDataFRomExcel("organization", 4, 4);
		String phoneNumber = eLib.getDataFRomExcel("organization", 4, 5);
		cnlp.createOrganization(organizationName, industryName, typeNAme, phoneNumber);
		
		Org_Info_Page oip = new Org_Info_Page(driver);
		String actualOrgName = oip.getHeaderMsg().getText();

		if (actualOrgName.contains(organizationName)) {
			System.out.println(organizationName + " Org Created====TC PASS");
		} else {
			System.err.println(organizationName + " Org not Created====TC FAIL");
		}
	}


}

package organizationTest;

import org.testng.annotations.Test;

import generic_BaseClassUtility.BaseClass;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.Org_Page;
import objectRepositoryUtility.Org_createNewOrg_Page;

public class DeleteOrganizationTest extends BaseClass {

	@Test
	public void deleteOrganizationTest() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		Org_Page op = new Org_Page(driver);
		op.getCreateNewOrgIcon().click();
		Org_createNewOrg_Page cnp = new Org_createNewOrg_Page(driver);
		String organizationName = eLib.getDataFRomExcel("organization", 10, 2) + jLib.getRandomNumber();
		String industryName = eLib.getDataFRomExcel("organization", 10, 3);
		String typeNAme = eLib.getDataFRomExcel("organization", 10, 4);
		String phoneNumber = eLib.getDataFRomExcel("organization", 10, 5);
		String selectType = eLib.getDataFRomExcel("organization", 10, 6);
		cnp.createOrganization(organizationName, industryName, typeNAme, phoneNumber);
		Thread.sleep(2000);
		hp.getOrgLink().click();
		op.deleteOrg(driver, organizationName, selectType);
		
	}
}

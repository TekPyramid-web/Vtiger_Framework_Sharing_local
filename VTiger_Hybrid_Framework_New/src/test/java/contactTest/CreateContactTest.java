package contactTest;

import org.testng.annotations.Test;

import generic_BaseClassUtility.BaseClass;
import objectRepositoryUtility.Contact_Page;
import objectRepositoryUtility.Contact_createNewCon_Page;
import objectRepositoryUtility.HomePage;
import objectRepositoryUtility.Org_Page;
import objectRepositoryUtility.Org_createNewOrg_Page;

public class CreateContactTest extends BaseClass{

	@Test(groups="smokeTest")
	public void createcontactWithSupportDateTest() throws Throwable{
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		Contact_Page cp = new Contact_Page(driver);
		cp.getCreateContactIcon().click();
		String firstName = eLib.getDataFRomExcel("contact", 1, 2);
		String lastName = eLib.getDataFRomExcel("contact", 1, 3);
		String supportStartDate= jLib.getSystemDateyyyyMMdd();
		String supportEndDate = jLib.getRequiredDateyyyyMMdd(30);
		Contact_createNewCon_Page con = new Contact_createNewCon_Page(driver);
		con.createContactwithDate(firstName, lastName, supportStartDate, supportEndDate);
		
	}
	
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();;
		Org_createNewOrg_Page ocp = new Org_createNewOrg_Page(driver);
		Org_Page op = new Org_Page(driver);
		op.getCreateNewOrgIcon().click();
		String orgName = eLib.getDataFRomExcel("contact", 4, 2)+jLib.getRandomNumber();
		ocp.createOrganization(orgName);
		Thread.sleep(2000);
		hp.getContactLink().click();
		Contact_Page cp = new Contact_Page(driver);
		cp.getCreateContactIcon().click();
		String firstName = eLib.getDataFRomExcel("contact", 1, 2);
		String lastName = eLib.getDataFRomExcel("contact", 1, 3);
		String supportStartDate= jLib.getSystemDateyyyyMMdd();
		String supportEndDate = jLib.getRequiredDateyyyyMMdd(30);
		Contact_createNewCon_Page cc = new Contact_createNewCon_Page(driver);
		cc.createContactwithDateOrg(orgName, firstName, lastName, supportStartDate, supportEndDate);
		
		}
	
	@Test(groups="regressionTest")
	public void createContactWithAttachTest() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();;
		Org_createNewOrg_Page ocp = new Org_createNewOrg_Page(driver);
		Org_Page op = new Org_Page(driver);
		op.getCreateNewOrgIcon().click();
		String orgName = eLib.getDataFRomExcel("contact", 4, 2)+jLib.getRandomNumber();
		ocp.createOrganization(orgName);
		Thread.sleep(2000);
		hp.getContactLink().click();
		Contact_Page cp = new Contact_Page(driver);
		cp.getCreateContactIcon().click();
		String firstName = eLib.getDataFRomExcel("contact", 1, 2);
		String lastName = eLib.getDataFRomExcel("contact", 1, 3);
		String supportStartDate= jLib.getSystemDateyyyyMMdd();
		String supportEndDate = jLib.getRequiredDateyyyyMMdd(30);
		String filePath = "C:\\Users\\Mamat\\OneDrive\\Desktop\\meta.png";
		Contact_createNewCon_Page cc = new Contact_createNewCon_Page(driver);
		cc.createContactWithOrgAndAttachFile(filePath, orgName, firstName, lastName, supportStartDate, supportEndDate);
		
	}


}

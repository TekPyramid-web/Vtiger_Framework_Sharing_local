package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Org_createNewOrg_Page {
	WebDriver driver;

	public Org_createNewOrg_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;

	@FindBy(name = "button")
	private WebElement saveButton;

	@FindBy(name = "industry")
	private WebElement industryDD;

	@FindBy(name = "accounttype")
	private WebElement typeDD;

	@FindBy(id = "phone")
	private WebElement phoneNumberEdit;

	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void createOrganization(String name) {
		orgNameEdit.sendKeys(name);
		saveButton.click();
	}

	public void createOrganization(String name, String industry, String type) {
		orgNameEdit.sendKeys(name);
		new Select(industryDD).selectByVisibleText(industry);
		new Select(typeDD).selectByVisibleText(type);
		saveButton.click();
	}

	public void createOrganization(String name, String industry, String type, String phone) {
		orgNameEdit.sendKeys(name);
		new Select(industryDD).selectByVisibleText(industry);
		new Select(typeDD).selectByVisibleText(type);
		phoneNumberEdit.sendKeys(phone);
		saveButton.click();
	}
}

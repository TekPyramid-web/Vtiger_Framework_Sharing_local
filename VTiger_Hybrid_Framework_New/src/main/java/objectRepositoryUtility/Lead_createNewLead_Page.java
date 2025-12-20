package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lead_createNewLead_Page {
	WebDriver driver = null;

	public Lead_createNewLead_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstnameTextfeild;

	@FindBy(name = "lastname")
	private WebElement lastnameTextfeild;

	@FindBy(name = "company")
	private WebElement companyTextfeild;

	@FindBy(name = "phone")
	private WebElement phoneTextfeild;

	@FindBy(name = "email")
	private WebElement emailTextfeild;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFirstnameTextfeild() {
		return firstnameTextfeild;
	}

	public WebElement getLastnameTextfeild() {
		return lastnameTextfeild;
	}

	public WebElement getCompanyTextfeild() {
		return companyTextfeild;
	}

	public WebElement getPhoneTextfeild() {
		return phoneTextfeild;
	}

	public WebElement getEmailTextfeild() {
		return emailTextfeild;
	}
	
	public void createLead(String firstname, String lastname, String company, String phoneNumber, String email) {
		getFirstnameTextfeild().sendKeys(firstname);
		getLastnameTextfeild().sendKeys(lastname);
		getCompanyTextfeild().sendKeys(company);
		getPhoneTextfeild().sendKeys(phoneNumber);
		getEmailTextfeild().sendKeys(email);
		getSaveButton().click();
	}
}

package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webDriverUtility.WebDriverUtility;

public class Contact_createNewCon_Page {
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver = null;
	
	public Contact_createNewCon_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement firstNameEdit;
	
	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath="//img[@title='Select'][1]")
	private WebElement orgIcon;
	
	@FindBy(name="mobile")
	private WebElement mobileEdit;
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;
	
	@FindBy(name="imagename")
	private WebElement choosefileButton;
	
	@FindBy(name= "button")
	private WebElement saveButton;
	
	@FindBy(name="search_text")
	private WebElement searchTextFeild;
	
	@FindBy(name = "search_field")
	private WebElement searchFeildDD;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement orgNameOption;
	
	public WebElement getOrgNameOption() {
		return orgNameOption;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFirstNameEdit() {
		return firstNameEdit;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getOrgIcon() {
		return orgIcon;
	}

	public WebElement getMobileEdit() {
		return mobileEdit;
	}

	public WebElement getSupportStartDate() {
		supportStartDate.clear();
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		supportEndDate.clear();
		return supportEndDate;
	}

	public WebElement getChoosefileButton() {
		return choosefileButton;
	}
	public WebElement getSearchTextFeild() {
		return searchTextFeild;
	}

	public WebElement getSearchFeildDD() {
		return searchFeildDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	public void createContactwithDate(String firstName, String lastName, String supportStartDate, String supportEndDate) {
		getFirstNameEdit().sendKeys(firstName);
		getLastNameEdit().sendKeys(lastName);
		getSupportStartDate().sendKeys(supportStartDate);
		getSupportEndDate().sendKeys(supportEndDate);
		getSaveButton().click();
		
	}
	public void createContactwithDateOrg(String orgName , String firstName, String lastName, String supportStartDate, String supportEndDate)
	
	{
		
		getFirstNameEdit().sendKeys(firstName);
		getLastNameEdit().sendKeys(lastName);
		getOrgIcon().click();
		wLib.switchToWindowBaseOnURL(driver, "module=Accounts");
		getSearchTextFeild().sendKeys(orgName);
		getSearchFeildDD().click();
		getSearchButton().click();
		getOrgNameOption().click();
		wLib.switchToWindowBaseOnURL(driver, "module=Contacts");
		getSupportStartDate().sendKeys(supportStartDate);
		getSupportEndDate().sendKeys(supportEndDate);
		getSaveButton().click();
		
	}
	
	public void createContactWithOrgAndAttachFile(String FilePath, String orgName , String firstName, String lastName, String supportStartDate, String supportEndDate) {
		getFirstNameEdit().sendKeys(firstName);
		getLastNameEdit().sendKeys(lastName);
		getOrgIcon().click();
		wLib.switchToWindowBaseOnURL(driver, "module=Accounts");
		getSearchTextFeild().sendKeys(orgName);
		getSearchFeildDD().click();
		getSearchButton().click();
		getOrgNameOption().click();
		wLib.switchToWindowBaseOnURL(driver, "module=Contacts");
		getSupportStartDate().sendKeys(supportStartDate);
		getSupportEndDate().sendKeys(supportEndDate);
		getChoosefileButton().sendKeys(FilePath);
		getSaveButton().click();
		
	}



}

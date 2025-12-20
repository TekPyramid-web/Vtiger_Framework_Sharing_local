package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webDriverUtility.WebDriverUtility;

public class Lead_Page {
	WebDriver driver = null;
	
	public Lead_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//img[@title='Create Lead...']")
	private WebElement createLeadIcon;
	
	@FindBy(name = "search_text")
	private WebElement searchTextBox;

	@FindBy(name = "search_field")
	private WebElement searchFieldDD;

	@FindBy(name = "submit")
	private WebElement searchButton;

	
	public WebElement getCreateLeadIcon() {
		return createLeadIcon;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchFieldDD() {
		return searchFieldDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	private WebElement getDeleteLink(String firstName) {
		WebElement delLink = driver.findElement(By.xpath("//a[text()='"+firstName+"']/../../td[9]/a[text()='del']"));
		return 	delLink;

	}

	public void delLead(WebDriver driver, String leadName) {
		getSearchTextBox().sendKeys(leadName);
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.selectOptionByValue(getSearchFieldDD(), leadName);
		getSearchButton().click();
		getDeleteLink(leadName).click();
	}

}

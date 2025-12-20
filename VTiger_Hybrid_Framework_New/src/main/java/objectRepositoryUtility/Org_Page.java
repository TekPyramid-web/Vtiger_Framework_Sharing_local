package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webDriverUtility.WebDriverUtility;

public class Org_Page {
	WebDriverUtility wLib = new WebDriverUtility();
	
	WebDriver driver;
	public Org_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgIcon;

	@FindBy(name = "search_text")
	private WebElement searchTextFeild;

	@FindBy(name = "search_field")
	private WebElement searchFieldDD;

	@FindBy(name = "submit")
	private WebElement searchButton;

	public WebElement getSearchTextFeild() {
		return searchTextFeild;
	}

	public WebElement getSearchfeildDD() {
		return searchFieldDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getCreateNewOrgIcon() {
		return createNewOrgIcon;
	}

//	public void selectOrgnaizationNameDD() {
//		wLib.selectOptionByVisibleText(searchFieldDD, "Organization Name");
//	}
	
public void deleteOrg(WebDriver driver, String orgName, String searchType) throws InterruptedException {
		
		getSearchTextFeild().sendKeys(orgName);
		getSearchfeildDD().sendKeys(searchType);
		getSearchButton().click();
		WebElement delLink = driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']"));
		delLink.click();
		Thread.sleep(2000);
		wLib.switchToacceptAlert(driver);
	}


	

}

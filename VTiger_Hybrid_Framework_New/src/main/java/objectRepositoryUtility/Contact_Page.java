package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_Page {
	
	WebDriver driver = null;
	
	public Contact_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(name = "search_text")
	private WebElement searchTextBox;

	@FindBy(name = "search_field")
	private WebElement searchFieldDD;

	@FindBy(name = "submit")
	private WebElement searchButton;

	public WebElement getCreateContactIcon() {
		return createContactIcon;
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
	
	public void deleteContact(WebDriver driver , String firstName, String selectType) {
		getSearchTextBox().sendKeys(firstName);
		getSearchFieldDD().sendKeys(selectType);
		getSearchButton().click();
		getDeleteLink(firstName).click();
		
	}
	
	


}

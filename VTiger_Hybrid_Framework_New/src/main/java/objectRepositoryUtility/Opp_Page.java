package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opp_Page {
	
	WebDriver driver;

	public Opp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement createOppIcon;
	
	@FindBy(name="search_text")
	private WebElement searchtextFeild;
	
	@FindBy(name="search_field")
	private WebElement searchFieldDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	public void deleteOpp(String oppName) {
		
		WebElement delLink = driver.findElement(By.xpath("//a[text()='"+oppName+"']/../../td[9]/a[text()='del']"));
		delLink.click();
	}

}

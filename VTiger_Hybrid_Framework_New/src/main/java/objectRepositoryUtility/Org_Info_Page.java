package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Org_Info_Page {
	
	WebDriver driver;

	public Org_Info_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(name="search_text")
	private WebElement searchTextFeild;
	
	@FindBy(name="search_field")
	private WebElement searchfeildDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(className = "dvtCellInfo")
	private WebElement textfeildData;

	public WebElement getTextfeildData() {
		return textfeildData;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	
	
	

}

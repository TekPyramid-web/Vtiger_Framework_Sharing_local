package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// =======object Initialization
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement accountsIcon;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "Documents")
	private WebElement documentsLink;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	@FindBy(linkText = "Email")
	private WebElement emailLink;

	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLink;

	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLink;

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getAccountsIcon() {
		return accountsIcon;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public void navigateToCampaign() {
		Actions act = new Actions(driver);
		act.moveToElement(campaignLink);
		campaignLink.click();
	}

	public void logOutOperation() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(accountsIcon).perform();
		Thread.sleep(2000);
		act.moveToElement(logOut).perform();
		act.click().perform();

	}
}

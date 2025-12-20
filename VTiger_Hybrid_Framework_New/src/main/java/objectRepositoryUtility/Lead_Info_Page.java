package objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Lead_Info_Page {
	WebDriver driver =null;
	
	public Lead_Info_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getActTitle()
	{
	WebElement Title = driver.findElement(By.className("dvHeaderText"));
	String actTitle = Title.getText();
	return actTitle;
	}
}

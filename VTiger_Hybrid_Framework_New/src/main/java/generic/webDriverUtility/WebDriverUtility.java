package generic.webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	public void accessToApplication(WebDriver driver, String URL) {
		driver.get(URL);
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToWindow(WebDriver driver) {

		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for (String id : allIds) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void switchToParentWindow(WebDriver driver, String parentId) {

		driver.switchTo().window(parentId);
	}

	public void switchToWindowBaseOnURL(WebDriver driver, String partialURL) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialURL))
				break;
		}
	}

	public void switchToWindowBaseOnTitle(WebDriver driver, String partialTitle) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle))
				break;
		}
	}

//===========chatgpt
	public void switchToWindow(WebDriver driver, String partialTitle) {
		for (String id : driver.getWindowHandles()) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToacceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchTodismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String switchToAlertgetMessage(WebDriver driver) {
		String message = driver.switchTo().alert().getText();
		return message;
	}

	public void selectOptionByIndex(WebElement dropdownEle, int index) {
		Select sel = new Select(dropdownEle);
		sel.selectByIndex(index);
	}

	public void selectOptionByVisibleText(WebElement dropdownEle, String visibleText) {
		Select sel = new Select(dropdownEle);
		sel.selectByVisibleText(visibleText);
	}

	public void selectOptionByValue(WebElement dropdownEle, String valueAttribute) {
		Select sel = new Select(dropdownEle);
		sel.selectByValue(valueAttribute);
	}

	public void mouseHoveringActions(WebDriver driver, WebElement targetEle) {
		Actions act = new Actions(driver);
		act.moveToElement(targetEle).perform();
	}

	public void doubleClickOperation(WebDriver driver, WebElement targetEle) {
		Actions act = new Actions(driver);
		act.doubleClick(targetEle).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement srcEle, WebElement destEle) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, destEle).perform();
	}

	public String captureWebPageScreenshot(WebDriver driver, String screeshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\ScreenShot\\" + screeshotName + ".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath(); // used for listeners
	}

		public String captureElementScreenshot(WebDriver driver, WebElement ele, String screeshotName) throws IOException {
			File src = ele.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\ScreenShot\\" + screeshotName + ".png");
			Files.copy(src, dest);
			return dest.getAbsolutePath(); // used for listeners
		}
}

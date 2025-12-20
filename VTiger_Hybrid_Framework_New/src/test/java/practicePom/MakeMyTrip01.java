package practicePom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip01 {

	public static void main(String[] args) throws InterruptedException {
		
		String from = "New Delhi";
		String to = "Chennai";
		String Month = "November 2026";
		String Date = "14";
		String adult = "3";
		String children = "1";
		String type = "Premium Economy";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(from);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
		
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(to);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
		
		Thread.sleep(2000);
		int flag = 1;
		while(flag == 1)
		{
			
			WebElement actualMonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div"));
			
			
			if (actualMonth.getText().equals(Month))
			{
			  flag = 0;	
			}
			else
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='dateInnerCell']/p[text()='"+Date+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='travellers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-cy='adults-"+adult+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-cy='children-"+children+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='"+ type +"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		

		
	}

		
	

}

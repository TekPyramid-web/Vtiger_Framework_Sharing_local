package practicePom;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeLinksChatGPT {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");

		List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
		
		for (WebElement eachlink : allLinks) {
		    String link = eachlink.getAttribute("href");

		    if (link == null || link.isEmpty() || link.startsWith("javascript") || link.equals("#")) {
		        continue;
		    }

		    try {
		        HttpURLConnection conn = (HttpURLConnection) new URL(link).openConnection();
		        conn.setConnectTimeout(5000);
		        conn.connect();
		        int statusCode = conn.getResponseCode();

		        System.out.println(link + " ---> " + statusCode);

		    } catch (Exception e) {
		        System.out.println(link + " ---> ERROR: " + e.getMessage());
		    }
		}

	}

}

package practicePom;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeLinksWorkingCondition {

	public static void main(String[] args) throws URISyntaxException, Throwable {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		URL url = null;
		int statusCode = 0;
		for (WebElement eachlink : allLinks) {
			String link = eachlink.getDomAttribute("href");
			if (link == null || link.isEmpty() || link.startsWith("javascript") || link.equals("#"))
				continue;

			url = new URI(link).toURL();
			try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			statusCode = conn.getResponseCode();
			if (statusCode <= 400) {
				System.out.println(link + "  " + statusCode);
			} else
				System.out.println("link npt working");
			}
			catch(Exception e) {}
		}
		System.out.println("excecuted");
		driver.close();
	}

}

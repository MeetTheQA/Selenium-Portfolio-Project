package HerokuApp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenWebsiteChrome {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "The Internet";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	@AfterMethod
	public void tearDown() {

		driver.close();
		
	}

}

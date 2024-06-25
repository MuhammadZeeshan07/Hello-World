package org.youCater.userConfigurationsAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class Configurations {

	public static WebDriverWait wait;
	public static WebDriver driver;

	static {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "D:/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().window().maximize();
			options.addArguments("--disable-notifications");
		//	driver.manage().window().setSize(new Dimension(1920, 1080));
			driver.get("https://uat.youcater.me/en");
		}
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}

package org.youCater.vendorConfigurationsAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class VendorConfigurations {
	
	public static WebDriver driver;

	static {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "D:/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--headless=new");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			options.addArguments("--disable-notifications");
		//	driver.manage().window().setSize(new Dimension(1920, 1080));
			driver.get("https://partner-uat.youcater.me/login");
		}
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}

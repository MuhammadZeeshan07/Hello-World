package org.youCater.userRegressionTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.HomePageElements;

public class PartnerRegistrationTestCases extends Configurations {

	private HomePageElements homePageElements;
	public PartnerRegistrationTestCases() {

		homePageElements = new HomePageElements(driver);
		wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(8));
	}

	@Test(priority = 1, description = "HomePage: Verify that partner registered successfully")
	public void partnerRegistration() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.partnerWithUs();
		Thread.sleep(2000);
		homePageElements.enterPartnerName();
		Thread.sleep(2000);
		homePageElements.enterPartnerEmail();
		Thread.sleep(2000);
		homePageElements.enterPartnerContactName();
		Thread.sleep(2000);
		WebElement selectCountry = driver.findElement(By.name("phoneNumberCountry"));
		Select select = new Select(selectCountry);
		select.selectByVisibleText("Pakistan");
		Thread.sleep(2000);
		driver.findElement(By.id("phoneNumber")).sendKeys("3094359330");
		Thread.sleep(2000);
		homePageElements.enterCuisine();
		Thread.sleep(2000);
		homePageElements.acceptPrivacy();
		Thread.sleep(2000);
		homePageElements.submitRegisterationForm();
		Thread.sleep(2000);	

	}

}

package org.youCater.ventorSanitytestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorLoginElements;

public class VendorLoginTestCases extends VendorConfigurations {

	private VendorLoginElements vendorLoginElements;
	private WebDriverWait wait;
	private SoftAssert softAssert;

	public VendorLoginTestCases() {

		vendorLoginElements = new VendorLoginElements(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		softAssert = new SoftAssert();
	}

	@Test
	public void login() throws InterruptedException {
		
		Thread.sleep(2000);
		vendorLoginElements.enterEmail();
		Thread.sleep(2000);
		vendorLoginElements.enterPassword();
		Thread.sleep(2000);
		vendorLoginElements.rememberMeCheckBox();
		Thread.sleep(2000);
		vendorLoginElements.loginCta();
		By toastLocator = By.xpath("//*[contains(@class, 'MuiAlert-message') and text() = 'Vendor Login Success']");
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		softAssert.assertTrue(toastElement.isDisplayed(), "Toast message is displayed");

	}

}

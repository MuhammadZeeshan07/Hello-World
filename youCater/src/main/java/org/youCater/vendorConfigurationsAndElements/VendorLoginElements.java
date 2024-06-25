package org.youCater.vendorConfigurationsAndElements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorLoginElements {

	private JavascriptExecutor js;
	private WebDriverWait wait;

	// Locators
	@FindBy(id = "email")
	private WebElement enterEmail;

	@FindBy(id = "password")
	private WebElement enterPassword;

	@FindBy(xpath = "//img[@alt='Avatar']")
	private WebElement vendorProfile;

	@FindBy(xpath = "//button[text()=\"Logout\"]")
	private WebElement logout;

	// Constructor
	public VendorLoginElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));

	}

	// Actions

	public void enterEmail() {

		wait.until(ExpectedConditions.visibilityOf(enterEmail)).sendKeys("yash@mailinator.com");
	}

	public void enterPassword() {

		wait.until(ExpectedConditions.visibilityOf(enterPassword)).sendKeys("123456");
	}

	public void rememberMeCheckBox() {

		WebElement checkbox = (WebElement) js.executeScript(
				"return document.evaluate(\"//*[text()='Remember me']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

	}

	public void loginCta() {

		WebElement login = (WebElement) js.executeScript(
				"return document.evaluate(\"//*[text()='Continue']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;");
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();

	}

	public void logout() {

		wait.until(ExpectedConditions.elementToBeClickable(vendorProfile)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
	}

}

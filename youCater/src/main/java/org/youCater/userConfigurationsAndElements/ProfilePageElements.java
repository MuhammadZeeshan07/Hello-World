package org.youCater.userConfigurationsAndElements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageElements {

	private WebDriverWait wait;
	private JavascriptExecutor js;

	@FindBy(xpath = "//*[@aria-label=\"User Profile\"]")
	private WebElement goToProfile;
	
	@FindBy(xpath = "//a[@href=\"/en/my-profile\"]")
	private WebElement openProfile;
	
	@FindBy(xpath = "//*[text()=\"Log out\"]")
	private WebElement logout;

	@FindBy(xpath = "//*[text()='Confirm']")
	private WebElement logoutConfirmation;

	@FindBy(xpath = "//button[@type='button']//*[name()='svg']")
	private WebElement editProfile;

	@FindBy(xpath = "//button[@type='submit' and contains(text(),\"Update\")]")
	private WebElement updateProfile;

	@FindBy(id = "privacyLink")
	private WebElement privacyPolicy;

	@FindBy(id = "privacyPolicyLink")
	private WebElement privacyPolicySubMenu;

	@FindBy(id = "cookiePolicyLink")
	private WebElement cookiePolicy;

	@FindBy(id = "termsAndConditionLink")
	private WebElement termsAndCondition;

	@FindBy(id = "termsOfService")
	private WebElement termsOfService;

	@FindBy(id = "fairUsagePolicy")
	private WebElement fairUsagePolicy;

	@FindBy(id = "deleteAccountModalBtn")
	private WebElement deleteAccountModalBtn;

	@FindBy(id = "deleteAccountBtn")
	private WebElement deleteAccountBtn;

	@FindBy(xpath = "//button[@class=\"img-hold\"]")
	private WebElement closeDeleteModal;

	// Constructor
	public ProfilePageElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
	}

	public void goToProfile() {

		js.executeScript("arguments[0].scrollIntoView(true);", goToProfile);
		wait.until(ExpectedConditions.elementToBeClickable(goToProfile)).click();
	}
	
	public void openProfile() {
		
		wait.until(ExpectedConditions.elementToBeClickable(openProfile)).click();
	}
	
	

	public void logout() throws InterruptedException {

		js.executeScript("arguments[0].scrollIntoView(true);", logout);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", logout);

	}

	public void logoutConfirmation() {

		wait.until(ExpectedConditions.elementToBeClickable(logoutConfirmation)).click();
	}

	public void editProfile() {

		wait.until(ExpectedConditions.elementToBeClickable(editProfile)).click();
	}

	public void updateProfile() {
		js.executeScript("arguments[0].scrollIntoView(true);", updateProfile);
		wait.until(ExpectedConditions.elementToBeClickable(updateProfile)).click();
	}

	public void privacyPolicy() {

		js.executeScript("arguments[0].scrollIntoView(true);", privacyPolicy);
		js.executeScript("arguments[0].click();", privacyPolicy);

	}

	public void privacyPolicySubMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(privacyPolicySubMenu)).click();
	}

	public void cookiePolicy() {

		wait.until(ExpectedConditions.elementToBeClickable(cookiePolicy)).click();

	}

	public void termsAndCondition() {

		js.executeScript("arguments[0].scrollIntoView(true);", termsAndCondition);
		js.executeScript("arguments[0].click();", termsAndCondition);
	}

	public void termsOfService() {

		wait.until(ExpectedConditions.elementToBeClickable(termsOfService)).click();
	}

	public void fairUsagePolicy() {

		wait.until(ExpectedConditions.elementToBeClickable(fairUsagePolicy)).click();
	}

	public void deleteAccountModalBtn() {

		js.executeScript("arguments[0].scrollIntoView(true);", deleteAccountModalBtn);
		js.executeScript("arguments[0].click();", deleteAccountModalBtn);

	}

	public void deleteAccountBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteAccountBtn)).click();
	}

	public void closeDeleteModal() {

		wait.until(ExpectedConditions.elementToBeClickable(closeDeleteModal)).click();
	}

}

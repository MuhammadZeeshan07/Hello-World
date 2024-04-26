package org.youCater.userRegressionTestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.ProfilePageElements;
import org.youCater.utils.WebActions;

public class ProfileTestCases extends Configurations {

	private ProfilePageElements profilePageElements;
	private WebActions webActions;
	private SoftAssert softAssert;

	public ProfileTestCases() {

		profilePageElements = new ProfilePageElements(driver);
		webActions = new WebActions(driver);
		softAssert = new SoftAssert();
	}

	@Test(description = "Profile: Verify navigation to the user profile")
	public void goToProfile() throws InterruptedException {

		Thread.sleep(2000);
		profilePageElements.openProfile();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void openPrivacyPolicy() throws InterruptedException {

		profilePageElements.privacyPolicy();
		Thread.sleep(2000);
		profilePageElements.privacyPolicySubMenu();
		String expectedUrlPrivacy = "https://dev.youcater.me/en/privacy-policy/";
		wait.until(ExpectedConditions.urlToBe(expectedUrlPrivacy));
		String actualUrlPrivacy = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrlPrivacy, expectedUrlPrivacy);
		webActions.scrollUpAndDown();
		driver.navigate().back();
		Thread.sleep(2000);
		profilePageElements.cookiePolicy();
		String expectedUrlCookie = "https://dev.youcater.me/en/cookie-policy/";
		wait.until(ExpectedConditions.urlToBe(expectedUrlCookie));
		String actualUrlCookie = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrlCookie, expectedUrlCookie);
		softAssert.assertAll();
		webActions.scrollUpAndDown();
		driver.navigate().back();
		driver.navigate().back();

	}

	@Test(priority = 2)
	public void openTermsAndCondition() throws InterruptedException {

		profilePageElements.termsAndCondition();
		Thread.sleep(2000);
		profilePageElements.termsOfService();
		String expectedUrlTerms = "https://dev.youcater.me/en/terms-of-use/";
		wait.until(ExpectedConditions.urlToBe(expectedUrlTerms));
		String actualUrlTerms = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrlTerms, expectedUrlTerms);
		webActions.scrollUpAndDown();
		driver.navigate().back();
		Thread.sleep(2000);
		profilePageElements.fairUsagePolicy();
		String expectedUrlFair = "https://dev.youcater.me/en/acceptable-use-policy/";
		wait.until(ExpectedConditions.urlToBe(expectedUrlFair));
		String actualUrlFair = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrlFair, expectedUrlFair);
		softAssert.assertAll();
		webActions.scrollUpAndDown();
		driver.navigate().back();
		driver.navigate().back();

	}

}

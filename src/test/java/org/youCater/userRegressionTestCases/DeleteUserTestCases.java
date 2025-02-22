package org.youCater.userRegressionTestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.ProfilePageElements;

public class DeleteUserTestCases extends Configurations {

	private ProfilePageElements profilePageElements;

	public DeleteUserTestCases() {

		profilePageElements = new ProfilePageElements(driver);
	}

	@Test(description = "Profile: Verify user account deleted successFully")
	public void deleteUserAccount() throws InterruptedException {

		Thread.sleep(2000);
		profilePageElements.deleteAccountModalBtn();
		Thread.sleep(2000);
		profilePageElements.closeDeleteModal();
		Thread.sleep(2000);
		profilePageElements.deleteAccountModalBtn();
		Thread.sleep(2000);
		profilePageElements.deleteAccountBtn();
		Thread.sleep(2000);
		String expectedUrl = "https://uat.youcater.me/en/";
		wait.until(ExpectedConditions.urlToBe(expectedUrl));
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

}

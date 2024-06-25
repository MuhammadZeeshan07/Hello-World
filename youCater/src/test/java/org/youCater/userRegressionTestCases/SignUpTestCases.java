package org.youCater.userRegressionTestCases;

import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.ProfilePageElements;
import org.youCater.userConfigurationsAndElements.SignUpElements;

public class SignUpTestCases extends Configurations{
	
	private SignUpElements signUpElements;
	private ProfilePageElements profilePageElements;

	public SignUpTestCases() {

		signUpElements = new SignUpElements(driver);
		profilePageElements = new ProfilePageElements(driver);
		
	}
	
	@Test(description = "Sign Up")
	public void DoSignUp() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		signUpElements.clickOnLogin();
		Thread.sleep(2000);
		signUpElements.clickOnSignup();
		Thread.sleep(2000);
		signUpElements.enterName();
		Thread.sleep(2000);
		signUpElements.enterEmail();
		Thread.sleep(2000);
		signUpElements.enterPhoneNo();
		Thread.sleep(2000);
		signUpElements.enterPassword();
		Thread.sleep(2000);
		signUpElements.enterConfirmPassword();
		Thread.sleep(2000);
		signUpElements.submitForm();
		Thread.sleep(2000);
	}
	
	@Test(priority = 1 , description = "Profile: Verify navigation to the user profile")
	public void goToProfile() throws InterruptedException {
		Thread.sleep(2000);
		profilePageElements.goToProfile();
		Thread.sleep(2000);
		profilePageElements.openProfile();
		Thread.sleep(2000);
	}
	
//	@Test(priority = 2 , description = "Profile: Verify logout funtionality")
//	public void logout() throws InterruptedException {
//
//		profilePageElements.logout();
//		Thread.sleep(2000);
//		profilePageElements.logoutConfirmation();
//		Thread.sleep(2000);
//	}
}

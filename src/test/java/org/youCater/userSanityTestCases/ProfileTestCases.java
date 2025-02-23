package org.youCater.userSanityTestCases;

import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.ProfilePageElements;
import org.youCater.utils.AddEventCommonActions;

public class ProfileTestCases extends Configurations {

	private AddEventCommonActions addEventCommonActions;
	private ProfilePageElements profilePageElements;
	private AddEventElements addEventElements;

	public ProfileTestCases() {
		addEventCommonActions = new AddEventCommonActions(driver);
		profilePageElements = new ProfilePageElements(driver);
		addEventElements =  new AddEventElements(driver);
	}

	@Test(description = "Profile: Verify navigation to the user profile")
	public void goToProfile() throws InterruptedException {

		Thread.sleep(2000);
		profilePageElements.goToProfile();
		Thread.sleep(2000);
		profilePageElements.openProfile();
		Thread.sleep(2000);

	}
	
	@Test(priority = 1 , description = "Profile: Verify edit profile funtionality")
	public void editProfile() throws InterruptedException {
		
		profilePageElements.editProfile();
		Thread.sleep(2000);
		addEventElements.enterFullName();
		Thread.sleep(2000);
	//	addEventElements.enterEmail();
	//	Thread.sleep(2000);
		profilePageElements.updateProfile();
		Thread.sleep(2000);
		
	}

	@Test(priority = 2 , description = "Profile: Verify logout funtionality")
	public void logout() throws InterruptedException {

		profilePageElements.logout();
		Thread.sleep(2000);
		profilePageElements.logoutConfirmation();
		Thread.sleep(2000);

	}

	@Test(priority = 3 , description = "Profile: Verify sign-in after logout")
	public void signInAfterLogout() throws InterruptedException {

		addEventCommonActions.signInViaEmailPassword();
		/* addEventCommonActions.verifyOTP(); */
		Thread.sleep(2000);

	}

}

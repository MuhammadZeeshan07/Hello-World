package org.youCater.userRegressionTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.ForgotPasswordElements;
import org.youCater.userConfigurationsAndElements.SignUpElements;

public class ForgotPasswordTestCases extends Configurations{
	
	private ForgotPasswordElements forgotPasswordElements;
	private SignUpElements signUpElements;
	private SoftAssert softAssert;
	
	public ForgotPasswordTestCases () {
		
		forgotPasswordElements = new ForgotPasswordElements(driver);
		signUpElements = new SignUpElements(driver);
		softAssert = new SoftAssert();
	}
	
	@Test(description = "Verify forgot password functionality")
	public void ForgotPassword() throws InterruptedException {
		
		signUpElements.clickOnLogin();
		Thread.sleep(2000);
		forgotPasswordElements.clickForgotPassword();
		Thread.sleep(2000);
		forgotPasswordElements.enterInValidEmail();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(By.className("text-alert"));
		String expectedMessage = "Email is invalid";
		softAssert.assertTrue(error.isDisplayed() && error.getText().equals(expectedMessage),
				"Error message is not displayed or has incorrect text.");
		Thread.sleep(2000);
		
		forgotPasswordElements.enterValidEmail();
		Thread.sleep(2000);
		forgotPasswordElements.clickContinueButton();
		Thread.sleep(2000);
		forgotPasswordElements.clickOKButton();
		Thread.sleep(2000);
	}
}

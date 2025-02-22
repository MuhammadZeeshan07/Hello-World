package org.youCater.ventorSanitytestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class ShowInterestInAnEvent extends VendorConfigurations {

	private SoftAssert softAssert;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private RequestAcceptanceAndQuoteSubmissionTestCases acceptanceAndQuoteSubmissionTestCases;

	public ShowInterestInAnEvent() {

		softAssert = new SoftAssert();
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		acceptanceAndQuoteSubmissionTestCases = new RequestAcceptanceAndQuoteSubmissionTestCases();

	}

	@Test(description = "SubmitInterest: Verify that vendor can submit interest on an event")
	public void showInterest() throws InterruptedException {
		
		Thread.sleep(2000);
		vendorEventDirectoryElements.goToEventDirectory();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.selectADirectEvent();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.checkDetails();
		Thread.sleep(2000);
		vendorEventDirectoryElements.showInterest();
		Thread.sleep(2000);
		WebElement toastElement = driver.findElement(By.xpath("//*[contains(@class,\"MuiAlert-message\")]"));
		String expectedToastMessage = "Event moved to in-progress!";
		softAssert.assertTrue(toastElement.isDisplayed() && toastElement.getText().equals(expectedToastMessage),
				"Toast message is not displayed or has incorrect text.");
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 1 , description = "Send Quote: Verify that vendor can submit quote on an event")
	public void SubmitQuote() throws InterruptedException {
		
		/*
		 * acceptanceAndQuoteSubmissionTestCases.goToChatMenu(); Thread.sleep(2000);
		 */
		acceptanceAndQuoteSubmissionTestCases.goToMyQuoteMenu();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.submitQuote();
		Thread.sleep(2000);
	}
	
}

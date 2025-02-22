package org.youCater.ventorSanitytestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.vendorConfigurationsAndElements.VendorActiveEventsElements;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class DeclineEventFromChatTestCases extends VendorConfigurations {
	
	private RequestAcceptanceAndQuoteSubmissionTestCases acceptanceAndQuoteSubmissionTestCases;
	private VendorActiveEventsElements vendorActiveEventsElements;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private SoftAssert softAssert;
	
	public DeclineEventFromChatTestCases() {
		
		acceptanceAndQuoteSubmissionTestCases = new RequestAcceptanceAndQuoteSubmissionTestCases();
		vendorActiveEventsElements = new VendorActiveEventsElements(driver);
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		softAssert = new SoftAssert();
		
	}
	
	@Test(description = "Decline Event: Verify that vendor can decline an event from the chat menu")
	public void declineEvent() throws InterruptedException {

		vendorActiveEventsElements.goToInProgressEvents();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.selectADirectEvent();
		Thread.sleep(2000);
		/*
		 * acceptanceAndQuoteSubmissionTestCases.goToChatMenu(); Thread.sleep(2000);
		 */
		vendorEventDirectoryElements.declineEvent();
		Thread.sleep(2000);
		List<WebElement> reasonList = vendorEventDirectoryElements.declineReason();

		if (!reasonList.isEmpty()) {
			WebElement selectReason = reasonList.get(1);
			selectReason.click();

		}
		Thread.sleep(2000);
		vendorEventDirectoryElements.declineRequestConfirmation();
		Thread.sleep(2000);

		WebElement toastElement = driver.findElement(By.xpath("//*[contains(@class,\"MuiAlert-message\")]"));
		String expectedToastMessage = "Event Declined";
		softAssert.assertTrue(toastElement.isDisplayed() && toastElement.getText().equals(expectedToastMessage),
				"Toast message is not displayed or has incorrect text.");
		
		
		
		
		
	}
}

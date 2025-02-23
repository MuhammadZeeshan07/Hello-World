package org.youCater.ventorSanitytestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class DeclineRequestTestCases extends VendorConfigurations {

	private SoftAssert softAssert;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private RequestAcceptanceAndQuoteSubmissionTestCases acceptanceAndQuoteSubmissionTestCases;

	public DeclineRequestTestCases() {

		softAssert = new SoftAssert();
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		acceptanceAndQuoteSubmissionTestCases = new RequestAcceptanceAndQuoteSubmissionTestCases();

	}

	@Test
	public void declineRequest() throws InterruptedException {

		
		Thread.sleep(2000);
		vendorEventDirectoryElements.goToEventDirectory();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.goToActiveEvents();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.goToDirectEvents();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.selectADirectEvent();
		Thread.sleep(2000);
		acceptanceAndQuoteSubmissionTestCases.checkDetails();
		Thread.sleep(2000);
		vendorEventDirectoryElements.declineRequest();
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

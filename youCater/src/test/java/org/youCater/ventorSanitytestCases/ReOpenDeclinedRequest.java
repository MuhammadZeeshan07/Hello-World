package org.youCater.ventorSanitytestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.utils.AddEventCommonActions;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class ReOpenDeclinedRequest extends VendorConfigurations {

	private SoftAssert softAssert;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private AddEventCommonActions addEventCommonActions;

	public ReOpenDeclinedRequest() {

		softAssert = new SoftAssert();
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		addEventCommonActions = new AddEventCommonActions(driver);

	}

	@Test(description = "Reopen: Verify that event is Re-opened and moved to InProgess")
	public void reOpenRequest() throws InterruptedException {

		Thread.sleep(2000);
		vendorEventDirectoryElements.reOpenRequest();
		Thread.sleep(2000);
		String expectedTitle = "Do you want to re-open this event?";
		String expectedDescription = "Re-opening the event will re-enable chats and quotes, and move the event to the in progress section";
		addEventCommonActions.assertTextEquals(driver, "//strong[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//div[@class=\"modalBody\"]/p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();
		Thread.sleep(2000);
		vendorEventDirectoryElements.reOpenConfirmation();
		Thread.sleep(2000);
		WebElement toastElement = driver.findElement(By.xpath("//*[contains(@class,\"MuiAlert-message\")]"));
		String expectedToastMessage = "Event moved to in-progress!";
		softAssert.assertTrue(toastElement.isDisplayed() && toastElement.getText().equals(expectedToastMessage),
				"Toast message is not displayed or has incorrect text.");

	}

}

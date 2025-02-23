package org.youCater.ventorSanitytestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.utils.WebActions;
import org.youCater.vendorConfigurationsAndElements.VendorActiveEventsElements;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class RequestAcceptanceAndQuoteSubmissionTestCases extends VendorConfigurations {

	private SoftAssert softAssert;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private WebActions webActions;
	private VendorActiveEventsElements vendorActiveEventsElements;

	public RequestAcceptanceAndQuoteSubmissionTestCases() {

		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		softAssert = new SoftAssert();
		webActions = new WebActions(driver);
		vendorActiveEventsElements = new VendorActiveEventsElements(driver);
	}

	@Test
	public void goToActiveEvents() throws InterruptedException {
		Thread.sleep(2000);
		vendorActiveEventsElements.goToActiveEvents();
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void goToDirectEvents() throws InterruptedException {
		vendorActiveEventsElements.goToDirectRequestMenu();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void selectADirectEvent() throws InterruptedException {

		List<WebElement> eventList = vendorEventDirectoryElements.selectAnEvent();

		if (!eventList.isEmpty()) {
			WebElement selectEvent = eventList.get(0);
			selectEvent.click();

		}
		webActions.switchTabAndCloseOriginal();
	}

	@Test(priority = 3)
	public void checkDetails() throws InterruptedException {

		Thread.sleep(2000);
		vendorEventDirectoryElements.checkDetails();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void acceptRequest() throws InterruptedException {

		Thread.sleep(2000);
		vendorEventDirectoryElements.acceptRequest();
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void goToChatMenu() throws InterruptedException {

		vendorEventDirectoryElements.goToChat();
		Thread.sleep(2000);
		vendorEventDirectoryElements.sendMessage();
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void goToMyQuoteMenu() throws InterruptedException {

		vendorEventDirectoryElements.goToMyQuote();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void checkErrorForLessQuoteAmount() throws InterruptedException {

		vendorEventDirectoryElements.clickAddQuoteButton();
		Thread.sleep(2000);
		vendorEventDirectoryElements.enterLessQuoteAmount();
		Thread.sleep(2000);

		WebElement error = driver.findElement(By.id("quoteAmount-helper-text"));
		String expectedMessage = "Amount should be greater than or equal to 400";
		softAssert.assertTrue(error.isDisplayed() && error.getText().equals(expectedMessage),
				"Error message is not displayed or has incorrect text.");
		Thread.sleep(2000);

		vendorEventDirectoryElements.closeModal();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void submitQuote() throws InterruptedException {

		vendorEventDirectoryElements.clickAddQuoteButton();
		Thread.sleep(2000);
		vendorEventDirectoryElements.enterQuoteAmount();
		Thread.sleep(2000);
		vendorEventDirectoryElements.attachQuoteFile();
		Thread.sleep(2000);
		vendorEventDirectoryElements.enterVAT();
		Thread.sleep(2000);

		vendorEventDirectoryElements.enterMunicipalityTax();
		Thread.sleep(2000);
		vendorEventDirectoryElements.enterQuoteComments();
		Thread.sleep(2000);
		vendorEventDirectoryElements.submitQuote();
		Thread.sleep(2000);

		WebElement toastElement = driver.findElement(By.xpath("//*[contains(@class,\"MuiAlert-message\")]"));
		String expectedToastMessage = "Quote Placed Successfully!";
		softAssert.assertTrue(toastElement.isDisplayed() && toastElement.getText().equals(expectedToastMessage),
				"Toast message is not displayed or has incorrect text.");

		vendorEventDirectoryElements.goToChat();
		Thread.sleep(2000);

	}

}

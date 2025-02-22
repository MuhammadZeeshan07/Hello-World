package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.EventsListingElements;
import org.youCater.userConfigurationsAndElements.HomePageElements;
import org.youCater.utils.WebActions;

public class CancelEventAfterQuoteSubmissionByVendorTestCases extends Configurations {

	private WebActions webActions;
	private CancelEventElements cancelEventElements;
	public CancelEventAfterQuoteSubmissionByVendorTestCases() {

		webActions = new WebActions(driver);
		cancelEventElements = new CancelEventElements(driver);
		new HomePageElements(driver);
		new EventsListingElements(driver);
	}

	@Test
	public void cancelEventAfterQuoteSubmissionByVendor() throws InterruptedException {

		Thread.sleep(2000);
		cancelEventElements.clickEventCard();
		Thread.sleep(2000);
		webActions.scrollUpAndDown();
		cancelEventElements.cancelEventCta();
		Thread.sleep(2000);
		List<WebElement> reasonList = cancelEventElements.selectCancellationReason();

		if (!reasonList.isEmpty()) {
			WebElement selectReason = reasonList.get(1);
			selectReason.click();

		}
		Thread.sleep(2000);
		cancelEventElements.cancelEvent();
		Thread.sleep(2000);
		cancelEventElements.goToEvents();
		Thread.sleep(2000);
		cancelEventElements.clickLogo();
		Thread.sleep(2000);
	}

}

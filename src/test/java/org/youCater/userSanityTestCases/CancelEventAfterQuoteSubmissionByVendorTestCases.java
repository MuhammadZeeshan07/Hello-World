package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.By;
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
	private HomePageElements homePageElements;
	private EventsListingElements eventsListingElements;

	public CancelEventAfterQuoteSubmissionByVendorTestCases() {

		webActions = new WebActions(driver);
		cancelEventElements = new CancelEventElements(driver);
		homePageElements = new HomePageElements(driver);
		eventsListingElements = new EventsListingElements(driver);
	}

	@Test
	public void cancelEventAfterQuoteSubmissionByVendor() throws InterruptedException {

		homePageElements.eventMenu();
		Thread.sleep(2000);
		List<WebElement> pendingEvents = eventsListingElements.pendingEventsList();
		if (!pendingEvents.isEmpty()) {
			List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class,'bidsBadge')]"));

			for (WebElement element : elements) {
				String quoteCountText = element.getText();
				String numericPart = quoteCountText.replaceAll("[^0-9]", "");
				int quoteCount = Integer.parseInt(numericPart);
				if (quoteCount > 0) {
					element.click();
					break;
				}

			}
			Thread.sleep(2000);
		}
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
	}

}

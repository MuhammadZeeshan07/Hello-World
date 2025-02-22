package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.WebActions;

public class CancelEventTestCases extends Configurations {

	private WebActions webActions;
	private CancelEventElements cancelEventElements;

	public CancelEventTestCases() {

		webActions = new WebActions(driver);
		cancelEventElements = new CancelEventElements(driver);
	}

	@Test(description = "HomePage: Verify selection of pending events")
	public void selectEventsOnHomePage() throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> eventList = cancelEventElements.selectPendingEvents();

		if (!eventList.isEmpty()) {
			WebElement selectPendingEvent = eventList.get(0);
			selectPendingEvent.click();

		}
		Thread.sleep(2000);
		webActions.scrollUpAndDown();
		Thread.sleep(2000);
	}

	@Test(priority = 1, description = "CancelEvent: Verify cancellation of pending events")
	public void cancelEvent() throws InterruptedException {
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
		webActions.scrollUpAndDown();

		WebElement deletedEvent = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()='Cancelled']/following-sibling::div[contains(@class,'rowSimpleEventCard')]")));
		assert deletedEvent.isDisplayed();

	}

}

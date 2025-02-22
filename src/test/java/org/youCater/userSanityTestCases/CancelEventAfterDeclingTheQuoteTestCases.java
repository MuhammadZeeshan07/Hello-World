package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.WebActions;

public class CancelEventAfterDeclingTheQuoteTestCases extends Configurations {

	private WebActions webActions;
	private CancelEventElements cancelEventElements;

	public CancelEventAfterDeclingTheQuoteTestCases() {

		webActions = new WebActions(driver);
		cancelEventElements = new CancelEventElements(driver);
	}

	@Test
	public void cancelEventAfterDeclingQuote() throws InterruptedException {

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

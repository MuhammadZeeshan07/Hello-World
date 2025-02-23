package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.WebActions;

public class CancelEventAfterAcceptingQuoteTestCases extends Configurations {

	private CancelEventElements cancelEventElements;
	private WebActions webActions;

	public CancelEventAfterAcceptingQuoteTestCases() {

		cancelEventElements = new CancelEventElements(driver);
		webActions =  new WebActions(driver);

	}

	@Test
	public void cancelEventAfterAcceptingQuote() throws InterruptedException {
		
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
		cancelEventElements.cancelEvent();
		Thread.sleep(2000);
		cancelEventElements.goToEvents();
		Thread.sleep(2000);
		cancelEventElements.clickLogo();
		Thread.sleep(2000);
	}

}

package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.AcceptQuoteElements;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.EventsListingElements;
import org.youCater.userConfigurationsAndElements.HomePageElements;

public class DeclineQuoteTestCases extends Configurations {

	private AcceptQuoteElements acceptQuoteElements;
	private CancelEventElements cancelEventElements;
	private HomePageElements homePageElements;
	private EventsListingElements eventsListingElements;
	private AcceptQuoteTestCases acceptQuoteTestCases;

	public DeclineQuoteTestCases() {

		acceptQuoteElements = new AcceptQuoteElements(driver);
		cancelEventElements = new CancelEventElements(driver);
		homePageElements = new HomePageElements(driver);
		eventsListingElements = new EventsListingElements(driver);
		acceptQuoteTestCases = new AcceptQuoteTestCases();
	}

	@Test(description = "Verify selection of an event")
	public void selectEvent() throws InterruptedException {

		homePageElements.eventMenu();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		List<WebElement> eventList = eventsListingElements.pendingEventsList();

		if (!eventList.isEmpty()) {
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

	}

	@Test(priority = 1, description = "Verify that user can decline the quote request sent by partner")
	public void declineQuote() throws InterruptedException {

		acceptQuoteTestCases.selectActiveQuote();
		Thread.sleep(2000);
		acceptQuoteElements.viewQuotes();
		Thread.sleep(2000);
		acceptQuoteElements.acceptAndCheckout();
		Thread.sleep(2000);
		cancelEventElements.declineQuoteCta();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='OTHER']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter reason']")).sendKeys("Not interested");
		Thread.sleep(2000);
		cancelEventElements.declineQuote();
		Thread.sleep(2000);

	}

}

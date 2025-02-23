package org.youCater.userSanityTestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.AcceptQuoteElements;
import org.youCater.userConfigurationsAndElements.CancelEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.AddEventCommonActions;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class AcceptQuoteTestCases extends Configurations {

	private AcceptQuoteElements acceptQuoteElements;
	private CancelEventElements cancelEventElements;
	private AddEventCommonActions addEventCommonActions;
	private MakeACall makeACall;
	private SoftAssert softAssert;
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private JavascriptExecutor js;

	public AcceptQuoteTestCases() {

		acceptQuoteElements = new AcceptQuoteElements(driver);
		cancelEventElements = new CancelEventElements(driver);
		addEventCommonActions = new AddEventCommonActions(driver);
		makeACall = new MakeACall();
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
		js = (JavascriptExecutor) driver;
		softAssert = new SoftAssert();
	}

	@Test(description = "HomePage: Verify selection of Inprogress events")
	public void selectEventsOnHomePage() throws InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		List<WebElement> eventList = cancelEventElements.selectPendingEvents();

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


	@Test(priority = 2, description = "EventDetail: Verify selection of active quotes")
	public void selectActiveQuote() throws InterruptedException {
		List<WebElement> quoteList = acceptQuoteElements.selectActiveQuote();

		if (!quoteList.isEmpty()) {
			WebElement selectQuote = quoteList.get(0);
			js.executeScript("arguments[0].click();", selectQuote);
		}
		Thread.sleep(2000);

	}

	@Test(priority = 3, description = "AcceptQuote: Verify accept active quotes funtionality")
	public void AcceptQuote() throws InterruptedException {

		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		makeACall.customerMakeACall();
		Thread.sleep(4000);
		
		vendorEventDirectoryElements.sendMessage();
		Thread.sleep(4000);
		acceptQuoteElements.viewQuotes();
		Thread.sleep(2000);
		acceptQuoteElements.acceptAndCheckout();
		Thread.sleep(2000);
		/*
		 * webActions.scrollUpAndDown(); acceptQuoteElements.enterPromoCode();
		 * Thread.sleep(3000); acceptQuoteElements.applyPromoCode(); Thread.sleep(3000);
		 */
		acceptQuoteElements.acceptTermsAndConditions();
		Thread.sleep(2000);
		acceptQuoteElements.acceptAndPay();
		Thread.sleep(4000);
	}

	@Test(priority = 4, description = "StripePaymentScreen: Verify payment funtionality")
	public void makePayment() throws InterruptedException {

		acceptQuoteElements.enterEmail();
		Thread.sleep(2000);
		acceptQuoteElements.enterCardNumber();
		Thread.sleep(2000);
		acceptQuoteElements.enterCardExpiry();
		Thread.sleep(2000);
		acceptQuoteElements.enterCvc();
		Thread.sleep(2000);
		acceptQuoteElements.enterName();
		Thread.sleep(2000);
		acceptQuoteElements.enterAddress();
		Thread.sleep(2000);
		acceptQuoteElements.enterCity();
		Thread.sleep(2000);
		acceptQuoteElements.enterPostalCode();
		Thread.sleep(2000);
		acceptQuoteElements.pay();
		Thread.sleep(12000);
		String expectedTitle = "Thank you!";
		String expectedDescription = "You are all set. You may continue chatting with the Partner for further coordination.";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();
		acceptQuoteElements.goBackToEvents();
		Thread.sleep(2000);

	}

}

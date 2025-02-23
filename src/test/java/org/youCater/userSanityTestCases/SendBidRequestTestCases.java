package org.youCater.userSanityTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.EventsListingElements;
import org.youCater.userConfigurationsAndElements.HomePageElements;
import org.youCater.userConfigurationsAndElements.SendBidRequestElements;

public class SendBidRequestTestCases extends Configurations {

	private SendBidRequestElements sendBidRequestElements;
	private AddEventElements addEventElements;
	private EventsListingElements eventsListingElements;
	private SoftAssert softAssert;
	private HomePageElements homePageElements;

	public SendBidRequestTestCases() {
		sendBidRequestElements = new SendBidRequestElements(driver);
		addEventElements = new AddEventElements(driver);
		eventsListingElements = new EventsListingElements(driver);
		homePageElements = new HomePageElements(driver);
		softAssert = new SoftAssert();
	}

	@Test(description = "SendBidRequest: Verify caterer search functionality")
	public void findCaterers() throws InterruptedException {

		homePageElements.eventMenu();
		Thread.sleep(2000);
		List<WebElement> pendingEvents = eventsListingElements.pendingEventsList();
		if (!pendingEvents.isEmpty()) {
			WebElement selectPendingEvent = pendingEvents.get(0);
			selectPendingEvent.click();
		}
		Thread.sleep(2000);
		sendBidRequestElements.findCaterers();
		Thread.sleep(3000);
	}

	@Test(priority = 1, description = "SendBidRequest: Verify caterer selection functionality")
	public void selecCaterer() throws InterruptedException {

		homePageElements.searchVendor();
		Thread.sleep(2000);
		List<WebElement> catererList = sendBidRequestElements.selectPartner();
		String targetVendorId = "4a0a30fe-e251-42a0-90a8-cc3a5cefb961";
		for (WebElement element : catererList) {
			String href = element.getAttribute("href");
			if (href.contains("vendorId=" + targetVendorId)) {
				wait.until(ExpectedConditions.elementToBeClickable(element)).click();
				break;
			}
		}
		Thread.sleep(2000);
	}

	@Test(priority = 2, description = "SendBidRequest: Verify partner details (About, Menu, Media)")
	public void partnerDetail() throws InterruptedException {
		
		sendBidRequestElements.aboutCaterer();
		Thread.sleep(2000);
	}

	@Test(priority = 3, description = "SendBidRequest: Verify successful request submission")
	public void sendRequest() throws InterruptedException {
		sendBidRequestElements.clickOnSendRequestCta();
		Thread.sleep(2000);
		List<WebElement> eventList = sendBidRequestElements.selectAvailableEvents();

		if (!eventList.isEmpty()) {
			WebElement selectPendingEvent = eventList.get(0);
			selectPendingEvent.click();

		}
		Thread.sleep(2000);
		sendBidRequestElements.sendRequestToCaterer();
		Thread.sleep(2000);
		WebElement toastElement = driver.findElement(By.xpath("//*[contains(@class,'Toaster')]"));
		softAssert.assertTrue(toastElement.isDisplayed());
		softAssert.assertAll();
		addEventElements.youcaterLogo();
		Thread.sleep(2000);
	}

}

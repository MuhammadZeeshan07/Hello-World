package org.youCater.userConfigurationsAndElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsListingElements {

	@FindBy(xpath = "//*[text()=\"Pending\"]/following-sibling::div[contains(@class,\"rowSimpleEventCard\")]")
	private WebElement pendingEventsList;

	@FindBy(xpath = "//*[text()=\"Cancelled\"]/following-sibling::div[contains(@class,\"rowSimpleEventCard\")]")
	private WebElement cancelledEventsList;

	// Constructor
	public EventsListingElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// Actions
	public List<WebElement> pendingEventsList() {

		WebElement parentElement = pendingEventsList;
		List<WebElement> pendingEvents = parentElement.findElements(By.tagName("a"));
		return pendingEvents;
	}

	public List<WebElement> cancelledEventsList() {

		WebElement parentElement = cancelledEventsList;
		List<WebElement> cancelledEvents = parentElement.findElements(By.tagName("a"));
		return cancelledEvents;
	}

}

package org.youCater.vendorConfigurationsAndElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VendorActiveEventsElements {

	private WebDriverWait wait;

	@FindBy(xpath = "//*[text()=\"Direct Request\"]")
	private WebElement goToDirectRequest;

	@FindBy(xpath = "//*[text()=\"Active Events\"]")
	private WebElement goToActiveEvents;
	
	@FindBy(xpath = "//*[text()=\"In Progress\"]")
	private WebElement goToInProgressEvents;
	
	
	

	// Constructor
	public VendorActiveEventsElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));

	}

	// Actions

	public void goToDirectRequestMenu() {

		wait.until(ExpectedConditions.elementToBeClickable(goToDirectRequest)).click();
	}

	public void goToActiveEvents() {

		wait.until(ExpectedConditions.elementToBeClickable(goToActiveEvents)).click();
	}

	public void goToInProgressEvents() {

		wait.until(ExpectedConditions.elementToBeClickable(goToInProgressEvents)).click();
	}
	
}

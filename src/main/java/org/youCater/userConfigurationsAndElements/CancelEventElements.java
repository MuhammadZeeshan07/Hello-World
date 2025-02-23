package org.youCater.userConfigurationsAndElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelEventElements {

	private WebDriverWait wait;
	private JavascriptExecutor js;

	@FindBy(xpath = "//*[contains(@class, \"simpleEventCardWrapper\")]")
	private WebElement selectPendingEvents;

	@FindBy(xpath = "//*[text()=\"Cancel event\"]")
	private WebElement cancelEventCta;

	@FindBy(xpath = "//*[contains(@class,\"radioListHolder\")]")
	private WebElement cancellationReasons;

	@FindBy(xpath = "//*[text()=\"Cancel Event\"]")
	private WebElement cancelEvent;

	@FindBy(xpath = "//*[text()=\"Back\"]")
	private WebElement closeModalByBackButton;

	@FindBy(xpath = "//*[@aria-label=\"Back to events\"]")
	private WebElement goToEvents;

	@FindBy(xpath = "//button[normalize-space()='Decline']")
	private WebElement declineQuoteCta;

	@FindBy(xpath = "//div[contains(@class,'flex gap-3 lg:gap-5 pt-2 lg:pt-3.5')]//button[contains(@class,'storybook-button--secondary border-secondary-default')][normalize-space()='Decline']")
	private WebElement declineQuote;
	
	@FindBy(linkText = "My dashboard")
	private WebElement dashboard;
	
	@FindBy (className = "simpleEventCard")
	private WebElement selectEvent;

	// Constructor
	public CancelEventElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
	}

	// Actions

	public List<WebElement> selectPendingEvents() {

		WebElement parentElement = selectPendingEvents;
		List<WebElement> eventList = parentElement.findElements(By.tagName("a"));
		return eventList;
	}

	public void cancelEventCta() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelEventCta)).click();
	}

	public List<WebElement> selectCancellationReason() {

		WebElement parentElement = cancellationReasons;
		List<WebElement> reasonsList = parentElement.findElements(By.tagName("div"));
		return reasonsList;
	}

	public void closeModalByBackButton() {

		wait.until(ExpectedConditions.elementToBeClickable(closeModalByBackButton)).click();
	}

	public void cancelEvent() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelEvent)).click();
	}

	public void goToEvents() {

		wait.until(ExpectedConditions.elementToBeClickable(goToEvents)).click();
	}
	

	public void declineQuoteCta() throws InterruptedException {

		js.executeScript("arguments[0].scrollIntoView(true);", declineQuoteCta);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", declineQuoteCta);
	}

	public void declineQuote() {

		wait.until(ExpectedConditions.visibilityOf(declineQuote)).click();
	}
	
	public void clickLogo()
	{
		wait.until(ExpectedConditions.elementToBeClickable(dashboard)).click();
	}
	
	public void clickEventCard() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectEvent)).click();
	}
}

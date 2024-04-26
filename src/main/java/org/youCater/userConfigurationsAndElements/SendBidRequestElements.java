package org.youCater.userConfigurationsAndElements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendBidRequestElements {

	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Actions actions;

	// Locators
	@FindBy(xpath = "//*[text()=\"Find partners\" and @aria-label=\"Add event\"]")
	private WebElement findPartners;

	@FindBy(xpath = "//*[contains(@class,\"vendorsListContainer\")]")
	private WebElement selectPartner;

	@FindBy(xpath = "//*[text()=\"About\"]")
	private WebElement aboutCaterer;

	@FindBy(xpath = "//*[text()=\"Menu\"]")
	private WebElement catererMenu;

	@FindBy(xpath = "//*[contains(@class,\"pt-3\")]/div[contains(@class,\"overflow-y-auto\")]")
	private WebElement viewCatererMenu;

	@FindBy(xpath = "//*[@d=normalize-space(\"M13 13L1 1\")]")
	private WebElement closeMenuCard;

	@FindBy(xpath = "//*[@aria-label=\"Send request\"]")
	private WebElement sendRequestCta;

	@FindBy(xpath = "//*[contains(@class, \"sharePartnerEventsList\")]")
	private WebElement selectAvailableEvents;

	@FindBy(xpath = "//button[text()=\"Send request\"]")
	private WebElement sendRequest;

	// Constructor
	public SendBidRequestElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		js = ((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		actions = new Actions(driver);

	}

	// Actions

	public void findCaterers() throws InterruptedException {

		WebElement findCaterer = findPartners;
		js.executeScript("arguments[0].scrollIntoView(true);", findCaterer);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", findCaterer);
	}

	public List<WebElement> selectPartner() {

		WebElement parentElement = selectPartner;
		js.executeScript("arguments[0].scrollIntoView(true);", parentElement);
		List<WebElement> partnerList = parentElement.findElements(By.tagName("a"));
		return partnerList;
	}

	public void aboutCaterer() {

		wait.until(ExpectedConditions.elementToBeClickable(aboutCaterer)).click();
	}

	public void catererMenu() {
		catererMenu.click();
	}

	public List<WebElement> viewCatererMenu() {

		WebElement parentElement = viewCatererMenu;
		List<WebElement> menuList = parentElement.findElements(By.tagName("div"));
		return menuList;
	}

	public void closeMenuCard() {
		
		actions.click(closeMenuCard).build().perform();
	}

	public void clickOnSendRequestCta() throws InterruptedException {

		WebElement sendRequest = sendRequestCta;
		js.executeScript("arguments[0].scrollIntoView(true);", sendRequest);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sendRequest);
	}

	public List<WebElement> selectAvailableEvents() {

		WebElement parentElement = selectAvailableEvents;
		List<WebElement> eventList = parentElement.findElements(By.tagName("a"));
		return eventList;
	}

	public void sendRequestToCaterer() throws InterruptedException {

		WebElement sendRequestToCaterer = sendRequest;
		js.executeScript("arguments[0].scrollIntoView(true);", sendRequestToCaterer);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", sendRequestToCaterer);

	}

}

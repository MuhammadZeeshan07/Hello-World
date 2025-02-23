package org.youCater.vendorConfigurationsAndElements;

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
import org.youCater.utils.WebActions;

public class VendorEventDirectoryElements {

	private JavascriptExecutor js;
	private WebDriverWait wait;
	private WebActions webActions;

	// Locators

	@FindBy(xpath = "//span[text()=\"Event Directory\"]")
	private WebElement goToEventDirectory;

	@FindBy(xpath = "//*[contains(@class, 'MuiDataGrid-virtualScrollerRenderZone')]")
	private WebElement getEventsList;

	@FindBy(xpath = "//button[contains(@aria-label, \"Chat\")]")
	private WebElement goToChat;

	@FindBy(id = "sendbird-message-input-text-field")
	private WebElement enterMessage;

	@FindBy(xpath = "//button[contains(@class,'sendbird-message-input--send')]")
	private WebElement sendMessage;

	@FindBy(xpath = "//*[contains(@aria-label, \"My quote\")]")
	private WebElement goToMyQuote;

	@FindBy(xpath = "//button[contains(@id, \"details\")]")
	private WebElement goToDetails;

	@FindBy(xpath = "//*[text()=\"Accept Request\"]")
	private WebElement acceptRequest;

	@FindBy(xpath = "//button[normalize-space()='Decline Request']")
	private WebElement declineRequest;

	@FindBy(xpath = "//*[@role=\"radiogroup\"]")
	private WebElement declineReason;

	@FindBy(xpath = "//button[text()=\"Confirm\"]")
	private WebElement declineRequestConfirmation;
	
	@FindBy(xpath = "//button[contains(@class, 'addQuoteBtn')]")
	private WebElement addQuoteButton;
	
	@FindBy(xpath = "//button[contains(@class, 'img-hold')]")
	private WebElement crossButton;

	@FindBy(xpath = "//input[contains(@id, 'quoteAmount')]")
	private WebElement enterQuoteAmount;

	@FindBy(className = "attachQuoteBtn")
	private WebElement attachQuoteFile;
	
	@FindBy(xpath = "//button[contains(text(), 'I’m not VAT registered')]")
	private WebElement VAT;
	
	@FindBy(xpath = "//button[contains(text(), 'Not applicable')]")
	private WebElement municipalityTax;
	
	@FindBy(id = "additionalComments")
	private WebElement enterQuoteComments;	

	@FindBy(xpath = "//button[contains(@class, 'newQuoteFooterBtn')]")
	private WebElement submitQuote;
	
	@FindBy(id = "goToChatBtn")
	private WebElement chatButton;

	@FindBy(xpath = "//button[normalize-space()='Re-Open']")
	private WebElement reOpenRequest;

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	private WebElement reOpenConfirmation;

	@FindBy(xpath = "//button[normalize-space()='Show interest']")
	private WebElement showInterest;
	
	@FindBy(id = "declineEventIcon")
	private WebElement declineEvent;
	
	@FindBy(id = "callIcon")
	private WebElement callIcon;
	
	@FindBy(className = "coreBtnPill")
	private WebElement doneButton;
	
	@FindBy(className = "directCallModal")
	public WebElement modal;

	// Constructor
	public VendorEventDirectoryElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		webActions = new WebActions(driver);
	}

	// Actions

	public void goToEventDirectory() {

		wait.until(ExpectedConditions.elementToBeClickable(goToEventDirectory)).click();
	}

	public List<WebElement> selectAnEvent() {

		WebElement parentElement = getEventsList;
		List<WebElement> selectAnEvent = parentElement.findElements(By.tagName("div"));
		return selectAnEvent;
	}

	public void goToChat() throws InterruptedException {

		WebElement chatMenu = goToChat;
		js.executeScript("arguments[0].scrollIntoView(true);", chatMenu);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", chatMenu);

	}

	public void sendMessage() throws InterruptedException {

		WebElement chat = enterMessage;
		js.executeScript("arguments[0].scrollIntoView(true);", chat);
		wait.until(ExpectedConditions.elementToBeClickable(chat));
		js.executeScript("arguments[0].click();", chat);
		chat.sendKeys(webActions.randomChat());
		wait.until(ExpectedConditions.elementToBeClickable(sendMessage));
		js.executeScript("arguments[0].click();", sendMessage);

	}

	public void goToMyQuote() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(goToMyQuote)).click();

	}

	public void checkDetails() throws InterruptedException {

		WebElement detailMenu = goToDetails;
		js.executeScript("arguments[0].scrollIntoView(true);", detailMenu);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", detailMenu);

	}

	public void acceptRequest() {

		wait.until(ExpectedConditions.elementToBeClickable(acceptRequest)).click();
	}

	public void declineRequest() {

		wait.until(ExpectedConditions.elementToBeClickable(declineRequest)).click();
	}

	public List<WebElement> declineReason() {

		WebElement parentElement = declineReason;
		List<WebElement> reasonsList = parentElement.findElements(By.tagName("label"));
		return reasonsList;
	}

	public void declineRequestConfirmation() {

		wait.until(ExpectedConditions.elementToBeClickable(declineRequestConfirmation)).click();
	}
	
	public void clickAddQuoteButton() throws InterruptedException {
		
		wait.until(ExpectedConditions.elementToBeClickable(addQuoteButton)).click();
		
//		WebElement quoteButton = addQuoteButton;
//		js.executeScript("arguments[0].scrollIntoView(true);", quoteButton);
//		Thread.sleep(2000);
//		js.executeScript("arguments[0].click();", quoteButton);
		
	}

	public void enterLessQuoteAmount() {

		wait.until(ExpectedConditions.visibilityOf(enterQuoteAmount))
				.sendKeys("390");
		js.executeScript("arguments[0].blur();", enterQuoteAmount);
	}
	
	public void closeModal() {
		
		wait.until(ExpectedConditions.visibilityOf(crossButton)).click();
	}
	
	public void enterQuoteAmount() {

		wait.until(ExpectedConditions.visibilityOf(enterQuoteAmount))
				.sendKeys(webActions.generateRandomValue(500, 2000));
	}

	public void attachQuoteFile() {

		String attachment = "D:/driver/QuoteAttachment.pdf";
		WebElement inputElement = (WebElement) js.executeScript("return document.querySelector('[type=\"file\"]');");
		inputElement.sendKeys(attachment);

	}
	
	public void enterVAT() {
		
		wait.until(ExpectedConditions.visibilityOf(VAT));
		js.executeScript("arguments[0].scrollIntoView(true);", VAT);
		js.executeScript("arguments[0].click();", VAT);
		
	}
	
	public void enterMunicipalityTax() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", municipalityTax);
		js.executeScript("arguments[0].click();", municipalityTax);
	}

	public void enterQuoteComments() {
		wait.until(ExpectedConditions.visibilityOf(enterQuoteComments)).sendKeys("Test Comments");
	}

	public void submitQuote() {
		wait.until(ExpectedConditions.elementToBeClickable(submitQuote)).click();
	}
	
	public void goToChatScreen() {
		wait.until(ExpectedConditions.elementToBeClickable(chatButton)).click();
	}

	public void reOpenRequest() {

		wait.until(ExpectedConditions.elementToBeClickable(reOpenRequest)).click();
	}

	public void reOpenConfirmation() {

		wait.until(ExpectedConditions.elementToBeClickable(reOpenConfirmation)).click();
	}

	public void showInterest() {

		wait.until(ExpectedConditions.elementToBeClickable(showInterest)).click();
	}
	
	public void declineEvent() {
		
		wait.until(ExpectedConditions.elementToBeClickable(declineEvent)).click();
		
	}
	
	public void clickOnCall() {
		
		wait.until(ExpectedConditions.elementToBeClickable(callIcon)).click();
		
	}
	
	public void clickDone() {
		
		wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
		
	}
	

}

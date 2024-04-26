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

public class AcceptQuoteElements {

	private WebDriverWait wait;
	private JavascriptExecutor js;

	@FindBy(xpath = "//*[contains(text(),\"View profile\")]")
	private WebElement viewPartnerProfile;

	@FindBy(xpath = "//div[contains(@class,\"lg:gap-3\")]")
	private WebElement selectActiveQuote;

	@FindBy(xpath = "//*[text()=\"Quotes\"]")
	private WebElement viewQuotes;

	@FindBy(xpath = "//*[@arialable=\"Accept & checkout\"]")
	private WebElement AcceptAndCheckout;

	@FindBy(xpath = "//input[@placeholder='Add promo code']")
	private WebElement enterPromoCode;

	@FindBy(xpath = "//*[text()=\"Apply\"]")
	private WebElement applyPromoCode;

	@FindBy(id = "acceptedCheckbox")
	private WebElement acceptTermsAndConditions;

	@FindBy(xpath = "//*[text()=\"Accept & pay\"]")
	private WebElement acceptAndPay;

	@FindBy(id = "email")
	private WebElement enterEmail;

	@FindBy(id = "cardNumber")
	private WebElement enterCardNumber;

	@FindBy(id = "cardExpiry")
	private WebElement enterCardExpiry;

	@FindBy(id = "cardCvc")
	private WebElement enterCvc;

	@FindBy(id = "billingName")
	private WebElement enterName;

	@FindBy(id = "billingAddressLine1")
	private WebElement enterAddress;

	@FindBy(id = "billingLocality")
	private WebElement enterCity;

	@FindBy(id = "billingPostalCode")
	private WebElement enterPostalCode;

	@FindBy(xpath = "//*[@class='SubmitButton-IconContainer']")
	private WebElement pay;

	@FindBy(xpath = "//button[text()=\"Back to event\"]")
	private WebElement backToEvents;

	// Constructor
	public AcceptQuoteElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
	}

	// Actions

	public void viewPartnerProfile() throws InterruptedException {

		WebElement partnerProfile = viewPartnerProfile;
		js.executeScript("arguments[0].scrollIntoView(true);", partnerProfile);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", partnerProfile);
	}

	public List<WebElement> selectActiveQuote() {

		WebElement parentElement = selectActiveQuote;
		js.executeScript("arguments[0].scrollIntoView(true);", parentElement);
		List<WebElement> quoteList = parentElement.findElements(By.tagName("div"));
		return quoteList;
	}

	public void viewQuotes() throws InterruptedException {

		WebElement quote = viewQuotes;
		js.executeScript("arguments[0].scrollIntoView(true);", quote);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", quote);
		WebElement viewQuote = wait.until(ExpectedConditions.elementToBeClickable(quote));
		viewQuote.click();
	}

	public void acceptAndCheckout() {

		wait.until(ExpectedConditions.elementToBeClickable(AcceptAndCheckout)).click();
	}

	public void enterPromoCode() {

		wait.until(ExpectedConditions.visibilityOf(enterPromoCode)).sendKeys("abc10");
	}

	public void applyPromoCode() {

		wait.until(ExpectedConditions.elementToBeClickable(applyPromoCode)).click();
	}

	public void acceptTermsAndConditions() throws InterruptedException {

		WebElement termsAndConditions = acceptTermsAndConditions;
		js.executeScript("arguments[0].scrollIntoView(true);", termsAndConditions);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", termsAndConditions);
	}

	public void acceptAndPay() {

		wait.until(ExpectedConditions.elementToBeClickable(acceptAndPay)).click();
	}

	public void enterEmail() {

		wait.until(ExpectedConditions.visibilityOf(enterEmail)).sendKeys("test@test.com");

	}

	public void enterCardNumber() {

		wait.until(ExpectedConditions.visibilityOf(enterCardNumber)).sendKeys("4242424242424242");
	}

	public void enterCardExpiry() {

		wait.until(ExpectedConditions.visibilityOf(enterCardExpiry)).sendKeys("03/24");
	}

	public void enterCvc() {

		wait.until(ExpectedConditions.visibilityOf(enterCvc)).sendKeys("100");
	}

	public void enterName() {

		wait.until(ExpectedConditions.visibilityOf(enterName)).sendKeys("Muhammad Zeeshan");
	}

	public void enterAddress() {

		wait.until(ExpectedConditions.visibilityOf(enterAddress)).sendKeys("Dubai");
	}

	public void enterCity() {

		wait.until(ExpectedConditions.visibilityOf(enterCity)).sendKeys("Dubai");
	}

	public void enterPostalCode() {

		wait.until(ExpectedConditions.visibilityOf(enterPostalCode)).sendKeys("54770");
	}

	public void pay() throws InterruptedException {

		WebElement payment = pay;
		js.executeScript("arguments[0].scrollIntoView(true);", payment);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", payment);
	}

	public void goBackToEvents() {

		wait.until(ExpectedConditions.elementToBeClickable(backToEvents)).click();
	}

}

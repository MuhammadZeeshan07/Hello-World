package org.youCater.userConfigurationsAndElements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.youCater.utils.WebActions;

public class HomePageElements {

	private WebDriverWait wait;
	private WebActions webActions;
	private JavascriptExecutor js;
	
	@FindBy(xpath = "//*[text()=\"Plan an event\"]")
	private WebElement planAnEvent;

	@FindBy(xpath = "//a[normalize-space()='Event']")
	private WebElement eventMenu;

	@FindBy(xpath = "//a[@href='/en/sign-in' or text()='Login']")
	private WebElement loginFromHomePage;

	@FindBy(xpath = "//a[@href=\"/en/vendors/directory\" or text()=\"Directory\"]")
	private WebElement goToDirectory;

	@FindBy(xpath = "//a[@arialable=\"Create event\"]")
	private WebElement createEventBtn;

	@FindBy(xpath = "//input[contains(@class,\"searchInputField\")]")
	private WebElement searchVendor;

	@FindBy(xpath = "//a[@href=\"/en/partner\" or  @class=\"text-base\"]")
	private WebElement partnerWithUs;
	
	@FindBy(id = "catererName")
	private WebElement partnerName;

	@FindBy(id = "contactName")
	private WebElement partnerContactName;

	@FindBy(id = "phoneNumber")
	private WebElement enterPartnerPhoneNumber;

	@FindBy(name = "phoneNumberCountry")
	private WebElement selectPhoneNoCountry;

	@FindBy(id = "cuisine")
	private WebElement enterCuisine;
	
	@FindBy(id = "acceptPrivacy")
	private WebElement acceptPrivacy;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitRegisterationForm;
	
	@FindBy(id = "email")
	private WebElement enterPartnerEmail;

	// Constructor
	public HomePageElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		webActions = new WebActions(driver);
		js = (JavascriptExecutor) driver;
	}

	// Actions
	public void planAnEvent() {

		wait.until(ExpectedConditions.elementToBeClickable(planAnEvent)).click();
	}

	public void eventMenu() {

		wait.until(ExpectedConditions.elementToBeClickable(eventMenu)).click();
	}

	public void loginFromHomePage() {

		wait.until(ExpectedConditions.elementToBeClickable(loginFromHomePage)).click();
	}

	public void goToDirectory() {

		wait.until(ExpectedConditions.elementToBeClickable(goToDirectory)).click();
	}

	public void createEventBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(createEventBtn)).click();
	}

	public void searchVendor() {

		wait.until(ExpectedConditions.visibilityOf(searchVendor)).sendKeys("varak");
	}

	public void partnerWithUs() {
		
		wait.until(ExpectedConditions.elementToBeClickable(partnerWithUs)).click();
	}
	
	public void enterPartnerName() {

		js.executeScript("arguments[0].scrollIntoView(true);", partnerName);
		js.executeScript("window.scrollBy(0, 200);");
		WebElement nameInput = partnerName;
		String randomName = webActions.randomPartnerName();
		nameInput.sendKeys(randomName);
	}

	public void enterPartnerContactName() {

		WebElement nameInput = partnerContactName;
		String randomName = webActions.randomPartnerContactName();
		nameInput.sendKeys(randomName);

	}
	
	public void enterPartnerEmail() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", enterPartnerEmail);
		wait.until(ExpectedConditions.visibilityOf(enterPartnerEmail)).sendKeys("youcater1@mailinator.com");
	}	


	public void enterCuisine() {

		js.executeScript("arguments[0].scrollIntoView(true);", enterCuisine);
		WebElement nameInput = enterCuisine;
		String randomName = webActions.randomCuisines();
		nameInput.sendKeys(randomName);

	}
	
	public void acceptPrivacy() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", acceptPrivacy);
		js.executeScript("arguments[0].click();", acceptPrivacy);
	}
	
	public void submitRegisterationForm() {
		
		js.executeScript("arguments[0].scrollIntoView(true);", submitRegisterationForm);
		js.executeScript("arguments[0].click();", submitRegisterationForm);
	}
	
	public void clearSearch() {

		wait.until(ExpectedConditions.visibilityOf(searchVendor)).sendKeys(Keys.CONTROL , "a");
		wait.until(ExpectedConditions.visibilityOf(searchVendor)).sendKeys(Keys.BACK_SPACE);
	}

}

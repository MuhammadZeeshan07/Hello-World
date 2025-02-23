package org.youCater.userConfigurationsAndElements;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.youCater.utils.WebActions;

public class AddEventElements {

	private Actions actions;
	private WebActions webActions;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private String enteredDate;
	private String enteredNoOfGuests;
	private String enteredCustomFood;
	private String enteredEventName;
	private String enteredMaxBudget;
	private String enteredApartmentNo;
	private String enteredAdditionalNotes;
	private String enteredMobileNo;
	private String enteredName;
	private String enteredEmail;
	private Random random;

	// Locators
	@FindBy(xpath = "//a[@arialable=\"start planning\"]")
	private WebElement startPlanning;

	@FindBy(linkText = "My dashboard")
	private WebElement dashboard;

	@FindBy(id = "cancelAndBack")
	private WebElement crossCta;

	@FindBy(id = "eventRouteBack")
	private WebElement goToThePreviousPage;

	@FindBy(name = "startTime")
	private WebElement startTime;

	@FindBy(name = "endTime")
	private WebElement endTime;

	@FindBy(xpath = "//*[text()=\"Private event\"]")
	private WebElement selectPrivateEvent;

	@FindBy(xpath = "//*[text()=\"Corporate event\"]")
	private WebElement selectCorporateEvent;

	@FindBy(id = "eventRouteNext")
	private WebElement goToNextPage;

	@FindBy(id = "eventNameField")
	private WebElement enterEventName;

	@FindBy(name = "isFlexible")
	private WebElement isFlexibleCheckbox;

	@FindBy(xpath = "//*[contains(@class, 'eventCardFrame')]")
	private WebElement selectCard;

	@FindBy(xpath = "//*[@type=\"number\"]")
	private WebElement enterNoOfGuests;

	@FindBy(xpath = "//*[@id=\"Plus\"]")
	private WebElement incrementNoOfGuests;

	@FindBy(xpath = "//*[@class='rc-slider-handle rc-slider-handle-1']")
	private WebElement minSliderHandle;

	@FindBy(xpath = "//*[@class='rc-slider-handle rc-slider-handle-2']")
	private WebElement maxSliderHandle;

	@FindBy(id = "range-min")
	private WebElement minBudgetField;

	@FindBy(id = "range-max")
	private WebElement maxBudgetField;

	@FindBy(id = "mybudgetIsFlexible")
	private WebElement isBudgetFlexibleCheckbox;

	@FindBy(id = "eventCuisineTypes")
	private WebElement selectCuisineType;

	@FindBy(id = "eventFoodTypes")
	private WebElement selectFoodType;

	@FindBy(id = "add")
	private WebElement selectCustomFood;

	@FindBy(id = "eventType")
	private WebElement addCustomFood;

	@FindBy(xpath = "//*[@type=\"submit\"]")
	private WebElement saveCustomFood;

	@FindBy(name = "stillLookingForVenue")
	private WebElement lookingForVenueCheckbox;

	@FindBy(xpath = "//*[contains(@class, 'mapPinBtn')]")
	private WebElement clickMapPinBtn;

	@FindBy(name = "addressLine2")
	private WebElement enterApartmentNo;

	@FindBy(name = "additionalNotes")
	private WebElement enterAdditionalNotes;

	@FindBy(id = "phoneNumber")
	private WebElement enterPhoneNo;

	@FindBy(id = "sendOtpContinueBtn")
	private WebElement otpContinueBtn;

	@FindBy(id = "fullName")
	private WebElement enterFullName;

	@FindBy(id = "email")
	private WebElement enterEmail;

	@FindBy(xpath = "//*[text()=\"Continue\"]")
	private WebElement clickSignUpContinueBtn;

	@FindBy(xpath = "//*[text()=\"Back to home\"]")
	private WebElement goToHomePage;

	// Constructor
	public AddEventElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		webActions = new WebActions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		random = new Random();
	}

	// Actions

	public void youcaterLogo() throws InterruptedException {

		WebElement logo = dashboard;
		js.executeScript("arguments[0].scrollIntoView(true);", logo);
		Thread.sleep(2000);
		WebElement clickableLogo = wait.until(ExpectedConditions.elementToBeClickable(logo));
		js.executeScript("arguments[0].click();", clickableLogo);
	}

	public void startPlanning() {

		wait.until(ExpectedConditions.elementToBeClickable(startPlanning)).click();
	}

	public void crossCta() {

		wait.until(ExpectedConditions.elementToBeClickable(crossCta)).click();
	}

	public void selectPrivateEvent() {

		wait.until(ExpectedConditions.elementToBeClickable(selectPrivateEvent)).click();
	}

	public void selectCorporateEvent() {

		wait.until(ExpectedConditions.elementToBeClickable(selectCorporateEvent)).click();
	}

	public void goToThePreviousPage() {

		wait.until(ExpectedConditions.elementToBeClickable(goToThePreviousPage)).click();
	}

	public void goToNextPage() {

		wait.until(ExpectedConditions.elementToBeClickable(goToNextPage)).click();
	}

	public void enterValidTime() throws InterruptedException {

		Thread.sleep(1000);
		endTime.sendKeys(Keys.ARROW_LEFT);
		for (@SuppressWarnings("unused")
		int unused : new int[1]) {
			endTime.sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
	}

	public void enterTimeGreaterThan8Hr() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(startTime)).click();
		startTime.sendKeys(Keys.ENTER);
		startTime.sendKeys(Keys.ARROW_LEFT);
		startTime.sendKeys(Keys.ARROW_LEFT);
		startTime.sendKeys("05");
		startTime.sendKeys("15");
		startTime.sendKeys("PM");
		Thread.sleep(1000);
		startTime.sendKeys(Keys.TAB);
		endTime.sendKeys(Keys.ENTER);
		endTime.sendKeys("01");
		endTime.sendKeys("16");
		endTime.sendKeys("AM");
		Thread.sleep(1000);

	}

	public void enterEventName() throws InterruptedException {

		WebElement eventNameElement = enterEventName;
		String randomEventName = webActions.eventNames();
		eventNameElement.sendKeys(randomEventName);
		enteredEventName = randomEventName;

	}

	public String getEnteredEventName() {

		return enteredEventName;

	}

	public void enterDate() {

		WebElement date = (WebElement) js.executeScript("return document.querySelector('*[id=\"eventStartDate\"]');");
	//	String randomDate = webActions.randomDate();
		date.sendKeys(Keys.ENTER);
	//	enteredDate = randomDate;
	}

	public void enterDateManualy() {

		WebElement date = (WebElement) js.executeScript("return document.querySelector('*[id=\"eventStartDate\"]');");
		date.click();
		int numberOfPresses = random.nextInt(5) + 1;
		for (int i = 0; i < numberOfPresses; i++) {
			date.sendKeys(Keys.ARROW_RIGHT);
		}
		date.sendKeys(Keys.ENTER);
	}

	public String getEnteredDate() {
		return enteredDate;
	}

	public void isFlexibleCheckbox() {

		wait.until(ExpectedConditions.elementToBeClickable(isFlexibleCheckbox)).click();
		isFlexibleCheckbox.isSelected();
	}

	public List<WebElement> selectCard() {

		WebElement parentElement = selectCard;
		List<WebElement> cardsList = parentElement.findElements(By.tagName("label"));
		return cardsList;
	}

	public void enterNoOfGuests() {

		WebElement noOfGuestsInput = enterNoOfGuests;
		String randomNoOfGuests = webActions.generateRandomValue(20, 300);
		noOfGuestsInput.clear();
		noOfGuestsInput.sendKeys(randomNoOfGuests);
		enteredNoOfGuests = randomNoOfGuests;
	}

	public String getEnteredNoOfGuests() {
		return enteredNoOfGuests;
	}

	public void incrementNoOfGuests() {

		wait.until(ExpectedConditions.elementToBeClickable(incrementNoOfGuests)).click();
	}

	public void enterBudgeBySlider() {

		actions.dragAndDropBy(minSliderHandle, 100, 0).perform();
		actions.dragAndDropBy(maxSliderHandle, -50, 0).perform();

	}

	public void enterBudgeByInputFields() throws InterruptedException {

		WebElement minBudget = wait.until(ExpectedConditions.elementToBeClickable(minBudgetField));
		minBudget.click();
		minBudget.sendKeys(Keys.CONTROL + "a");
		minBudget.sendKeys(Keys.DELETE);
		minBudget.sendKeys(webActions.generateRandomValue(500, 600));
		Thread.sleep(2000);

		WebElement maxBudget = wait.until(ExpectedConditions.elementToBeClickable(maxBudgetField));
		String maxValue = webActions.generateRandomValue(600, 999);
		maxBudget.click();
		maxBudget.sendKeys(Keys.CONTROL + "a");
		maxBudget.sendKeys(Keys.DELETE);
		maxBudget.sendKeys(maxValue);
		enteredMaxBudget = maxValue;

	}

	public String getEnteredMaxBudget() {

		return enteredMaxBudget;
	}

	public void isBudgetFlexibleCheckbox() {

		WebElement isBudgetFlexible = isBudgetFlexibleCheckbox;
		js.executeScript("arguments[0].scrollIntoView(true);", isBudgetFlexible);
		isBudgetFlexible.click();
		isBudgetFlexible.isSelected();
	}

	public List<WebElement> selectCuisineType() {

		WebElement parentElement = selectCuisineType;
		List<WebElement> cuisineTypes = parentElement.findElements(By.tagName("button"));
		return cuisineTypes;
	}

	public List<WebElement> selectFoodType() {

		WebElement parentElement = selectFoodType;
		List<WebElement> foodTypes = parentElement.findElements(By.tagName("button"));
		return foodTypes;
	}

	public void selectCustomFood() {

		WebElement customFood = selectCustomFood;
		js.executeScript("arguments[0].scrollIntoView(true);", customFood);
		customFood.click();
	}

	public void addCustomFood() {

		WebElement addCustomFoodInput = addCustomFood;
		String customFoodValue = "Custom";
		addCustomFoodInput.sendKeys(customFoodValue);
		enteredCustomFood = customFoodValue;
	}

	public String getEnteredCustomFood() {
		return enteredCustomFood;
	}

	public void saveCustomFood() {

		wait.until(ExpectedConditions.elementToBeClickable(saveCustomFood)).click();
	}

	public void lookingForVenueCheckbox() {

		wait.until(ExpectedConditions.elementToBeClickable(lookingForVenueCheckbox)).click();
		lookingForVenueCheckbox.isSelected();
	}

	public void clickMapPinBtn() {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clickMapPinBtn));
		actions.click(element).build().perform();
	}

	public void enterApartmentNo() {

		WebElement apartmentInput = enterApartmentNo;
		String apartment = "4059 Carling Avenue, 1st floor";
		apartmentInput.sendKeys(apartment);
		enteredApartmentNo = apartment;

	}

	public String getEnteredApartmentNo() {
		return enteredApartmentNo;
	}

	public void enterAdditionalNotes() {

		WebElement additionalInput = enterAdditionalNotes;
		String additionalNotes = "Khobar North, P.O.Box: 30946";
		additionalInput.sendKeys(additionalNotes);
		enteredAdditionalNotes = additionalNotes;
	}

	public String getEnteredAdditionalNotes() {
		return enteredAdditionalNotes;
	}

	public void enterPhoneNo(String phoneNumber) {

		WebElement mobileInput = enterPhoneNo;
		mobileInput.sendKeys(phoneNumber);
		enteredMobileNo = phoneNumber;
	}

	public String getEnteredMobileNo() {
		return enteredMobileNo;
	}

	public void otpContinueBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(otpContinueBtn)).click();
	}

	public void enterFullName() {

		WebElement nameInput = enterFullName;
		String randomName = webActions.randomName();
		nameInput.clear();
		nameInput.sendKeys(randomName);
		enteredName = randomName;
	}

	public String getEnteredName() {
		return enteredName;
	}

	public void enterEmail() {

		WebElement email = enterEmail;
		email.clear();
		// email.sendKeys("youcater1@mailinator.com");

		String randomEmail = webActions.randomEmail();
		email.sendKeys(randomEmail);
		enteredEmail = randomEmail;

	}

	public String getEnteredEmail() {

		return enteredEmail;

	}

	public void clickSignUpContinueBtn() {

		js.executeScript("arguments[0].scrollIntoView(true);", clickSignUpContinueBtn);
		wait.until(ExpectedConditions.elementToBeClickable(clickSignUpContinueBtn)).click();
	}
	
	

	public void goToHomePage() {

		wait.until(ExpectedConditions.elementToBeClickable(goToHomePage)).click();
	}

}

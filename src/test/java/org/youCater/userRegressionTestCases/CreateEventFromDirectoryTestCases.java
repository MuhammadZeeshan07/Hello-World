package org.youCater.userRegressionTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.HomePageElements;
import org.youCater.utils.AddEventCommonActions;
import org.youCater.utils.WebActions;

public class CreateEventFromDirectoryTestCases extends Configurations {

	private HomePageElements homePageElements;
	private AddEventCommonActions addEventCommonActions;
	private AddEventElements addEventElements;
	private EditEventSummaryTestCases editEventSummaryTestCases;
	private SoftAssert softAssert;

	public CreateEventFromDirectoryTestCases() {

		homePageElements = new HomePageElements(driver);
		addEventCommonActions = new AddEventCommonActions(driver);
		addEventElements = new AddEventElements(driver);
		editEventSummaryTestCases = new EditEventSummaryTestCases(driver);
		softAssert = new SoftAssert();

	}

	@Test(description = "HomePage: Verify user logged in successfully from the homepage")
	public void loginFromHomePage() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.loginFromHomePage();
		Thread.sleep(1000);
		addEventCommonActions.signInViaEmailPassword();
		/*
		 * addEventCommonActions.verifyOTP(); addEventCommonActions.signUp();
		 */

	}

	@Test(priority = 1, description = "PrivateEvent: Verify selection of event type funtionality")
	public void goToEventDirectory() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.goToDirectory();
		Thread.sleep(2000);
		WebElement createEventButton = driver.findElement(By.xpath("//a[@arialable=\"Create event\"]"));
		softAssert.assertTrue(createEventButton.isDisplayed());
		softAssert.assertAll();
		homePageElements.createEventBtn();
		Thread.sleep(2000);
	}

	@Test(priority = 2, description = "PrivateEvent: Verify selection of event type funtionality")
	public void eventTypeSelection() throws InterruptedException {

		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		homePageElements.createEventBtn();
		Thread.sleep(2000);
		addEventElements.crossCta();
		Thread.sleep(2000);
		homePageElements.goToDirectory();
		Thread.sleep(2000);
		homePageElements.createEventBtn();
		Thread.sleep(2000);
		addEventCommonActions.verifyButtonIsDisabled();
		addEventElements.selectPrivateEvent();

	}

	@Test(priority = 3, description = "PrivateEvent: Verify selection of occasion type functionality")
	public void occasionTypeSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventCommonActions.verifyButtonIsDisabled();
		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectOccasion = cardsList.get(randomIndex);
			selectOccasion.click();

		}

		Thread.sleep(2000);

	}

	@Test(priority = 4, description = "PrivateEvent: Verify date and time selection functionality")
	public void dateAndTimeSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.enterDateManualy();
		Thread.sleep(1000);
		addEventElements.isFlexibleCheckbox();
		Thread.sleep(1000);
		addEventElements.enterTimeGreaterThan8Hr();
		Thread.sleep(1000);
		WebElement validationAlert = driver.findElement(By.xpath("//span[contains(@class,'text-alert')]"));
		softAssert.assertTrue(validationAlert.isDisplayed());
		Thread.sleep(1000);
		addEventCommonActions.verifyButtonIsDisabled();
		addEventElements.enterValidTime();
		Thread.sleep(1000);
		addEventCommonActions.verifyButtonIsEnabled();
		addEventElements.goToNextPage();

	}

	@Test(priority = 5, description = "PrivateEvent: Verify guest number entry functionality")
	public void guestSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.enterNoOfGuests();
		Thread.sleep(1000);
		addEventElements.incrementNoOfGuests();
		Thread.sleep(2000);
		addEventElements.goToNextPage();

	}

	@Test(priority = 6, description = "PrivateEvent: Verify provider selection functionality")
	public void providerSelection() throws InterruptedException {
		Thread.sleep(2000);
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectProvider = cardsList.get(randomIndex);
			selectProvider.click();

		}

	}

	@Test(priority = 7, description = "PrivateEvent: Verify cuisine type selection functionality")
	public void cuisineTypeSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		List<WebElement> cuisineTypes = addEventElements.selectCuisineType();
		int randomIndex = WebActions.getRandomIndex(cuisineTypes);

		if (randomIndex != -1) {
			WebElement selectCuisine = cuisineTypes.get(randomIndex);
			selectCuisine.click();

		}
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
	}

	@Test(priority = 8, description = "PrivateEvent: Verify event venue selection functionality")
	public void eventVenueSelection() throws InterruptedException {

		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		WebElement selectCity = driver.findElement(By.name("city"));
		Select select = new Select(selectCity);
		select.selectByIndex(4);
		Thread.sleep(2000);

		driver.findElement(By.id("address")).sendKeys("Test");
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class=\"pac-container pac-logo\"]/div"));
		int randomIndex = WebActions.getRandomIndex(searchResults);

		if (randomIndex != -1) {
			searchResults.get(randomIndex).click();
		}
		Thread.sleep(2000);
		addEventElements.enterApartmentNo();
		Thread.sleep(2000);
		addEventElements.enterAdditionalNotes();
		Thread.sleep(2000);
		addEventElements.lookingForVenueCheckbox();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 9, description = "PrivateEvent: Verify addition of event name functionality")
	public void addEventName() throws InterruptedException {

		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.enterEventName();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 10, description = "PrivateEvent: Verify budget selection functionality")
	public void budgetSelection() throws InterruptedException {
		
		addEventElements.goToThePreviousPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.enterBudgeBySlider();
		Thread.sleep(2000);
		addEventElements.enterBudgeByInputFields();
		Thread.sleep(2000);
		// addEventCommonActions.verifyCalculatedBudget();
		addEventElements.isBudgetFlexibleCheckbox();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 11, description = "PrivateEvent: Verify generation of event summary")
	public void eventSummary() throws InterruptedException {

		editEventSummaryTestCases.editEventType();
		editEventSummaryTestCases.editEventName();
		editEventSummaryTestCases.editEventDate();
		editEventSummaryTestCases.editNoOfGuests();
		editEventSummaryTestCases.editBudget();
		editEventSummaryTestCases.editProvider();
		editEventSummaryTestCases.editFoodType();
		editEventSummaryTestCases.editEventVenue();
		editEventSummaryTestCases.editPersonalDetails();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 12, description = "PrivateEvent: Verify navigation to the home page")
	public void goToHomePage() throws InterruptedException {

		addEventElements.goToHomePage();
		Thread.sleep(2000);
	}

}

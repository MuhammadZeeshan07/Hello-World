package org.youCater.userSanityTestCases;

import java.sql.SQLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.youCater.DatabaseConnectivity.DatabaseConnection;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.AddEventCommonActions;
import org.youCater.utils.WebActions;

public class AddPrivateEventTestCases extends Configurations {

	private AddEventElements addEventElements;
	private AddEventCommonActions addEventCommonActions;
	private SoftAssert softAssert;
	public static String selectedOccasionCard = null;
	public static String standardEnteredDate = null;
	public static String enteredGuests = null;
	public static String selectedProviderCard = null;
	public static String selectedCuisine = null;
	public static String enteredCustomFood = null;
	public static String enteredEventName = null;
	public static String enteredMaxBudget = null;
	public static String selectedCity = null;
	public static String selectedSearchAddress = null;
	public static String enteredApartmentNo = null;
	public static String enteredAdditionalNotes = null;
	public AddPrivateEventTestCases() {

		addEventElements = new AddEventElements(driver);
		addEventCommonActions = new AddEventCommonActions(driver);
		softAssert = new SoftAssert();
		new EventSummaryDataValidationTestCases();

	}

	@Test(description = "PrivateEvent: Verify selection of event type funtionality")
	public void privateEventTypeSelection() throws InterruptedException {

		addEventElements.startPlanning();
		Thread.sleep(2000);
		addEventElements.selectPrivateEvent();

	}

	@Test(priority = 1, description = "PrivateEvent: Verify selection of occasion type functionality")
	public void prviateOccasionTypeSelection() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectOccasion = cardsList.get(randomIndex);
			selectedOccasionCard = selectOccasion.getText();
			selectOccasion.click();

		}

		Thread.sleep(4000);

	}

	@Test(priority = 2, description = "PrivateEvent: Verify date and time selection functionality")
	public void privateDateAndTimeSelection() throws InterruptedException {

		addEventCommonActions.verifyButtonIsDisabled();
		Thread.sleep(2000);

		String expectedTitle = "Do you have a date in mind?";
		String expectedDescription = "No date yet? Just hint a timeframe, amending your booking is easy!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		addEventElements.enterDate();
		Thread.sleep(2000);
		String enteredDate = addEventElements.getEnteredDate();
		standardEnteredDate = WebActions.convertDateToStandardFormat(enteredDate);
		addEventElements.isFlexibleCheckbox();
		Thread.sleep(2000);

		addEventElements.goToNextPage();

	}

	@Test(priority = 3, description = "PrivateEvent: Verify guest number entry functionality")
	public void privateGuestSelection() throws InterruptedException {

		Thread.sleep(3000);

		String expectedTitle = "How many guests are you expecting?";
		String expectedDescription = "If you're unsure of the exact details, simply provide us with your best guess!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		Thread.sleep(2000);
		addEventElements.enterNoOfGuests();
		Thread.sleep(2000);
		enteredGuests = addEventElements.getEnteredNoOfGuests();
		addEventElements.goToNextPage();

	}

	@Test(priority = 4, description = "PrivateEvent: Verify provider selection functionality")
	public void privateProviderSelection() throws InterruptedException {
		Thread.sleep(2000);
		addEventCommonActions.verifyButtonIsDisabled();
		Thread.sleep(2000);

		String expectedTitle = "What type of provider would you like?";
		String expectedDescription = "Catering to all needs, our partners provide a versatile offering.";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectProvider = cardsList.get(randomIndex);
			selectedProviderCard = selectProvider.getText();
			selectProvider.click();

		}

	}

	@Test(priority = 5, description = "PrivateEvent: Verify cuisine type selection functionality")
	public void privateCuisineTypeSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventCommonActions.verifyButtonIsDisabled();
		Thread.sleep(2000);

		String expectedTitle = "Share your cravings!";
		String expectedDescription = "We'll match you with the ideal culinary expert. Choose as many options as you wish!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		Thread.sleep(2000);
		List<WebElement> cuisineTypes = addEventElements.selectCuisineType();
		int randomIndex = WebActions.getRandomIndex(cuisineTypes);

		if (randomIndex != -1) {
			WebElement selectCuisine = cuisineTypes.get(randomIndex);
			selectedCuisine = selectCuisine.getText();
			selectCuisine.click();

		}
		Thread.sleep(2000);
	}

	@Test(priority = 6, description = "PrivateEvent: Verify food type selection functionality")
	public void privateFoodTypeSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.selectCustomFood();
		Thread.sleep(2000);
		addEventElements.addCustomFood();
		Thread.sleep(2000);
		enteredCustomFood = addEventElements.getEnteredCustomFood();
		addEventElements.saveCustomFood();
		Thread.sleep(2000);
		addEventElements.goToNextPage();

	}

	@Test(priority = 7, description = "PrivateEvent: Verify event venue selection functionality")
	public void privateEventVenueSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventCommonActions.verifyButtonIsDisabled();
		Thread.sleep(2000);

		String expectedTitle = "Event venue";
		String expectedDescription = "Share your event’s location & we'll pair you with the best local suppliers nearby!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		Thread.sleep(2000);
		WebElement selectCity = driver.findElement(By.name("city"));
		Select select = new Select(selectCity);
		select.selectByIndex(4);
		Thread.sleep(2000);
		selectedCity = select.getFirstSelectedOption().getText();

		driver.findElement(By.id("address")).sendKeys("Test");
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class=\"pac-container pac-logo\"]/div"));
		int randomIndex = WebActions.getRandomIndex(searchResults);

		if (randomIndex != -1) {

			WebElement selectedResult = searchResults.get(randomIndex);
			selectedSearchAddress = selectedResult.getText();
			selectedResult.click();
		}
		Thread.sleep(2000);
		addEventElements.enterApartmentNo();
		Thread.sleep(2000);
		enteredApartmentNo = addEventElements.getEnteredApartmentNo();
		addEventElements.enterAdditionalNotes();
		Thread.sleep(2000);
		enteredAdditionalNotes = addEventElements.getEnteredAdditionalNotes();
		addEventElements.lookingForVenueCheckbox();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 8, description = "PrivateEvent: Verify addition of event name functionality")
	public void privateAddEventName() throws InterruptedException {

		addEventCommonActions.verifyButtonIsDisabled();
		Thread.sleep(2000);

		String expectedTitle = "What is the name of the event?";
		String expectedDescription = "This will help identify your event for yourself and the caterer.";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		Thread.sleep(2000);
		addEventElements.enterEventName();
		Thread.sleep(2000);
		enteredEventName = addEventElements.getEnteredEventName();
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 9, description = "PrivateEvent: Verify budget selection functionality")
	public void privateBudgetSelection() throws InterruptedException {

		Thread.sleep(2000);

		String expectedTitle = "Got a budget in mind?";
		String expectedDescription = "We need the big picture. If you're playing a guessing game, just give us your best estimate!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		Thread.sleep(2000);
		addEventElements.enterBudgeBySlider();
		Thread.sleep(2000);
		addEventElements.enterBudgeByInputFields();
		Thread.sleep(2000);
		enteredMaxBudget = addEventElements.getEnteredMaxBudget();
		addEventElements.isBudgetFlexibleCheckbox();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 10, description = "PrivateEvent: Verify signIn functionality")
	public void privateSignIn() throws InterruptedException {

		String expectedTitle = "Welcome";
		String expectedDescription = "Enter your email and password to continue";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();
		
		addEventCommonActions.signInViaEmailPassword();
	}
	

	@Test(priority = 11, description = "PrivateEvent: Verify generation of event summary")
	public void privateEventSummary() throws InterruptedException, ClassNotFoundException, SQLException {

		driver.findElement(By.xpath("//*[@id=\"eventTypeSummarySection\"]//*[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();

		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement changeItem = cardsList.get(randomIndex);
			changeItem.click();

		}
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		System.out.println("Private Event Created");
		DatabaseConnection.getEventDetailsInDatabase();
	}

	@Test(priority = 12, description = "PrivateEvent: Verify navigation to the home page")
	public void privateGoToHomePage() throws InterruptedException {

		Thread.sleep(2000);
		String expectedTitle = "Thank you!";
		String expectedDescription = "We've got your requirements. Look no further, we'll be reaching out soon!";
		addEventCommonActions.assertTextEquals(driver, "//h1[1]", expectedTitle, softAssert);
		addEventCommonActions.assertTextEquals(driver, "//h1[1]/following-sibling::p[1]", expectedDescription,
				softAssert);
		softAssert.assertAll();

		addEventElements.goToHomePage();
		Thread.sleep(2000);
	}

}

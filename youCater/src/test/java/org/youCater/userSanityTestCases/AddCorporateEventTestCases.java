package org.youCater.userSanityTestCases;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.youCater.DatabaseConnectivity.DatabaseConnection;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.AddEventCommonActions;
import org.youCater.utils.WebActions;

public class AddCorporateEventTestCases extends Configurations {

	private AddEventElements addEventElements;
	private AddEventCommonActions addEventCommonActions;

	public AddCorporateEventTestCases() {
		
		addEventElements = new AddEventElements(driver);
		setAddEventCommonActions(new AddEventCommonActions(driver));
	}

	@Test(description = "CorporateEvent: Verify selection of event type funtionality")
	public void corporateEventTypeSelection() throws InterruptedException {
		/*
		 * addEventCommonActions.signIn(); addEventCommonActions.verifyOTP();
		 */
			
				driver.findElement(By.xpath("//*[contains(@class,'btnAddEvent')]")).click();
				Thread.sleep(2000);
				addEventElements.selectCorporateEvent();
		
	}

	@Test(priority = 1, description = "CorporateEvent: Verify selection of occasion type functionality")
	public void corporateOccasionTypeSelection() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectOccasion = cardsList.get(randomIndex);
			selectOccasion.click();

		}

		Thread.sleep(4000);

	}

	@Test(priority = 2, description = "CorporateEvent: Verify date and time selection functionality")
	public void corporateDateAndTimeSelection() throws InterruptedException {
		
		Thread.sleep(2000);
		addEventElements.enterDate();
		Thread.sleep(2000);
		addEventElements.isFlexibleCheckbox();
		Thread.sleep(2000);

		addEventElements.goToNextPage();

	}

	@Test(priority = 3, description = "CorporateEvent: Verify guest number entry functionality")
	public void corporateGuestSelection() throws InterruptedException {

		addEventElements.enterNoOfGuests();
		Thread.sleep(2000);
		addEventElements.incrementNoOfGuests();
		Thread.sleep(2000);
		addEventElements.goToNextPage();

	}

	@Test(priority = 4, description = "CorporateEvent: Verify provider selection functionality")
	public void corporateProviderSelection() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();
		int randomIndex = WebActions.getRandomIndex(cardsList);

		if (randomIndex != -1) {
			WebElement selectProvider = cardsList.get(randomIndex);
			selectProvider.click();

		}
		Thread.sleep(2000);

	}

	@Test(priority = 5, description = "CorporateEvent: Verify cuisine type selection functionality")
	public void corporateCuisineTypeSelection() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> cuisineTypes = addEventElements.selectCuisineType();
		int randomIndex = WebActions.getRandomIndex(cuisineTypes);

		if (randomIndex != -1) {
			WebElement selectCuisine = cuisineTypes.get(randomIndex);
			selectCuisine.click();

		}
		Thread.sleep(2000);
	}

	@Test(priority = 6, description = "CorporateEvent: Verify food type selection functionality")
	public void corporateFoodTypeSelection() throws InterruptedException {

		/*
		 * List<WebElement> foodTypes = addEventElements.selectFoodType();
		 * 
		 * if (!foodTypes.isEmpty()) { WebElement selectFood = foodTypes.get(2);
		 * selectFood.click();
		 * 
		 * }
		 */
		Thread.sleep(2000);
		addEventElements.selectCustomFood();
		Thread.sleep(2000);
		addEventElements.addCustomFood();
		Thread.sleep(2000);
		addEventElements.saveCustomFood();
		Thread.sleep(2000);
		addEventElements.goToNextPage();

	}

	@Test(priority = 7, description = "CorporateEvent: Verify event venue selection functionality")
	public void corporateEventVenueSelection() throws InterruptedException {
		Thread.sleep(2000);
		WebElement selectCity = driver.findElement(By.name("city"));
		Select select = new Select(selectCity);
		select.selectByIndex(1);
		Thread.sleep(2000);
		addEventElements.clickMapPinBtn();
		Thread.sleep(2000);
		driver.findElement(By.id("confirmAddress")).sendKeys("Test");
		Thread.sleep(2000);
		List<WebElement> searchResults = driver.findElements(By.xpath("//*[@class=\"searchAddressData\"]//li"));
		int randomIndex = WebActions.getRandomIndex(searchResults);

		if (randomIndex != -1) {
			searchResults.get(randomIndex).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=\"Save\"]")).click();
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

	@Test(priority = 8, description = "CorporateEvent: Verify addition of event name functionality")
	public void privateAddEventName() throws InterruptedException {
		Thread.sleep(2000);
		addEventElements.enterEventName();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 9, description = "CorporateEvent: Verify budget selection functionality")
	public void corporateBudgetSelection() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.enterBudgeBySlider();
		Thread.sleep(2000);
		addEventElements.enterBudgeByInputFields();
		Thread.sleep(2000);
		addEventElements.isBudgetFlexibleCheckbox();
		Thread.sleep(2000);
		// addEventCommonActions.verifyCalculatedBudget();
		addEventElements.goToNextPage();
		Thread.sleep(2000);

	}

	@Test(priority = 10, description = "CorporateEvent: Verify generation of event summary")
	public void corporateEventSummary() throws InterruptedException, ClassNotFoundException, SQLException {

		driver.findElement(By.xpath("//*[@id=\"eventNameSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		WebElement editEventName = driver.findElement(By.id("eventNameField"));
		editEventName.clear();
		addEventElements.enterEventName();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		addEventElements.goToNextPage();
		Thread.sleep(2000);
		System.out.println("Corporate Event Created");
		DatabaseConnection.getEventDetailsInDatabase();

	}

	@Test(priority = 11, description = "CorporateEvent: Verify navigation to the home page")
	public void corporateGoToHomePage() throws InterruptedException {
		addEventElements.goToHomePage();
		Thread.sleep(2000);
	}

	public AddEventCommonActions getAddEventCommonActions() {
		return addEventCommonActions;
	}

	public void setAddEventCommonActions(AddEventCommonActions addEventCommonActions) {
		this.addEventCommonActions = addEventCommonActions;
	}

}

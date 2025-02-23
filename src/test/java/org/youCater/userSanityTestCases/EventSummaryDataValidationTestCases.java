package org.youCater.userSanityTestCases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.AddEventCommonActions;

public class EventSummaryDataValidationTestCases extends Configurations {

	private SoftAssert softAssert;

	public EventSummaryDataValidationTestCases() {

		softAssert = new SoftAssert();

	}

	public void validateOccasion() {

		WebElement occassionOnSummary = driver.findElement(By.xpath(
				"//*[@id='eventTypeSummarySection']//*[contains(@class,'text flex-1 flex items-center gap-2')]"));
		String actual = occassionOnSummary.getText();
		String expected = AddPrivateEventTestCases.selectedOccasionCard;
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	public void validateEventName() {

		WebElement eventNameOnSummary = driver
				.findElement(By.xpath("//*[@id='eventNameSummarySection']//*[contains(@class,'m-0')]"));
		String actual = eventNameOnSummary.getText();
		String expected = AddPrivateEventTestCases.enteredEventName;
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	public void validateDate() {

		WebElement eventDateOnSummary = driver.findElement(
				By.xpath("//*[@id='eventDateSummarySection']//*[contains(@class,'flex items-center gap-3')]"));
		String actual = eventDateOnSummary.getText();
		String expected = AddPrivateEventTestCases.standardEnteredDate;
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	public void validateGuests() {

		WebElement guestsOnSummary = driver.findElement(
				By.xpath("//*[@id='guestCountSummarySection']//*[contains(@class,'flex items-center gap-2')]"));
		String actual = guestsOnSummary.getText();
		String expected = AddPrivateEventTestCases.enteredGuests;
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	public void validateBudget() {

		WebElement budgetOnSummary = driver.findElement(
				By.xpath("//*[@id='budgetSummarySection']//*[contains(@class,'flex items-center gap-2')]"));
		String actual = budgetOnSummary.getText();

		Pattern pattern = Pattern.compile("\\b(\\d+)\\b");

		Matcher matcher = pattern.matcher(actual);

		if (matcher.find()) {
			String numericValue = matcher.group(1);
			int actualBudget = Integer.parseInt(numericValue);
			String expectedBudget = AddPrivateEventTestCases.enteredMaxBudget;
			softAssert.assertEquals(actualBudget, Integer.parseInt(expectedBudget));
			softAssert.assertAll();
		}

	}

	public void validateProvider() {

		WebElement providerOnSummary = driver.findElement(
				By.xpath("//*[@id='providerSummarySection']//*[contains(@class,'flex items-center gap-2')]"));
		String actual = providerOnSummary.getText();
		String expected = AddPrivateEventTestCases.selectedProviderCard;
		softAssert.assertEquals(actual, expected);
		softAssert.assertAll();

	}

	public void validateFoodType() {

		WebElement foodOnSummary = driver
				.findElement(By.xpath("//*[@id='foodSummarySection']//*[contains(@class,'text flex-1')]"));
		String actual = foodOnSummary.getText();
		String expected = AddPrivateEventTestCases.selectedCuisine;
		softAssert.assertTrue(actual.contains(expected));

		WebElement customFoodOnSummary = driver
				.findElement(By.xpath("//*[@id='foodSummarySection']//*[contains(@class,'text flex-1')]"));
		String actualCustom = customFoodOnSummary.getText();
		String expectedCustom = AddPrivateEventTestCases.enteredCustomFood;
		softAssert.assertTrue(actualCustom.contains(expectedCustom));
		softAssert.assertAll();

	}

	public void validateEventVenue() {

		WebElement cityOnSummary = driver.findElement(By.xpath(
				"//*[@id='venueSummarySection']//*[text()='City']/following-sibling::p[contains(@class,'m-0')]"));
		String actualCity = cityOnSummary.getText();
		String expectedCity = AddPrivateEventTestCases.selectedCity;
		softAssert.assertEquals(actualCity, expectedCity);

		WebElement apartmentOnSummary = driver.findElement(By.xpath(
				"//*[@id='venueSummarySection']//*[text()='Address']/following-sibling::p[contains(@class,'m-0')]"));
		String actual = apartmentOnSummary.getText();
		String[] apartment = actual.split("\n");
		int apartmentIndex = 1;
		String actualApartment = apartment[apartmentIndex].trim();
		String expectedApartment = AddPrivateEventTestCases.enteredApartmentNo;
		softAssert.assertEquals(actualApartment, expectedApartment);

		WebElement additionalNotesOnSummary = driver.findElement(By.xpath(
				"//*[@id='venueSummarySection']//*[text()='Address']/following-sibling::p[contains(@class,'m-0')]"));
		String actualNote = additionalNotesOnSummary.getText();
		String[] additionalNotes = actualNote.split("\n");
		int additionalNotesIndex = 2;
		String actualNotes = additionalNotes[additionalNotesIndex].trim();
		String expectedNotes = AddPrivateEventTestCases.enteredAdditionalNotes;
		softAssert.assertEquals(actualNotes, expectedNotes);
		softAssert.assertAll();

	}

	public void validatePersonalDetails() {

		WebElement nameOnSummary = driver.findElement(By.xpath(
				"//*[@id='userDetailsSummarySection']//span[@id=\"name\"]//following-sibling::p[contains(@class,'m-0')]"));
		String actual = nameOnSummary.getText();
		String expected = AddEventCommonActions.enteredFullName;
		softAssert.assertEquals(actual, expected);

		WebElement emailOnSummary = driver.findElement(By.xpath(
				"//*[@id='userDetailsSummarySection']//span[@id=\"email\"]//following-sibling::p[contains(@class,'m-0')]"));
		String actualEmail = emailOnSummary.getText();
		String expectedEmail = AddEventCommonActions.enteredEmail;
		softAssert.assertEquals(actualEmail, expectedEmail);

		WebElement phoneOnSummary = driver.findElement(By.xpath(
				"//*[@id='userDetailsSummarySection']//span[@id='phoneNumber']//following-sibling::p[contains(@class,'m-0')]"));
		String actualNumber = phoneOnSummary.getText();
		String expectedNumber = AddEventCommonActions.enteredMobileNo;
		if (actualNumber != null && expectedNumber != null) {
	        softAssert.assertTrue(actualNumber.contains(expectedNumber));
	    }

		softAssert.assertAll();
	}

}

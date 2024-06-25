package org.youCater.userRegressionTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.ProfilePageElements;

public class EditEventSummaryTestCases {

	private WebDriver driver;
	private AddEventElements addEventElements;
	private ProfilePageElements profilePageElements;
	private JavascriptExecutor js;

	public EditEventSummaryTestCases(WebDriver driver) {

		this.driver = driver;
		addEventElements = new AddEventElements(driver);
		profilePageElements =  new ProfilePageElements(driver);
		js =  (JavascriptExecutor) driver;
	}

	public void editEventType() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"eventTypeSummarySection\"]//*[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();

		if (!cardsList.isEmpty()) {
			WebElement changeItem = cardsList.get(2);
			changeItem.click();

		}
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);
	}

	public void editEventName() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"eventNameSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		WebElement editEventName = driver.findElement(By.id("eventNameField"));
		editEventName.clear();
		addEventElements.enterEventName();
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);
	}

	public void editEventDate() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"eventDateSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		WebElement date = (WebElement) js
				.executeScript("return document.querySelector('*[id=\"eventStartDate\"]');");
		date.click();
		date.sendKeys(Keys.ARROW_RIGHT);
		date.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);
	}

	public void editNoOfGuests() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"guestCountSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		addEventElements.enterNoOfGuests();
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);

	}

	public void editBudget() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"budgetSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		addEventElements.enterBudgeByInputFields();
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);

	}

	public void editProvider() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"providerSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		List<WebElement> cardsList = addEventElements.selectCard();

		if (!cardsList.isEmpty()) {
			WebElement selectProvider = cardsList.get(3);
			selectProvider.click();

		}
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);
	}

	public void editFoodType() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"foodSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		List<WebElement> cuisineTypes = addEventElements.selectCuisineType();

		if (!cuisineTypes.isEmpty()) {
			WebElement selectCuisine = cuisineTypes.get(3);
			selectCuisine.click();

		}
		Thread.sleep(5000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);

	}

	public void editEventVenue() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"venueSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(3000);
		WebElement selectCity = driver.findElement(By.name("city"));
		Select select = new Select(selectCity);
		select.selectByIndex(1);
		Thread.sleep(3000);
		addEventElements.goToNextPage();
		Thread.sleep(3000);
	}
	
	public void editPersonalDetails() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"userDetailsSummarySection\"]//button[@id=\"editBtn\"]")).click();
		Thread.sleep(2000);
		addEventElements.enterFullName();
		Thread.sleep(2000);
		addEventElements.enterEmail();
		Thread.sleep(2000);
		profilePageElements.updateProfile();
		Thread.sleep(2000);
	}

}

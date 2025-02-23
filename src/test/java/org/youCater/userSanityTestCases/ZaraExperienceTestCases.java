package org.youCater.userSanityTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.utils.WebActions;

public class ZaraExperienceTestCases extends Configurations {

	private WebDriverWait wait;
	private JavascriptExecutor js;
	private AddEventElements addEventElements;
	public static String standardEnteredDate = null;

	public ZaraExperienceTestCases() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
		addEventElements = new AddEventElements(driver);
	}

	@Test(description = "Initiate Zara Experience: Verify start planning functionality")
	public void startPlanning() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-labelledby=\"Start planning\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@automation-id=\"find-experience\"]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 1, description = "PrivateEvent: Verify selection of event type funtionality")
	public void privateEventTypeSelection() throws InterruptedException {

		WebElement selectEvent = driver.findElement(By.xpath("//*[@automation-id=\"private-event\"]"));
		WebElement event = wait.until(ExpectedConditions.elementToBeClickable(selectEvent));
		event.click();
		Thread.sleep(2000);

	}

	@Test(priority = 2, description = "SendBidRequest: Verify partner details (About, Menu, Media)")
	public void prviateOccasionTypeSelection() throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//*[@automation-id='casual-gathering']"));

		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		Thread.sleep(1000);
		element.click();
		Thread.sleep(2000);

	}

	@Test(priority = 3, description = "SendBidRequest: Verify successful request submission")
	public void selectProvider() throws InterruptedException {
		WebElement selectProvider = driver.findElement(By.xpath("//*[@automation-id=\"caterers\"]"));
		WebElement provider = wait.until(ExpectedConditions.elementToBeClickable(selectProvider));
		provider.click();
		Thread.sleep(2000);
		WebElement selectServiceType = driver.findElement(By.xpath("//*[@automation-id=\"bowl-food\"]"));
		WebElement service = wait.until(ExpectedConditions.elementToBeClickable(selectServiceType));
		service.click();
		Thread.sleep(2000);
		
	}
	

	@Test(priority = 4, description = "SendBidRequest: Verify successful request submission")
	public void selectTimeOfDay() throws InterruptedException {
		WebElement selectTimeOfDay = driver.findElement(By.xpath("//*[@automation-id=\"breakfast\"]"));
		WebElement provider = wait.until(ExpectedConditions.elementToBeClickable(selectTimeOfDay));
		provider.click();
		Thread.sleep(2000);
		
	}


	@Test(priority = 5, description = "SendBidRequest: Verify successful request submission")
	public void selectCuisines() throws InterruptedException {
		WebElement selectCuisine1 = driver.findElement(By.xpath("//*[@automation-id=\"international\"]"));
		WebElement cuisine1 = wait.until(ExpectedConditions.elementToBeClickable(selectCuisine1));
		cuisine1.click();
		Thread.sleep(1000);
		WebElement selectCuisine2 = driver.findElement(By.xpath("//*[@automation-id=\"american\"]"));
		WebElement cuisine2 = wait.until(ExpectedConditions.elementToBeClickable(selectCuisine2));
		cuisine2.click();
		Thread.sleep(1000);
		WebElement selectCuisine3 = driver.findElement(By.xpath("//*[@automation-id=\"asian\"]"));
		WebElement cuisine3 = wait.until(ExpectedConditions.elementToBeClickable(selectCuisine3));
		cuisine3.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@type='button' and text()= 'Next']")).click();
		
	}


	@Test(priority = 6, description = "SendBidRequest: Verify successful request submission")
	public void enterDishes() throws InterruptedException {

		WebElement enterDishes = driver.findElement(By.id("event_dishes"));
		enterDishes.sendKeys("Burger,Fries");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@type='button' and text()= 'Next']")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 7, description = "SendBidRequest: Verify successful request submission")
	public void selectCourses() throws InterruptedException {

		WebElement selectCourse1 = driver.findElement(By.xpath("//*[@automation-id=\"canapés\"]"));
		WebElement course1 = wait.until(ExpectedConditions.elementToBeClickable(selectCourse1));
		course1.click();
		Thread.sleep(1000);
		WebElement selectCourse2 = driver.findElement(By.xpath("//*[@automation-id=\"starters\"]"));
		WebElement course2 = wait.until(ExpectedConditions.elementToBeClickable(selectCourse2));
		course2.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@type='button' and text()= 'Next']")).click();
		Thread.sleep(1000);
	}


	@Test(priority = 8, description = "SendBidRequest: Verify successful request submission")
	public void selectLocation() throws InterruptedException {

		WebElement selectLocation = driver.findElement(By.xpath("//*[@automation-id=\"dubai\"]"));
		WebElement course1 = wait.until(ExpectedConditions.elementToBeClickable(selectLocation));
		course1.click();
		Thread.sleep(1000);
	}


	@Test(priority = 9, description = "SendBidRequest: Verify successful request submission")
	public void enterGuestAndDate() throws InterruptedException {

		addEventElements.enterNoOfGuests();
		Thread.sleep(1000);
		addEventElements.enterDate();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@type='button' and text()= 'Next']")).click();
		Thread.sleep(1000);
	}
	
	@Test(priority = 10, description = "SendBidRequest: Verify successful request submission")
	public void selectBudget() throws InterruptedException {

		try {
			// Check if the checkbox is present
			WebElement checkbox = driver.findElement(By.id("mybudgetIsFlexible"));

			// If checkbox is found, run these actions
			System.out.println("Checkbox found! Running budget slider actions...");
			Thread.sleep(2000);
			addEventElements.enterBudgeBySlider();
			Thread.sleep(2000);
			addEventElements.enterBudgeByInputFields();
			Thread.sleep(2000);
			addEventElements.isBudgetFlexibleCheckbox();
			Thread.sleep(1000);

		} catch (NoSuchElementException e) {
			System.out.println("Checkbox not found. Checking for 'casual' button...");

			try {
				// If checkbox is not found, check for the 'casual' button and click it
				WebElement casualButton = driver.findElement(By.xpath("//*[@automation-id=\"casual\"]"));
				System.out.println("'Casual' button found. Clicking...");
				casualButton.click();
			} catch (NoSuchElementException ex) {
				System.out.println("Neither checkbox nor 'casual' button found. Skipping...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@type='button' and text()= 'Next']")).click();
		Thread.sleep(1000);

	}

	@Test(priority = 11, description = "PrivateEvent: Verify signIn functionality")
	public void signIn() throws InterruptedException {

		driver.findElement(By.id("email")).sendKeys("muhammadzeeshan@glowfishlabs.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Glowfish@123");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("sendOtpContinueBtn"));
		js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
		Thread.sleep(1000);
		element.click();
		Thread.sleep(8000);
	}

	@Test(priority = 12, description = "PrivateEvent: Verify navigation to the home page")
	public void quotaionsAndGotoHome() throws InterruptedException {

		driver.findElement(By.xpath("//button[@arialable=\"want-quote\"]"));
		Thread.sleep(1000);
		addEventElements.goToHomePage();
		Thread.sleep(2000);
	}

}

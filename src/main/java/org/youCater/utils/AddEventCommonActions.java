package org.youCater.utils;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.youCater.userConfigurationsAndElements.AddEventElements;

public class AddEventCommonActions {

	private WebDriver driver;
	private AddEventElements addEventElements;
	private static String savedPhoneNumber;
	private WebDriverWait wait;
	public static String enteredMobileNo = null;
	public static String enteredFullName = null;
	public static String enteredEmail = null;
	private Actions actions;

	public AddEventCommonActions(WebDriver driver) {

		this.driver = driver;
		addEventElements = new AddEventElements(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);

	}
	
	public void signInViaEmailPassword() throws InterruptedException {
		
		driver.findElement(By.id("email")).sendKeys("automationuser@mailinator.com");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("Password@1");
		Thread.sleep(2000);
		addEventElements.otpContinueBtn();
		Thread.sleep(2000);
		
		}

	public void signInViaMobileNumber() throws InterruptedException {

		if (savedPhoneNumber == null) {
			savedPhoneNumber = WebActions.getOrGeneratePhoneNumber();
		}
		Thread.sleep(2000);
		WebElement selectCountry = driver.findElement(By.name("phoneNumberCountry"));
		Select select = new Select(selectCountry);
		select.selectByVisibleText("Pakistan");
		Thread.sleep(2000);
		// driver.findElement(By.id("phoneNumber")).sendKeys("3214651316");
		addEventElements.enterPhoneNo(savedPhoneNumber);
		Thread.sleep(2000);
		enteredMobileNo = addEventElements.getEnteredMobileNo();
		addEventElements.otpContinueBtn();
		Thread.sleep(2000);

	}

	public void verifyOTP() throws InterruptedException {

		int[] otpValues = { 1, 0, 0, 0, 5 };

		List<WebElement> otpElements = driver.findElements(By.xpath("//*[@class=\"verifyOtpHold\"]/input"));
		int i = 0;
		for (WebElement inputOtp : otpElements) {
			String otpValue = String.valueOf(otpValues[i]);
			inputOtp.sendKeys(otpValue);
			i++;

			if (i >= otpValues.length) {
				break;
			}
		}
		Thread.sleep(2000);

	}

	public void signUp() throws InterruptedException {

		Thread.sleep(2000);
		addEventElements.enterFullName();
		Thread.sleep(2000);
		enteredFullName = addEventElements.getEnteredName();
		addEventElements.enterEmail();
		Thread.sleep(2000);
		enteredEmail = addEventElements.getEnteredEmail();
		addEventElements.clickSignUpContinueBtn();
		Thread.sleep(2000);
	}

	public void verifyButtonIsDisabled() {
		WebElement button = driver.findElement(By.id("eventRouteNext"));
		Assert.assertEquals(button.isEnabled(), false);
	}

	public void verifyButtonIsEnabled() {
		WebElement button = driver.findElement(By.id("eventRouteNext"));
		Assert.assertEquals(button.isEnabled(), true);
	}

	public void verifyEmptyDateAlert() {

		WebElement errorMessageElement = driver.findElement(By.xpath("//*[contains(@class,\"text-alert\")]"));
		String errorMessage = errorMessageElement.getText();
		String expectedErrorMessage = "Start date is required";
		Assert.assertEquals(errorMessage, expectedErrorMessage);

	}

	public void assertTextEquals(WebDriver driver, String xpath, String expectedText, SoftAssert softAssert) {
		String actualText = driver.findElement(By.xpath(xpath)).getText();
		softAssert.assertEquals(actualText, expectedText, "Text mismatch: ");
	}

	public void verifyCalculatedBudget() throws InterruptedException {

		WebElement maxBudget = driver.findElement(By.id("range-max"));
		String maxAmount = maxBudget.getAttribute("value");
		double max = Double.parseDouble(maxAmount);
		double expectedAmount = max / 11;
		long roundedExpectedAmount = Math.round(expectedAmount);
		WebElement calculatedAmountElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='mb-3']")));
		String calculatedAmountText = calculatedAmountElement.getText();
		Pattern pattern = Pattern.compile("AED\\s*(\\d+(?:\\.\\d+)?)");
		Matcher matcher = pattern.matcher(calculatedAmountText);

		if (matcher.find()) {
			double actualAmount = Double.parseDouble(matcher.group(1));
			long roundedActualAmount = Math.round(actualAmount);
			System.out.println("Actual Amount: " + roundedActualAmount);
			System.out.println("Calculated Amount Text: " + calculatedAmountText);
			Assert.assertEquals(roundedExpectedAmount, roundedActualAmount);
		} else {
			throw new RuntimeException("Numeric value after 'AED' not found in the calculated amount text.");
		}

	}

	public void selectOptionFromFilter(WebDriver driver, String desiredText) {

		List<WebElement> parentElements = driver.findElements(By.xpath("//div[contains(@class,'lgFilters')]/div/h5"));
		for (WebElement parentElement : parentElements) {
			if (parentElement.getText().contains(desiredText)) {
				WebElement maximizeFilterOption = parentElement.findElement(
						By.xpath(".//picture[@class='ms-auto cursor-pointer relative closed']//*[name()='svg']"));
				wait.until(ExpectedConditions.elementToBeClickable(maximizeFilterOption));
				actions.moveToElement(maximizeFilterOption).click().perform();
				break;
			}
		}
	}

}

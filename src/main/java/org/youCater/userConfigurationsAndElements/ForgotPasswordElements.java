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

public class ForgotPasswordElements {

	private WebDriverWait wait;
	private JavascriptExecutor js;

	
	@FindBy(linkText = "Forgot password?")
	private WebElement forgotPassword;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(className = "storybook-button")
	private WebElement continueButton;
	
	@FindBy(className = "px-5")
	private WebElement okayButton;
	
	public ForgotPasswordElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
	}
	
	public void clickForgotPassword() {
		
		wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();
	}
	
	public void enterInValidEmail() {
		
		wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("automationuser");
		js.executeScript("arguments[0].blur();", email);
	}
	
	public void enterValidEmail() throws InterruptedException {

		WebElement enterEmail = wait.until(ExpectedConditions.elementToBeClickable(email));
		enterEmail.sendKeys(Keys.CONTROL + "a");
		enterEmail.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys("automationuser@mailinator.com");
	}
	
	
	public void clickContinueButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}
	
	public void clickOKButton() {
		
		wait.until(ExpectedConditions.elementToBeClickable(okayButton)).click();
	}
	

}

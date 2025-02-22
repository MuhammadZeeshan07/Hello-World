package org.youCater.userConfigurationsAndElements;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpElements{
	
	private WebDriverWait wait;
	
	@FindBy(linkText = "Log in")
	private WebElement login;
	
	@FindBy(linkText = "Sign up")
	private WebElement signup;
	
	@FindBy(id = "fullName")
	private WebElement fullName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "phoneNumber")
	private WebElement phone;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(className = "storybook-button")
	private WebElement submitButton;
	
	@FindBy(className = "backToPageBtn")
	private WebElement crossIcon;
	
	public SignUpElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		//js = (JavascriptExecutor) driver;
	}
	
	public void clickOnLogin() {

		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
	}
	
	public void clickOnSignup() {

		wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
	}
	
	public void enterName() {

		wait.until(ExpectedConditions.elementToBeClickable(fullName)).sendKeys("New Automation User");
	}

	public void enterEmail() {
		
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 10;
        Random random = new Random();
        StringBuilder username = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            username.append(characters.charAt(random.nextInt(characters.length())));
        }
        String domain = "mailinator.com";
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(username.toString() + "@" + domain);
	}
	
	public void enterPhoneNo() {

		Random random = new Random();
        int[] mobileCodes = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39};
        int mobileCode = mobileCodes[random.nextInt(mobileCodes.length)];
        int subscriberNumber = 1000000 + random.nextInt(9000000);
        String randomPhoneNumber = String.format("+923%d-%07d", mobileCode, subscriberNumber);
        wait.until(ExpectedConditions.elementToBeClickable(phone)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(phone)).sendKeys(randomPhoneNumber);
	}
	
	public void enterPassword() {

		wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys("Password@1");
	}
	
	public void enterConfirmPassword() {

		wait.until(ExpectedConditions.elementToBeClickable(confirmPassword)).sendKeys("Password@1");
	}
	
	public void submitForm() {

		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	public void clickOnCross() {

		wait.until(ExpectedConditions.elementToBeClickable(crossIcon)).click();
	}

}

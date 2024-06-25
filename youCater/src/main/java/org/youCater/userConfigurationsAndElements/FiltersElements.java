package org.youCater.userConfigurationsAndElements;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersElements {
	
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private WebElement element;
	
	@FindBy(id = "PRIVATE")
	private WebElement eventType;
	
	@FindBy(id = "MIXOLOGIST")
	private WebElement providerType;
	
	@FindBy(id = "BUFFET")
	private WebElement servingType;
	
	@FindBy(id = "GLUTEN_FREE")
	private WebElement dietary;
	
	@FindBy(id = "CUTLERY")
	private WebElement additional;
	
	@FindBy(className = "btnFilterSelectCity")
	private WebElement citySelector;
	
	@FindBy(id = "Abu Dhabi")
	private WebElement city;
	
	@FindBy(xpath = "//button[contains(text(), 'Save')]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Clear All')]")
	private WebElement clearButton;
	
	public FiltersElements(WebDriver driver) {

		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		js = (JavascriptExecutor) driver;
	}

	public void selectEventType() {

		wait.until(ExpectedConditions.elementToBeClickable(eventType)).click();
		
	}
	
	public void selectProviderType() {
		
		WebElement element = providerType;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void selectServingType() {

		element = servingType;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void selectDietary() {

		element = dietary;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void selectAdditionalServices() {

		element = additional;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public void selectCity() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(citySelector)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(city)).click();
	}
	
	public void applyFilters() {

		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
	
	public void clearFilters() {

		js.executeScript("arguments[0].scrollIntoView();", clearButton);
		js.executeScript("arguments[0].click();", clearButton);
		js.executeScript("arguments[0].click();", saveButton);
	}
	
	
	
}

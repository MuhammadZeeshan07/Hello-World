package org.youCater.utils;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WebActions {

	private WebDriver driver;
	private static String phoneNumber;

	public WebActions(WebDriver driver) {

		this.driver = driver;

	}

	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File source = scrShot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports/testCasesResult" + testCaseName + ".png";
		FileHandler.copy(source, new File(destinationFile));
		return destinationFile;

	}

	public String randomDate() {
		LocalDate futureDate = LocalDate.now().plusDays((long) (Math.random() * 28) + 3);
		String randomDate = futureDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));
		return randomDate;
	}

	public String randomName() {

		String[] names = { "Alice Bob", "Bob Charlie", "Charlie David", "David Eve", "Eve Frank", "Frank Grace",
				"Grace Hannah" };
		String randomName = names[new Random().nextInt(names.length)];
		return randomName;
	}

	public static String getOrGeneratePhoneNumber() {
		if (phoneNumber == null) {
			phoneNumber = RandomStringUtils.randomNumeric(10);
		}
		System.out.println(phoneNumber);
		return phoneNumber;

	}

	public String generateRandomValue(int minValue, int maxValue) {
		Random random = new Random();
		int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
		return String.valueOf(randomValue);
	}

	/*
	 * public static String getStoredPhoneNumber() { return phoneNumber; }
	 * 
	 * public static void resetPhoneNumber() { phoneNumber = null; }
	 */
	public String randomEmail() {
		String email = "test" + System.currentTimeMillis() + "@test.com";
		return email;
	}

	public void scrollUpAndDown() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
	}

	public void switchTabAndCloseOriginal() {
		String originalHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		String newTabHandle = null;

		for (String handle : allHandles) {
			if (!handle.equals(originalHandle)) {
				newTabHandle = handle;
				break;
			}
		}

		if (newTabHandle != null) {

			driver.switchTo().window(newTabHandle);
			String currentTabHandle = newTabHandle;
			driver.switchTo().window(originalHandle);
			driver.close();
			driver.switchTo().window(currentTabHandle);
		}
	}

	public String eventNames() throws InterruptedException {

		String[] eventNames = { "Afternoon Tea", "Gathering", "Birthday Party", "Gifting", "Dinner", "Lunch",
				"Breakfast" };
		String event = eventNames[new Random().nextInt(eventNames.length)];
		return event;
	}

	public String randomChat() throws InterruptedException {

		String[] chatList = { "Hi!", "Hello!", "Hope you are fine", "Thanks for your response" };
		String chat = chatList[new Random().nextInt(chatList.length)];
		return chat;

	}

	public static int getRandomIndex(List<WebElement> elements) {
		int randomIndex = -1;

		if (!elements.isEmpty()) {
			List<Integer> indices = new ArrayList<>();
			for (int i = 0; i < Math.min(elements.size(), 4); i++) {
				indices.add(i);
			}
			Collections.shuffle(indices);
			randomIndex = indices.get(0);
		}

		return randomIndex;
	}

	public static String convertDateToStandardFormat(String dateInOriginalFormat) {
		try {

			SimpleDateFormat originalFormat = new SimpleDateFormat("MMddyyyy");

			Date date = originalFormat.parse(dateInOriginalFormat);

			SimpleDateFormat standardFormat = new SimpleDateFormat("dd MMM yyyy");

			return standardFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String randomPartnerName() {

		String[] names = { "Gourmet Gatherings", "Culinary Canvas Catering", "Flavor Fusion Caterers",
				"Elegant Edibles Events", "Tasteful Traditions Catering" };
		String randomName = names[new Random().nextInt(names.length)];
		return randomName;
	}

	public String randomPartnerContactName() {

		String[] names = { "TasteTouch Catering", "Epicurean Events Hotline", "SavorySculpt Contact",
				"CulinaryCraft Connect", "FlavorfulFiesta Inquiries" };
		String randomName = names[new Random().nextInt(names.length)];
		return randomName;
	}
	
	public String randomCuisines () {

		String[] names = { "Italian", "French", "Desi",
				"Indian", "Mexican" };
		String randomName = names[new Random().nextInt(names.length)];
		return randomName;
	}

}

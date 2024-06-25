package org.youCater.userSanityTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.AcceptQuoteElements;
import org.youCater.userConfigurationsAndElements.Configurations;

public class MakeACall extends Configurations{

	private AcceptQuoteElements acceptQuote;
	private String string1 = "Call this Supplier";
	private String string2 = "You can call this supplier directly by calling this number:";
	private String string3 = "Toll-free number: 267 317 4624";
	private String[] expectedLines = {string1 , string2 , string3};
	
	public MakeACall() {
		
		acceptQuote = new AcceptQuoteElements(driver);
	}
	
	@Test(description = "Make call: Verify that vendor can call to the customer")
	public void customerMakeACall() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		acceptQuote.clickOnCall();
		Thread.sleep(2000);
		
		WebElement modal = acceptQuote.modal;
		String modalText = modal.getText();
		String[] lines = modalText.split("\\r?\\n");
		
		for (String line : lines) {
            System.out.println(line);
        }
		
		for (int i = 0; i < 3; i++) { 
			if (lines[i] == expectedLines[i]) {
				System.out.println("Line" + i + "Matched");
			}
			else {
				System.out.println("wrong text");
			}
        }
		
		acceptQuote.clickDone();
		Thread.sleep(2000);
	}
}

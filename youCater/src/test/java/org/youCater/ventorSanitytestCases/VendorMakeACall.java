package org.youCater.ventorSanitytestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorEventDirectoryElements;

public class VendorMakeACall extends VendorConfigurations{
	
	private VendorEventDirectoryElements vendorEventDirectoryElements;
	private String string1 = "Call this Customer";
	private String string2 = "You can call this customer directly by dialing this number:";
	private String string3 = "Toll-free number: 267 317 4624";
	private String[] expectedLines = {string1 , string2 , string3};
	
	public VendorMakeACall() {
		
		vendorEventDirectoryElements = new VendorEventDirectoryElements(driver);
	}
	
	@Test(description = "Make call: Verify that vendor can call to the customer")
	public void MakeACall() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		vendorEventDirectoryElements.clickOnCall();
		Thread.sleep(2000);
		
		WebElement modal = vendorEventDirectoryElements.modal;
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
		
		vendorEventDirectoryElements.clickDone();
		Thread.sleep(2000);
	}

}

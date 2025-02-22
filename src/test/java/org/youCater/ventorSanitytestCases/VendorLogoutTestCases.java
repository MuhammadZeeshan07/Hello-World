package org.youCater.ventorSanitytestCases;

import org.testng.annotations.Test;
import org.youCater.vendorConfigurationsAndElements.VendorConfigurations;
import org.youCater.vendorConfigurationsAndElements.VendorLoginElements;

public class VendorLogoutTestCases extends VendorConfigurations {
	

	private VendorLoginElements vendorLoginElements;
	
	public VendorLogoutTestCases() {

		vendorLoginElements = new VendorLoginElements(driver);
	}
	
	@Test
	public void vendorLogout() throws InterruptedException {
		
		Thread.sleep(6000);
		vendorLoginElements.logout();
	}

}

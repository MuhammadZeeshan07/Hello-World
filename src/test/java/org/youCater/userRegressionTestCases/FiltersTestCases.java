package org.youCater.userRegressionTestCases;

import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.HomePageElements;
import org.youCater.userSanityTestCases.SendBidRequestTestCases;
import org.youCater.utils.AddEventCommonActions;

public class FiltersTestCases extends Configurations {

	private HomePageElements homePageElements;
	private SendBidRequestTestCases sendBidRequestTestCases;
	private AddEventCommonActions addEventCommonActions;

	public FiltersTestCases() {

		homePageElements = new HomePageElements(driver);
		sendBidRequestTestCases = new SendBidRequestTestCases();
		addEventCommonActions = new AddEventCommonActions(driver);
	}

	@Test(description = "Search Caterer: Verify caterer search is working in user directory")
	public void searchCaterer() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.goToDirectory();
		Thread.sleep(2000);
		homePageElements.searchVendor();
		Thread.sleep(2000);

	}

	@Test(priority = 1, description = "Select Caterer: Verify that caterer selection is working after search")
	public void selectCaterer() throws InterruptedException {

		sendBidRequestTestCases.selecCaterer();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		homePageElements.clearSearch();
		Thread.sleep(2000);

	}

	@Test(priority = 2, description = "User Filters: Verify that filters applied successfully")
	public void applyFilter() throws InterruptedException {

		addEventCommonActions.selectOptionFromFilter(driver, "Type of events");
		
		Thread.sleep(2000);
	}
}

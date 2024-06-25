package org.youCater.userRegressionTestCases;

import org.testng.annotations.Test;
import org.youCater.userConfigurationsAndElements.AddEventElements;
import org.youCater.userConfigurationsAndElements.Configurations;
import org.youCater.userConfigurationsAndElements.FiltersElements;
import org.youCater.userConfigurationsAndElements.HomePageElements;
import org.youCater.userSanityTestCases.SendBidRequestTestCases;
import org.youCater.utils.AddEventCommonActions;

public class FiltersTestCases extends Configurations {

	private AddEventElements addEventElements;
	private HomePageElements homePageElements;
	private SendBidRequestTestCases sendBidRequestTestCases;
	private AddEventCommonActions addEventCommonActions;
	private FiltersElements filterElements;

	public FiltersTestCases() {

		filterElements = new FiltersElements(driver);
		addEventElements = new AddEventElements(driver);
		homePageElements = new HomePageElements(driver);
		sendBidRequestTestCases = new SendBidRequestTestCases();
		addEventCommonActions = new AddEventCommonActions(driver);
	}
	
	@Test(description = "HomePage: Verify user logged in successfully from the homepage")
	public void loginFromHomePage() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.loginFromHomePage();
		Thread.sleep(1000);
		addEventCommonActions.signInViaEmailPassword();
		/*
		 * addEventCommonActions.verifyOTP(); addEventCommonActions.signUp();
		 */
	}

	@Test(priority = 1, description = "Search Caterer: Verify caterer search is working in user directory")
	public void searchCaterer() throws InterruptedException {

		Thread.sleep(2000);
		homePageElements.goToDirectory();
		Thread.sleep(2000);
		homePageElements.searchVendor();
		Thread.sleep(2000);
		homePageElements.clearSearch();
		Thread.sleep(2000);

	}

	@Test(priority = 2, description = "Select Caterer: Verify that caterer selection is working after search")
	public void selectCaterer() throws InterruptedException {

		sendBidRequestTestCases.selecCaterer();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		homePageElements.clearSearch();
		Thread.sleep(2000);

	}

	@Test(priority = 3, description = "User Filters: Verify that filters applied successfully")
	public void applyFilter() throws InterruptedException {

		addEventCommonActions.selectOptionFromFilter(driver, "Type of events");
		filterElements.selectEventType();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Minimum guest");
		addEventElements.enterNoOfGuests();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Budget");
		addEventElements.enterBudgeBySlider();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Type of provider");
		filterElements.selectProviderType();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Type of serving");
		filterElements.selectServingType();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Dietary Requirements");
		filterElements.selectDietary();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "Additional services");
		filterElements.selectAdditionalServices();
		Thread.sleep(2000);
		
		addEventCommonActions.selectOptionFromFilter(driver, "City");
		filterElements.selectCity();
		Thread.sleep(2000);
		
		filterElements.applyFilters();
		Thread.sleep(2000);
	}
	
	@Test(priority = 4, description = "User Filters: Clear filters")
	public void clearFilter() throws InterruptedException {
		
		filterElements.clearFilters();
		Thread.sleep(2000);
		
	}

}

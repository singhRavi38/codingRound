package com.automation.codinground;

import framework_lib.DriverFactory;
import framework_lib.Resusable_Lib;
import uimap.Uimap_FlightsPage;
import uimap.Uimap_HotelsPage;
import uimap.Uimap_LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	
public class FlightBookingTest {

	WebDriver driver;
	Uimap_FlightsPage flightPg;
	Uimap_HotelsPage hotelPg;
	Uimap_LoginPage loginPg;
	Resusable_Lib Reusable;
	
	@BeforeTest
	public void testThatResultsAppearForAOneWayJourneyBeforeTest(){
		Reusable = new Resusable_Lib();
		flightPg = new Uimap_FlightsPage();
		hotelPg = new Uimap_HotelsPage();
		loginPg = new Uimap_LoginPage();
    	driver = DriverFactory.getInstance().getDriver();    	
        driver.get("https://www.cleartrip.com/");
	}

    @SuppressWarnings("static-access")
	@Test
    public void testThatResultsAppearForAOneWayJourney() {    	
    	
    	Reusable.waitForPageLoad(driver);
    	flightPg.oneWayRadioBtn.click();
    	flightPg.originTextbox.clear();
    	flightPg.originTextbox.sendKeys("Bangalore");
   	
        //wait for the auto complete options to appear for the origin
        Reusable.waitForPageLoad(driver);
        flightPg.originOptionsList.get(0).click();

        flightPg.destinationTextBox.clear();
        flightPg.destinationTextBox.sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination
        Reusable.waitForPageLoad(driver);
        //select the first item from the destination auto complete list
        flightPg.destinationOptionsList.get(0).click();
        
        Reusable.waitForPageLoad(driver);
        Reusable.selectDate(23, "December", 2019);

        //all fields filled in. Now click on search
        flightPg.searchBtn.click();

        Reusable.waitForPageLoad(driver);
        //verify that result appears for the provided journey search
        Assert.assertTrue(Reusable.isElementPresent(By.className("searchSummary")));

    }
    @AfterTest
    public void testThatResultsAppearForAOneWayJourneyAfterTest() {
        //close the browser
        driver.quit();
    }
}

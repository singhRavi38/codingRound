package com.automation.codinground;

import framework_lib.DriverFactory;
import framework_lib.Resusable_Lib;
import uimap.Uimap_FlightsPage;
import uimap.Uimap_HotelsPage;
import uimap.Uimap_LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelBookingTest {

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
    public void shouldBeAbleToSearchForHotels() {
    	hotelPg.hotelLink.click();
    	Reusable.waitForPageLoad(driver);
    	hotelPg.localityTextBox.sendKeys("Indiranagar, Bangalore");
    	hotelPg.searchButton.click();        

    }
    @AfterTest
    public void shouldBeAbleToSearchForHotelsAfterTest() {
    	driver.quit();
    }
}

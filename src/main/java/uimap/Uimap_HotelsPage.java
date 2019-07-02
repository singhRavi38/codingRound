package uimap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework_lib.DriverFactory;

public class Uimap_HotelsPage {
	WebDriver driver = DriverFactory.getInstance().getDriver();
	
	public Uimap_HotelsPage(){
		PageFactory.initElements(driver, this);
	}
    @FindBy(linkText = "Hotels")
    public WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;
 
    @FindBy(id = "SearchHotelsButton")
    public WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    public WebElement travellerSelection;

}

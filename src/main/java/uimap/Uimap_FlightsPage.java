package uimap;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import framework_lib.DriverFactory;

public class Uimap_FlightsPage {

	WebDriver driver = DriverFactory.getInstance().getDriver();
	
	public Uimap_FlightsPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="OneWay")
	public WebElement oneWayRadioBtn;
	
	@FindBy(id="FromTag")
	public WebElement originTextbox;
	
	@FindBy(id="ToTag")
	public WebElement destinationTextBox;
	
	@FindBys({@FindBy(xpath="//ul[@id='ui-id-1']/li/a")})
	public List<WebElement> originOptionsList;
	
	@FindBys({@FindBy(xpath="//ul[@id='ui-id-2']/li/a")})
	public List<WebElement> destinationOptionsList;
	
	@FindBy(id="SearchBtn")
	public WebElement searchBtn;
}

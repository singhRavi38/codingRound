package uimap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework_lib.DriverFactory;

public class Uimap_LoginPage {
	WebDriver driver = DriverFactory.getInstance().getDriver();
	
	public Uimap_LoginPage(){
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(linkText = "Your trips")
    public WebElement yourTripLink; //
    
    @FindBy(id = "SignIn")
    public WebElement signInBtn;

    @FindBy(name = "modal_window")
    public WebElement loginPop;

    @FindBy(id = "signInButton")
    public WebElement signInPopButton;

    @FindBy(id = "errors1")
    public WebElement errorMessage;
}

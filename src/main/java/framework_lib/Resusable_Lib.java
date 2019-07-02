package framework_lib;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resusable_Lib {
	WebDriver driver = DriverFactory.getInstance().getDriver();
		
	public static void waitForPageLoad(WebDriver driver){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public static void waitForPresenceOfElement(WebDriver driver,By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	boolean selectDateMethod(int date,String month,int year){
		WebElement currentMonthFirstBlock=driver.findElement(By.xpath("//div[@class='monthBlock first']/div/div/span[@class='ui-datepicker-month']"));
		WebElement currentYearFirstBlock=driver.findElement(By.xpath("//div[@class='monthBlock first']/div/div/span[@class='ui-datepicker-year']"));
		WebElement nextMonth=driver.findElement(By.xpath("//div[@class='monthBlock last']/div/a"));
		if(year==Integer.valueOf(currentYearFirstBlock.getText())){
			if(currentMonthFirstBlock.getText().equals(month)){
				driver.findElement(By.xpath("//div[@class='monthBlock first']//td/a[text()='"+date+"']")).click();
				return true;
			}
		}		
		nextMonth.click();
	 return false;
	}
	public void selectDate(int date,String month,int year){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(selectDateMethod(date, month, year))
				break;		
		}
	}
	public boolean isElementPresent(By locatorKey) {
	    try {
	          driver.findElement(locatorKey);
	          return true;
	        } catch (org.openqa.selenium.NoSuchElementException e) {
	          return false;
	        }
	}


}

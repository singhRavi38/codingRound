package framework_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.sun.javafx.PlatformUtil;

@SuppressWarnings("restriction")
public class DriverFactory {
	
	private DriverFactory()
	   {
	      //Do-nothing..Do not allow to initialize this class from outside
	   }
	   private static DriverFactory instance = new DriverFactory();

	   public static DriverFactory getInstance()
	   {
	      return instance;
	   }

	   ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
	   {
	      @Override
	      protected WebDriver initialValue()
	      {
	    	 setDriverPath();
	         return new ChromeDriver(); // can be replaced with other browser drivers
	      }
	   };
	   private void setDriverPath() {
	        if (PlatformUtil.isMac()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver");
	        }
	        if (PlatformUtil.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        }
	        if (PlatformUtil.isLinux()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	        }
	    }

	   public WebDriver getDriver() // call this method to get the driver object and launch the browser
	   {
	      return driver.get();
	   }

	   public void removeDriver() // Quits the driver and closes the browser
	   {
	      driver.get().quit();
	      driver.remove();
	   }


}

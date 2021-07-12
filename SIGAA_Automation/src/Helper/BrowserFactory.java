package Helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	static WebDriver driver;
	
	public static WebDriver startBroswer(String browserName, String url){
		
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","GeckoDriver/geckodriver");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		
		return driver;
	}
	
}

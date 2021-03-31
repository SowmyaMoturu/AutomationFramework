package com.sowmya.core.drivers.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.sowmya.core.drivers.BrowserType;
import com.sowmya.core.drivers.DriverOptions;
import com.sowmya.core.drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalDriverFactory implements DriverFactory {
	
	 WebDriver driver;

	
	@Override
	public WebDriver createInstance(BrowserType browserType)  {
		
		
		DriverOptions driverOptions = new DriverOptions();
		switch(browserType) {
		
		case CHROME:
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(driverOptions.getchromeOptions());	
		
			break;
			
		case FIREFOX:
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(driverOptions.getFirefoxOptions());
			break;
			
		case IE:
			WebDriverManager.iedriver().setup();			
			driver = new InternetExplorerDriver();
			break;
			
		case SAFARI:
			driver = new SafariDriver();
			break;
			
		default:
			break;
				
		}
		
		driver.manage().window().maximize();
		return driver;
	}

}


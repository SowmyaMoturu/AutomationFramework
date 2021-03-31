package com.sowmya.core.drivers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class DriverOptions {
	
	public ChromeOptions getchromeOptions() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation", "disable-popup-blocking"})
						.setAcceptInsecureCerts(true)
						.addArguments("start-maximized");
		return chromeOptions;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setAcceptInsecureCerts(true);
		return firefoxOptions;
	}

}

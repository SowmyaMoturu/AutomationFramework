package com.sowmya.core.drivers;

import org.openqa.selenium.WebDriver;

import com.sowmya.core.exceptions.InvalidPropertyException;


public interface DriverFactory {
	public WebDriver createInstance(BrowserType browserType) throws InvalidPropertyException ;

}

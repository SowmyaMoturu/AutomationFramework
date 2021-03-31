package com.sowmya.core.drivers.remote;

import static com.sowmya.core.constants.Constants.CLOUD;
import static com.sowmya.core.constants.Constants.GRID_URL;
import static com.sowmya.core.constants.Constants.CLOUD_USERNAME;
import static com.sowmya.core.constants.Constants.ACCESS_KEY;
import static com.sowmya.core.constants.Constants.REMOTE_PREFIX;
import static com.sowmya.core.constants.Constants.REMOTE_URL;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.sowmya.core.config.Configuration;
import com.sowmya.core.drivers.BrowserType;
import com.sowmya.core.drivers.DriverOptions;
import com.sowmya.core.drivers.DriverFactory;
import com.sowmya.core.exceptions.InvalidPropertyException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoteDriverFactory implements DriverFactory {

	StringBuilder remoteURL;
	WebDriver driver;

	private static MutableCapabilities mutableCapabilities;

	@Override
	public WebDriver createInstance(BrowserType browserType) throws InvalidPropertyException {

		try {
			URL url = new URL(getURLString());
			System.out.println(getURLString());
			driver = new RemoteWebDriver(url, getBrowserCapabilities(browserType));

		} catch (MalformedURLException e) {

		}

		return driver;
	}

	private String getURLString() {

		try {
			remoteURL = new StringBuilder();

			if (Configuration.get(CLOUD).equalsIgnoreCase("true")) {
				remoteURL.append(Configuration.get(REMOTE_PREFIX)).append(Configuration.get(CLOUD_USERNAME)).append(":")
						.append(Configuration.get(ACCESS_KEY)).append(Configuration.get(REMOTE_URL));

			} else {
				remoteURL.append(Configuration.get(GRID_URL));
			}

		} catch (InvalidPropertyException e) {
			e.printStackTrace();
		}
		return remoteURL.toString();
	}

	public static MutableCapabilities getBrowserCapabilities(BrowserType browserType) {
		DriverOptions driverOptions = new DriverOptions();

		switch (browserType) {
		case CHROME:
			mutableCapabilities = driverOptions.getchromeOptions();
			break;

		case FIREFOX:

			mutableCapabilities = driverOptions.getFirefoxOptions();
			break;

		case IE:
			WebDriverManager.iedriver().setup();
			mutableCapabilities = new InternetExplorerOptions();
			break;

		case SAFARI:
			mutableCapabilities = new SafariOptions();
			break;

		default:
			break;

		}
		mutableCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		return mutableCapabilities;

	}

}

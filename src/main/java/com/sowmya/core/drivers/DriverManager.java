package com.sowmya.core.drivers;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.sowmya.core.config.Configuration;
import com.sowmya.core.drivers.local.LocalDriverFactory;
import com.sowmya.core.drivers.remote.RemoteDriverFactory;
import com.sowmya.core.exceptions.InvalidPropertyException;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static WebDriver driverObj;

	enum Target {
		LOCAL, REMOTE
	}

	static final Map<Target, Supplier<DriverFactory>> targetMap = new EnumMap<>(Target.class);

	static {
		targetMap.put(Target.LOCAL, LocalDriverFactory::new);
		targetMap.put(Target.REMOTE, RemoteDriverFactory::new);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(String browser) {
		if (Objects.isNull(getDriver())) {
			DriverManager.driver.set(createInstance(browser));
		} 
	}

	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
	}

	public static WebDriver createInstance(String browserName) {

		try {
			
			Target target = Target.valueOf(Configuration.get("target").toUpperCase().trim());

			Supplier<DriverFactory> driverFactory = targetMap.get(target);

			BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase().trim());

			if (Objects.nonNull(driverFactory))
				driverObj = driverFactory.get().createInstance(browserType);

		} catch (InvalidPropertyException | IllegalArgumentException e) {
			// Add Log Utility to log either Target is not valid or Browsertype is not valid
		
		}
		return driverObj;

	}

}

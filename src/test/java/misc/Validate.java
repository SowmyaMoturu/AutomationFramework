package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.sowmya.core.drivers.DriverManager;

public class Validate {
	
	WebDriver driver;
	
	@Test
	public void init() {
		DriverManager.setDriver("chrome");
		driver = DriverManager.getDriver();
		driver.get("https:google.com");
		driver.findElement(By.name("q")).sendKeys("Sowmya Moturu");
		driver.findElement(By.cssSelector("input[value = 'Google Search']")).click();
		System.out.print(driver.findElement(By.id("result-stats")).getText());
		driver.quit();
		;
	}

}

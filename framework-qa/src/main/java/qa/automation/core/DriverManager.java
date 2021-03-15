package qa.automation.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import qa.automation.utils.ReadConfigProperties;

public class DriverManager {
	
	private static WebDriver driver;
	
	private DriverManager() {}
	
	public static WebDriver getDriver(){
		if(driver == null) {
			switch (ReadConfigProperties.getProperties("browser")) {
				case "FIREFOX": driver = new FirefoxDriver(); break;
				case "CHROME": driver = new ChromeDriver(); break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));			
		}
		return driver;
	}

	public static void killDriver(){
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

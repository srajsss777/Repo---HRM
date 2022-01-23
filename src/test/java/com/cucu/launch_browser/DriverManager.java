package com.cucu.launch_browser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.cucu.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}

	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	public static void launchBrowser() {

		switch (Constants.BROWSER) {
		case "chrome":
			
			LOGGER.info("launching "+Constants.BROWSER);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			
			LOGGER.info("launching "+Constants.BROWSER);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			
			LOGGER.info("launching "+Constants.BROWSER);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}

	}

}

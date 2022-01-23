package com.cucu.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.cucu.constants.Constants;
import com.cucu.launch_browser.DriverManager;
import com.cucu.pageobjects.Login_Page;
import com.cucu.utilities.CommonUtils;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Common_Step_Definition {

	private static String scenarioName = null;

	public static String getScenarioName() {
		return scenarioName;
	}

	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);

	@Before
	public void beforeScenario(Scenario scenario) {
		
		scenarioName = scenario.getName();

		LOGGER.info("Execution started");
		
		try {
			
			LOGGER.info("Instantiating the CommonUtils");

			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking driver is null or not?");
			
			if(DriverManager.getDriver()==null) {
				LOGGER.info("browser is null, so Instantiating the driver");
				DriverManager.launchBrowser();
				CommonUtils.getInstance().initWebElements();
				login();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void login() {
		DriverManager.getDriver().get(Constants.APP_URL);
		Login_Page.getInstance().enterUserName(Constants.USERNAME);
		Login_Page.getInstance().enterPassowrd(Constants.PASSOWRD);
		Login_Page.getInstance().clickLogin();
		
	}

	

}

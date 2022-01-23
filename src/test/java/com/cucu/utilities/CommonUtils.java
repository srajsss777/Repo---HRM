package com.cucu.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucu.constants.Constants;
import com.cucu.launch_browser.DriverManager;
import com.cucu.pageobjects.Directory_Page;
import com.cucu.pageobjects.Home_Page;
import com.cucu.pageobjects.Login_Page;
import com.cucu.pageobjects.SelectEmployee_Page;
import com.cucu.pageobjects.Timesheet_Page;
import com.cucu.step_definition.Common_Step_Definition;

public class CommonUtils {

	public static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);
	private static CommonUtils commonUtils = null;

	private CommonUtils() {}

	public static CommonUtils getInstance() {

		if(commonUtils==null)
			commonUtils= new CommonUtils();
		return commonUtils;
	}

	public void loadProperties() {

		Properties properties = new Properties();

		try {
			properties.load(getClass().getResourceAsStream("/Config.properties"));
		} catch (IOException e) {

			e.printStackTrace();
		}


		Constants.BROWSER =	properties.getProperty("BROWSER");
		Constants.APP_URL =	properties.getProperty("APP_URL");
		Constants.USERNAME = properties.getProperty("USERNAME");
		Constants.PASSOWRD = properties.getProperty("PASSWORD");
	}

	public static void initWebElements() {
		PageFactory.initElements(DriverManager.getDriver(), Login_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Home_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Directory_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), SelectEmployee_Page.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), Timesheet_Page.getInstance());
	}


	public void takeScreenshot() {

		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(Common_Step_Definition.getScenarioName()+".png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void highLightElement(WebElement element) {
		JavascriptExecutor jsScript =(JavascriptExecutor) DriverManager.getDriver() ;
		jsScript.executeScript("arguments[0].setAttribute('Style','border: 2px solid red')", element);
	}
	
	public void selectFromDropdown(WebElement dropdown, String howTo, String value) {
		
		Select select = new Select(dropdown);
		
		switch (howTo) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
			
		case "value":
			select.selectByValue(value);
			break;
			
		case "text":
			select.selectByVisibleText(value);
			break;
			
		default:
			LOGGER.info("please select a valid selection in the feature file");
			break;
		}
	}


}

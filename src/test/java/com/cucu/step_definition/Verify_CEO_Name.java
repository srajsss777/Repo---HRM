package com.cucu.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

import com.cucu.constants.Constants;
import com.cucu.launch_browser.DriverManager;
import com.cucu.pageobjects.Directory_Page;
import com.cucu.pageobjects.Home_Page;
import com.cucu.pageobjects.Login_Page;
import com.cucu.utilities.CommonUtils;

import io.cucumber.java.en.*;

public class Verify_CEO_Name {

	private static final Logger LOGGER = LogManager.getLogger(Verify_CEO_Name.class);

	@Given("the user is logged in successfully & in homepage")
	public void the_user_is_logged_in_successfully_in_homepage() {

		try {
			String actual_URL = DriverManager.getDriver().getCurrentUrl();

			if(actual_URL.contains("dashboard")) {

				LOGGER.info("the user is logged in successfully & in homepage");
			} 

		}
		catch (Exception e) {

			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}

	}

	@When("the user clicks on directory option from the menubar")
	public void the_user_clicks_on_directory_option_from_the_menubar() {

		try {
			Home_Page.getInstance().clickMenuDirectory();
			LOGGER.info("the user clicks on directory option from the menubar");
		}

		catch (Exception e) {

			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@When("user selects job title as {string} from the dropdown using {string}")
	public void user_selects_job_title_as_from_the_dropdown(String jobTitle, String howTo) {
		try {

			CommonUtils.getInstance().selectFromDropdown(Directory_Page.getInstance().getSelect_role(), howTo, jobTitle);
			LOGGER.info("user selects job title as CEO from the dropdown");
		}
		catch (Exception e) {

			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@When("clicks on Search button")
	public void clicks_on_save_button() {
		try {
			Directory_Page.getInstance().clickonSearch();
			LOGGER.info("clicks on search button");
		}
		catch (Exception e) {

			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expected_Name) {
		try {

			String actual_Name = Directory_Page.getInstance().getname();

			if(actual_Name.equals(expected_Name))
			{	
				LOGGER.info("the user should see the CEO name as John Smith");
			}
		}
		catch (Exception e) {

			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

}

package com.cucu.step_definition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.cucu.launch_browser.DriverManager;
import com.cucu.pageobjects.Home_Page;
import com.cucu.pageobjects.SelectEmployee_Page;
import com.cucu.pageobjects.Timesheet_Page;
import com.cucu.utilities.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Verify_PendingTimesheet {

	private static final Logger LOGGER = LogManager.getLogger(Verify_PendingTimesheet.class);


	@Given("the user clicks on the homepage")
	public void the_user_clicks_on_the_homepage() {

		try {
			LOGGER.info("the user clicks on the homepage");

			String actual_URL = DriverManager.getDriver().getCurrentUrl();

			if(actual_URL.contains("dashboard")) {

				LOGGER.info("the user is in homepage");
			}
		}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}

	}

	@Given("the user clciks on time option from menu")
	public void the_user_clciks_on_time_option_from_menu() {
		try {
			Home_Page.getInstance().clickMenuTime();
			LOGGER.info("the user clciks on time option from menu");
		}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}

	}
	@Given("the user enter the name as {string}")
	public void the_user_enter_the_name_as(String name) {

		try {
			
			SelectEmployee_Page.getInstance().selectEmployee(name);
			LOGGER.info("the user enter the name as Garry White");
		}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			
			
			
		}
	}

	@Given("Clicks on view button")
	public void clicks_on_view_button() {
		try {
			SelectEmployee_Page.getInstance().clickView();
			LOGGER.info("Clicks on view button");
		}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String expected_Message) {
		try {
			String actual_Message =Timesheet_Page.getInstance().getTimesheet();
			if(actual_Message.equals(expected_Message)) {
				LOGGER.info("the user should see the message as No Records Found");
			}
		}
		catch (Exception e) {
			LOGGER.info("failed_______________________________________________");
			LOGGER.error(e);
			CommonUtils.getInstance().takeScreenshot();
			junit.framework.Assert.fail(e.getMessage());
			
		}
	}

}

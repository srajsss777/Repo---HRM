package com.cucu.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Timesheet_Page {

	private static Timesheet_Page Timesheet_Instance;

	private Timesheet_Page() {}

	public static Timesheet_Page getInstance() {

		if(Timesheet_Instance == null)
			Timesheet_Instance = new Timesheet_Page();
		return Timesheet_Instance;
	}

	@FindBy(id="noRecordsColumn")
	private WebElement timesheet_List;

	public String getTimesheet() {

		return timesheet_List.getText();
	}

}

package com.cucu.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectEmployee_Page {

	private static SelectEmployee_Page employee_Instance;

	private SelectEmployee_Page() {}

	public static SelectEmployee_Page getInstance() {

		if(employee_Instance == null)
			employee_Instance = new SelectEmployee_Page();
		return employee_Instance;
	}

	@FindBy(id="employee")
	private WebElement employee;

	@FindBy(id="btnView")
	private WebElement btn_view;


	public void selectEmployee(String name) {
		//employee.clear();
		employee.sendKeys(name);
	}
																																						
	public void clickView() {
		btn_view.click();
	}


}

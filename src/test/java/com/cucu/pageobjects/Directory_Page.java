package com.cucu.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.cucu.utilities.CommonUtils;

public class Directory_Page {
	
private static Directory_Page directory_Instance;
	
	private Directory_Page() {}
	
	public static Directory_Page getInstance() {
		
		if(directory_Instance == null)
			directory_Instance = new Directory_Page();
		return directory_Instance;
	}
	
	@FindBy(id="searchDirectory_job_title")
	private WebElement select_role;

	@FindBy(id="searchBtn")
	private WebElement btn_Search;
	
	@FindBy(xpath="//b[contains(text(),'John Smith')]")
	private WebElement name;

	public WebElement getSelect_role() {
		return select_role;
	}

//	public WebElement getBtn_Search() {
//		return btn_Search;
//	}
//
//	public WebElement get_Name() {
//		return name;
//	}
	
	
	public void selectJobTitle(String jobTitle){
		CommonUtils.getInstance().highLightElement(select_role);
		Select selectrole = new Select(select_role);
		selectrole.selectByVisibleText(jobTitle);
		
	}
	
	public void clickonSearch() {
		CommonUtils.getInstance().highLightElement(btn_Search);
		btn_Search.click();
	}
	
	public String getname() {
		CommonUtils.getInstance().highLightElement(name);
		return name.getText();
	}
}

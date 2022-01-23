package com.cucu.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucu.utilities.CommonUtils;

public class Home_Page {
	
private static Home_Page home_Instance;
	
	private Home_Page() {}
	
	public static Home_Page getInstance() {
		
		if(home_Instance == null)
			home_Instance = new Home_Page();
		return home_Instance;
	}
	
	@FindBy(linkText="Directory")
	private WebElement menu_Directory;
	
	@FindBy(linkText="Time")
	private WebElement menu_Time;

//	public  WebElement getMenu_Directory() {
//		return menu_Directory;
//	}
	
	public void clickMenuDirectory() {
		CommonUtils.getInstance().highLightElement(menu_Directory);
		menu_Directory.click();
	}
	
	public void clickMenuTime() {
		CommonUtils.getInstance().highLightElement(menu_Time);
		menu_Time.click();
	}
	
}

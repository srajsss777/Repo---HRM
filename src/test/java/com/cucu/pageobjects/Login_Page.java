package com.cucu.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucu.utilities.CommonUtils;

public class Login_Page {
	
	private static Login_Page login_instance;
	
	private Login_Page() {}
	
	public static Login_Page getInstance() {
		
		if(login_instance == null)
			login_instance = new Login_Page();
		return login_instance;
	}

	@FindBy(id="txtUsername")
	private WebElement TXT_USERNAME;
	
	@FindBy(id="txtPassword")
	private WebElement TXT_PASSWORD;
	
	@FindBy(id="btnLogin")
	private WebElement BTN_LOGIN;

//	public WebElement getTXT_USERNAME() {
//		return TXT_USERNAME;
//	}
//
//	public WebElement getTXT_PASSWORD() {
//		return TXT_PASSWORD;
//	}
//
//	public WebElement getBTN_LOGIN() {
//		return BTN_LOGIN;
//	}
	
	
	public void enterUserName(String uname) {
		CommonUtils.getInstance().highLightElement(TXT_USERNAME);
		TXT_USERNAME.sendKeys(uname);
	}
	
	public void enterPassowrd(String password) {
		CommonUtils.getInstance().highLightElement(TXT_PASSWORD);
		TXT_PASSWORD.sendKeys(password);
	}
	
	public void clickLogin() {
		CommonUtils.getInstance().highLightElement(BTN_LOGIN);
	    BTN_LOGIN.click();
	}
	
}

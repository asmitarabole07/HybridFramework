package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page Factory
	
	@FindBy(id = "txtUsername")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(name = "Submit")
	WebElement sumbitBtn;
	
	//Initializing the page objects
	 public LoginPage() {
		 PageFactory.initElements(driver, this);
	}
	 
	 public String validateLoginPageTitle() {
		 return driver.getTitle();
	}
	 
	 public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		sumbitBtn.click();
		
		return new HomePage();
	}
}

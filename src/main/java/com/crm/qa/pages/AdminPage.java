package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class AdminPage extends TestBase {

	@FindBy(id = "searchSystemUser_userName")
	WebElement usernameInput;
	
	@FindBy(id = "searchSystemUser_userType")
	WebElement userRole;
	
	@FindBy(id = "menu_admin_UserManagement")
	WebElement userMAnagement;
	
	@FindBy(id = "searchLocation_name")
	WebElement locationName;
	
	@FindBy(id = "searchLocation_city")
	WebElement cityName;
	
	@FindBy(id = "searchLocation_country")
	WebElement countryName;
	
	@FindBy(id ="btnSearch")
	WebElement searchButton;
	
	@FindBy(xpath = "//td[text()='No Records Found']")
	WebElement locationStatus;
	
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateUsernameAndUserRole() {
		usernameInput.sendKeys(prop.getProperty("username"));
		
		Select select=new Select(userRole);
		select.selectByVisibleText("Admin");
	}
	
	public boolean verifyUserManagementLebel() {
		return userMAnagement.isDisplayed();
	}
	
	public void validateLocationInputs(String name,String city,String country) {
		locationName.sendKeys(name);
		cityName.sendKeys(city);
		
		Select select=new Select(countryName);
		select.selectByVisibleText(country);
		
		searchButton.click();
		
	}
	
	
	
	
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(id = "menu_admin_viewAdminModule")
	WebElement adminLink;
	
	@FindBy(id = "welcome")
	WebElement usernameLabel;
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	WebElement leaveLink;
	
	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardLink;
	
	@FindBy(id = "menu_admin_Organization")
	WebElement organizationLink;
	
	@FindBy(id = "menu_admin_viewLocations")
	WebElement organizationLocation;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
	return driver.getTitle();
	}
	
	public AdminPage clickOnAdminLink() {
		adminLink.click();
		return new AdminPage();
	}
	
	public LeavePage clickOnLeaveLink() {
		leaveLink.click();
		return new LeavePage();
	}
	
	public DashboardPage clickOnDashboardLink() {
		dashboardLink.click();
		return new DashboardPage();
	}
	
	public boolean verifyCorrectUserName() {
		return usernameLabel.isDisplayed();
	}
	
	public void clickOnOrganizationLocation() {
		Actions actions=new Actions(driver);
		actions.moveToElement(organizationLink).build().perform();
		organizationLocation.click();
	}
}

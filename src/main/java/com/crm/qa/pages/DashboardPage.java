package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath ="//legend[text()='Pending Leave Requests']")
	WebElement pendingLeaveRequestStatus;
	
	@FindBy(xpath = "//span[text()='My Timesheet']")
	WebElement myTimesheetLebel;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatePendingLeaveRequestLebel() {
		return pendingLeaveRequestStatus.isDisplayed();
	}
	
	public boolean validateMyTimesheetLinkLebel() {
		return myTimesheetLebel.isDisplayed();
	}
	
	
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DashboardPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DashboardPage dashboardPage;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashboardPage=homePage.clickOnDashboardLink();
	}
	
	@Test(priority = 1)
	public void verifyMyTimesheetLebelTest() {
		Assert.assertTrue(dashboardPage.validateMyTimesheetLinkLebel());
	}
	
	@Test(priority = 2)
	public void validatePendingLeaveRequestsLebelTest() {
		Assert.assertTrue(dashboardPage.validatePendingLeaveRequestLebel());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}

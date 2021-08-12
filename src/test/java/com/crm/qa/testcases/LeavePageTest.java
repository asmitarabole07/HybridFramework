package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LeavePage;
import com.crm.qa.pages.LoginPage;

public class LeavePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	LeavePage leavePage;
	
	public LeavePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		leavePage=homePage.clickOnLeaveLink();
	}
	
	@Test
	public void leaveDataInputTest(){
		leavePage.dataInput();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class AdminPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	
	String sheetName="TestData";
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		adminPage=new AdminPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminPage=homePage.clickOnAdminLink();
	}
	
	@Test(priority = 1)
	public void verifyUserManagementLebelTest() {
		Assert.assertTrue(adminPage.verifyUserManagementLebel());
	}
	
	@Test(priority = 2)
	public void validateUsernameAndUserRoleTest() {
		adminPage.validateUsernameAndUserRole();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][]data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority = 3,dataProvider = "getdata")
	public void validateLocationSearchTest(String locationName,String city,String country) {
		homePage.clickOnOrganizationLocation();
		adminPage.validateLocationInputs(locationName, city, country);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

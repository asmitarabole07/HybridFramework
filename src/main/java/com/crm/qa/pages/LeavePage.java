package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class LeavePage extends TestBase {

	@FindBy(id = "calFromDate")
	WebElement leaveFrom;
	
	@FindBy(id = "calToDate")
	WebElement leaveTo;
	
	@FindBy(xpath = "//label[text()='All']")
	WebElement leaveStatus;
	
	@FindBy(name = "leaveList[txtEmployee][empName]")
	WebElement employee;
	
	@FindBy(id = "leaveList_cmbSubunit")
	WebElement subUnit;
	
	public LeavePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void dataInput() {
		Actions actions=new Actions(driver);
		leaveFrom.clear();
		leaveFrom.sendKeys("2021-08-01");
		actions.sendKeys(Keys.ENTER);
		leaveTo.clear();
		
		leaveStatus.click();
		employee.sendKeys(prop.getProperty("username"));
		
		Select select=new Select(subUnit);
		select.selectByValue("0");
		
	}
	
	
}

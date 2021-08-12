package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	public static String TestDataSheetPath="C:\\Users\\Administrator\\Desktop\\Programme files\\Java\\eclipse-workspace\\HybridFramework_OrangeHRM\\src\\main\\java\\com\\crm\\qa\\testdata\\OrangeHRM.xlsx";
		
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file=null;
		
		try {
			file=new FileInputStream(TestDataSheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	
	public static void TakeScreenshot() throws IOException {
		Date date = new Date();
		String name = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("C:\\Users\\Administrator\\Desktop\\Programme files\\Java\\eclipse-workspace\\HybridFramework_OrangeHRM\\screenshots\\"+name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}

package com.optico.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optioc.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 10;

	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	public static String Test_Data_Sheet_Path = currentURL
			+ "src\\main\\java\\com\\optico\\qa\\testdata\\TestData.xlsx";
	public static Workbook book;
	public static Sheet sheetName;
	
	public static Object[][] getTestData() {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Test_Data_Sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheet)
		
	}
}

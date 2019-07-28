package com.optico.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optioc.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 100;
	public static long IMPLICIT_WAIT = 10;

	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	public static String Test_Data_Sheet_Path = currentProjectdirectory
			+ "\\src\\main\\java\\com\\optico\\qa\\testdata\\TestData.xlsx";
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static FileInputStream file;

	public static Object[][] getTestData(String sheetName) throws IOException {
		file = null;
		try {
			file = new FileInputStream(Test_Data_Sheet_Path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		System.out.println("Sheet Number=" + sheet.toString());
		int rowCount = sheet.getLastRowNum();
		System.out.println("RowConut = " + rowCount);
		int cellCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Cell count = " + cellCount);
		Object[][] data = new Object[rowCount][cellCount];
		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < cellCount; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		file.close();
		return data;
	}

	public static void takeScreenShot(String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,
				new File(currentProjectdirectory + "\\Screenshots\\" + name + System.currentTimeMillis() + ".png"));
	}
}

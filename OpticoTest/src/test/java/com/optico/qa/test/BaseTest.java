/**
 * 
 */
package com.optico.qa.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.optioc.qa.base.BasePage;
import com.optioc.qa.base.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author aakas
 *
 */
public class BaseTest {

	WebDriver driver;
	public Page page;
	public Properties prop;
	public String currentProjectdirectory = System.getProperty("user.dir");

	/**
	 * 
	 * @param browserName
	 */
	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browserName) {

		/**
		 * Selecting the browser
		 */
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.print("Printing driver object" + driver);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("No browser is defined in testng.xml");
		}

		/**
		 * Defining the property file
		 */

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					currentProjectdirectory + "\\src\\main\\java\\com\\optico\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * Loading the URL
		 */
		driver.get(prop.getProperty("url"));
		driver.get("https://optico.herokuapp.com/");
		driver.manage().deleteAllCookies();
		page = new BasePage(driver);
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}

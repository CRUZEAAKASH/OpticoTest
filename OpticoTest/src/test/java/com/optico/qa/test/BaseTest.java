/**
 * 
 */
package com.optico.qa.test;

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
 * @author aakash
 *
 */
public class BaseTest {

	WebDriver driver;
	public Page page;
	public Properties prop;
	// public String currentProjectdirectory = System.getProperty("user.dir");

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
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*
		 * driver.manage().timeouts().pageLoadTimeout(PageClass.pageLoadTimeout,
		 * TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(PageClass.implicitlyWait,
		 * TimeUnit.SECONDS);
		 */
		page = new BasePage(driver);
		driver.get(page.prop.getProperty("url"));
		/**
		 * Loading the URL
		 */
		driver.get(prop.getProperty("url"));
		// driver.get("https://optico.herokuapp.com/");

	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}

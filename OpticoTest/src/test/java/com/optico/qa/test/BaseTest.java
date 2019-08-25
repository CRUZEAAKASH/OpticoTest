/**
 * 
 */
package com.optico.qa.test;

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

	@BeforeMethod
	@Parameters(value = { "browser" })
	public void setUpTest(String browserName) {
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
		driver.get("https://optico.herokuapp.com/");
		page = new BasePage(driver);
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
	}

}

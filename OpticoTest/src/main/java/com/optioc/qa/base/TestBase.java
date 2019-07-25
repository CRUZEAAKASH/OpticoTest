package com.optioc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.optico.qa.util.TestUtil;
import com.optico.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static String currentProjectdirectory = System.getProperty("user.dir");
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
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
	}

	public static void initalization() {
		String browserName = prop.getProperty("browser");
		System.out.print("printing browsername" + browserName);
		if (browserName.equals("chrome")) {
			System.out.print("Inside the loop");
			System.setProperty("webdriver.chrome.driver",
					currentProjectdirectory + "\\src\\main\\java\\com\\optico\\qa\\util\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.print("Printing driver object" + driver);
		}
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		// get URL
		driver.get(prop.getProperty("url"));
	}
}

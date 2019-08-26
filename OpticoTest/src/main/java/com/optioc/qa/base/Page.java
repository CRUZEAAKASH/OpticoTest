package com.optioc.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	public Properties prop;
	long pageLoadTimeout = 20;
	long implicitlyWait = 20;
	long ExplicitWait = 15;
	String configLocation = "\\src\\main\\java\\com\\optico\\qa\\config\\config.properties";

	public Page(WebDriver driver) throws IOException {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + configLocation);
		prop.load(file);
		file.close();
	}

	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForElement(By locator);

	public abstract void WaitForElement_To_Be_Clickable(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract boolean Click_Element(By Locator);

	public abstract boolean send_keys(By Locator, String keys);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

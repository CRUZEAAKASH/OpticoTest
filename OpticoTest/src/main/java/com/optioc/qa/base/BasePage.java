package com.optioc.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public Properties prop;
	public String currentProjectdirectory = System.getProperty("user.dir");

	public BasePage(WebDriver driver) {
		super(driver);
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

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForElement(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Error occured while locating the element" + locator);
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void waitForElement(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			wait.until(ExpectedConditions.elementToBeSelected(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean Click_Element(By Locator) {
		try {
			WebElement element = null;
			element = getElement(Locator);
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				System.out.println("Clicked At Element " + element.toString());
				return true;
			} else {
				WaitForElement_To_Be_Clickable(Locator);
				element.click();
				System.out.println("Took Time To Click At  Element " + element.toString());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean send_keys(By Locator, String keys) {
		try {
			WebElement element = null;
			element = getElement(Locator);
			if (element.isDisplayed() && element.isEnabled()) {
				element.sendKeys(keys);
				System.out.println("Sent Keys At  " + element.toString());
				return true;
			} else {
				waitForElement(Locator);
				element.sendKeys(keys);
				System.out.println("Took Time To Sent Keys At  " + element.toString());
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public void WaitForElement_To_Be_Clickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			System.out.println("Error Occured While Waiting for the Element to be Clickable");
			e.printStackTrace();
		}

	}

}

package com.optico.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.optioc.qa.base.TestBase;

public class RegisterCustomerPage extends TestBase {

	@FindBy(xpath = "//*[@class='mat-card-title']")
	WebElement registerCustomerHeading;

	@FindBy(xpath = "//*[@class='mat-select-value']")
	WebElement title;

	public RegisterCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHeading() {
		String heading = registerCustomerHeading.getText();
		return heading;
	}

	public void registerCustomer() {
		title.sendKeys("Miss");
	}
}

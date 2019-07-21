package com.optico.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.optico.qa.util.TestUtil;
import com.optioc.qa.base.TestBase;

public class RegisterCustomerPage extends TestBase {

	@FindBy(xpath = "//*[@class='mat-card-title']")
	WebElement registerCustomerHeading;

	@FindBy(xpath = "//*[@class='mat-select-value']")
	WebElement title;

	@FindBy(xpath = "(//*[@class='mat-option-text'])[3]")
	WebElement salutation;

	@FindBy(name = "customer-name")
	WebElement Name;

	@FindBy(name = "customer-dob")
	WebElement DOB;

	@FindBy(xpath = "//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted']")
	WebElement datePicker;

	@FindBy(xpath = "//*[@class='mat-calendar-arrow']")
	WebElement YearDropDown;

	@FindBy(xpath = "//*[@aria-label = 'Previous 20 years']")
	WebElement previousYear;

	@FindBy(xpath = "//*[@class='mat-calendar-body-cell-content' and contains(text(), '1992')]")
	WebElement Year;

	@FindBy(xpath = "//*[@class='mat-calendar-body-cell-content' and contains(text(), 'JAN')]")
	WebElement Month;

	@FindBy(xpath = "//*[@class='mat-calendar-body-cell-content' and contains(text(), '10')]")
	WebElement Date;

	@FindBy(name = "customer-mobile")
	WebElement Mobile;

	@FindBy(name = "customer-address")
	WebElement address;

	@FindBy(xpath = "//span[@class='mat-button-wrapper' and contains(text(), 'Save')]")
	WebElement save;

	public RegisterCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHeading() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Register Customer')]")));
		String heading = registerCustomerHeading.getText();
		return heading;
	}

	public ViewCustomerPage registerCustomer() throws InterruptedException {
		title.click();
		salutation.click();
		Name.sendKeys("Aakash");
		Thread.sleep(3000);
		
		datePicker.click();
		Thread.sleep(1000);
		YearDropDown.click();
		
		previousYear.click();
		
		Year.click();
		
		Month.click();
		
		Date.click();
		Thread.sleep(1000);
		Mobile.sendKeys("1234567890");
		address.sendKeys("Pune");
		save.click();
		
		return new ViewCustomerPage();
	}
}

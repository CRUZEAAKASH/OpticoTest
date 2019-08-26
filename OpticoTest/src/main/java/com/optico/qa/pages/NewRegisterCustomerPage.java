/**
 * 
 */
package com.optico.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.optico.qa.util.TestUtil;
import com.optioc.qa.base.BasePage;

/**
 * @author aakas
 *
 */
public class NewRegisterCustomerPage extends BasePage {

	private By registerCustomerHeading = By.xpath("//*[@class='mat-card-title']");

	private By title = By.xpath("//*[@class='mat-select-value']");

	private By salutation = By.xpath("(//*[@class='mat-option-text'])[3]");

	private By Name = By.name("customer-name");

	private By DOB = By.name("customer-dob");

	private By datePicker = By.xpath("//*[@class='mat-datepicker-toggle-default-icon ng-star-inserted']");

	private By YearDropDown = By.xpath("//*[@class='mat-calendar-arrow']");

	private By previousYear = By.xpath("//*[@aria-label = 'Previous 20 years']");

	private By Year = By.xpath("//*[@class='mat-calendar-body-cell-content' and contains(text(), '1992')]");

	private By Month = By.xpath("//*[@class='mat-calendar-body-cell-content' and contains(text(), 'JAN')]");

	private By Date = By.xpath("//*[@class='mat-calendar-body-cell-content' and contains(text(), '10')]");

	private By Mobile = By.name("customer-mobile");

	private By address = By.name("customer-address");

	private By save = By.xpath("//span[@class='mat-button-wrapper' and contains(text(), 'Save')]");

	private By newCustomer = By.xpath("//div[contains(text(), 'New Customer')]");

	/**
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public NewRegisterCustomerPage(WebDriver driver) throws IOException {
		super(driver);
		// TODO Auto-generated constructor stub
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
		String heading = getElement(registerCustomerHeading).getText();
		return heading;
	}

	public ViewCustomerPage registerCustomer(String Customertitle, String CustomerName, String CustomerGender,
			String CustomerDOB, String CustomerAge, String CustomerMobile, String CustomerAddress)
			throws InterruptedException {
		Click_Element(newCustomer);
		Click_Element(title);
		Click_Element(salutation);
		send_keys(Name, CustomerName);
		Thread.sleep(3000);
		Click_Element(datePicker);
		Thread.sleep(1000);
		Click_Element(YearDropDown);
		Click_Element(previousYear);
		Click_Element(Year);
		Click_Element(Month);
		Click_Element(Date);
		Thread.sleep(1000);
		send_keys(Mobile, CustomerMobile);
		send_keys(address, CustomerAddress);
		Click_Element(save);
		Thread.sleep(5000);
		return new ViewCustomerPage();
	}

}

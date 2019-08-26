/**
 * 
 */
package com.optico.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.optioc.qa.base.BasePage;

/**
 * @author aakas
 *
 */
public class NewLoginPage extends BasePage {

	private By userName = By.name("email");

	private By password = By.name("password");

	private By login = By.xpath("//span[contains(text(), ' Login ')]");

	private By logo = By.xpath("//*[@class='title']");

	/**
	 * 
	 * @throws IOException
	 * @declare constructor
	 */
	public NewLoginPage(WebDriver driver) throws IOException {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return getElement(userName);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the login
	 */
	public WebElement getLogin() {
		return getElement(login);
	}

	/**
	 * @return the logo
	 */
	public WebElement getLogo() {
		System.out.println("priniting logo element" + logo);
		return getElement(logo);
	}

	/**
	 * 
	 * @return
	 */
	public String ValidateLoginPageLogo() {
		return getElement(logo).getText();
	}

	/**
	 * 
	 * @return
	 */
	public String verifyTitle() {
		// return driver.getTitle();
		return getPageTitle();
	}

	/**
	 * 
	 * @return
	 */
	public NewRegisterCustomerPage login() {
		String un = prop.getProperty("username");
		String pswd = prop.getProperty("password");
		send_keys(userName, un);
		send_keys(password, pswd);
		Click_Element(login);

		return getInstance(NewRegisterCustomerPage.class);// return new RegisteredCustomerPage();

	}

}

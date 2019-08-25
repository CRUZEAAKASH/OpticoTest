/**
 * 
 */
package com.optico.qa.pages;

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

	// Page Factory
	@FindBy(name = "email")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//span[contains(text(), ' Login ')]")
	private WebElement login;

	@FindBy(xpath = "//*[@class='title']")
	WebElement logo;

	/**
	 * 
	 * @declare constructor
	 */
	public NewLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the userName
	 */
	public WebElement getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * @return the login
	 */
	public WebElement getLogin() {
		return login;
	}

	/**
	 * @return the logo
	 */
	public WebElement getLogo() {
		System.out.println("priniting logo element" + logo);
		return logo;
	}

	public String ValidateLoginPageLogo() {
		return logo.getText();
	}

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
		userName.sendKeys(un);
		password.sendKeys(pswd);
		login.click();

		return getInstance(NewRegisterCustomerPage.class);// return new RegisteredCustomerPage();

	}

}

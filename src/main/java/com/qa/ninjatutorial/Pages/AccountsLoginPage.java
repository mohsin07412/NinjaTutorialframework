package com.qa.ninjatutorial.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.Utilities.ElementUtil;
import com.qa.ninjatutorial.base.BasePage;

import io.qameta.allure.Step;

public class AccountsLoginPage  extends BasePage{
	WebDriver driver;
	private ElementUtil elementutil;
	
	//By locators
	private By emailtext=By.id("input-email");
	private  By passwordtext=By.id("input-password");
	private By loginbtn=By.xpath("//input[@value='Login']");
	private By forgotpasswordLink=By.linkText("Forgotten Password123");
	private By registerbutton=By.linkText("Register");
//constructor

	public AccountsLoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
	}
	//page actions
	@Step("getting login page title")
	public String getLoginpagetitle() {
		return elementutil.waitForTitlePresent(Constants.ACCOUNTS_LOGIN_PAGE_TITLE, 10);
	}
	@Step("logging in with username :{0} and password :{1}")
	public AccountsPage dologin(String un,String pw) {
		//driver.findElement(emailtext).sendKeys(un);
		//driver.findElement(passwordtext).sendKeys(pw);
		//driver.findElement(loginbtn).click();
		elementutil.doSendKeys(emailtext, un);
		elementutil.doSendKeys(passwordtext, pw);
		elementutil.doClick(loginbtn);
		return new AccountsPage(driver);
	}
	@Step("gettin")
	public boolean forgotPasswordlinkexist() {
		return elementutil.doIsDisplayed(forgotpasswordLink);
	}
	
	public RegisterPage navigatetoRegisterPage() {
		elementutil.doClick(registerbutton);
		return new RegisterPage(driver);
	}
}


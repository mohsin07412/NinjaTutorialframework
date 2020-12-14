package com.qa.ninjatutorial.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.Utilities.ElementUtil;
import com.qa.ninjatutorial.base.BasePage;

public class RegisterPage extends BasePage { 
	ElementUtil elementutil;
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
private By subscribeyes=By.xpath("//label[@class='radio-inline']/input[@value='1']");
private By subscribeNo=By.xpath("//label[@class='radio-inline']/input[@value='0']");

private By agreeCheckbox = By.name("agree");
private By continueButton = By.xpath("//input[@type='submit' and @value = 'Continue']");

private By accountSuccessMessg = By.cssSelector("#content h1");
private By logoutLink = By.linkText("Logout");
private By registerLink = By.linkText("Register");




public RegisterPage(WebDriver driver) {
	this.driver=driver;
	elementutil=new ElementUtil(this.driver);	
}
public boolean accountregistratin(String firtsname,String lastname,String email,String password,String telephone,String subscribe) {
	elementutil.doSendKeys(this.firstname, firtsname);
	elementutil.doSendKeys(this.lastname, lastname);
	elementutil.doSendKeys(this.email, email);
	elementutil.doSendKeys(this.telephone, telephone);
	elementutil.doSendKeys(this.password, password);
	elementutil.doSendKeys(this.confirmpassword, password);
	
	if (subscribe.equalsIgnoreCase("yes")){
		elementutil.doClick(subscribeyes);	
	}else {
		elementutil.doClick(subscribeNo);
	}
	elementutil.doClick(agreeCheckbox);
	elementutil.doClick(continueButton);
	
	String text = elementutil.doGetText(accountSuccessMessg);
	if(text.contains(Constants.ACCOUNT_SUCCESS_MESSG)) {
		elementutil.doClick(logoutLink);
		elementutil.doClick(registerLink);

		return true;
	}
	return false;
}
}  

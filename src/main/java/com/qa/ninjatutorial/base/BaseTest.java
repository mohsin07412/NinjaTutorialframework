package com.qa.ninjatutorial.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.ninjatutorial.Pages.AccountsLoginPage;
import com.qa.ninjatutorial.Pages.AccountsPage;
import com.qa.ninjatutorial.Pages.ProductsPage;
import com.qa.ninjatutorial.Pages.RegisterPage;

public class BaseTest {
public BasePage basepage;
public Properties prop;
public WebDriver driver;
public AccountsPage accountspage;
public AccountsLoginPage accountloginpage;
public ProductsPage productspage;
public RegisterPage registerpage;


@BeforeTest
public void setUp() {
	basepage=new BasePage();
	prop=basepage.init_properties();
	String browser=prop.getProperty("browser");
	driver=basepage.init_driver(browser);
	accountloginpage=new AccountsLoginPage(driver);
	driver.get(prop.getProperty("url"));
	
}
@AfterTest
public void tearDown() {
	driver.quit();
}
}      

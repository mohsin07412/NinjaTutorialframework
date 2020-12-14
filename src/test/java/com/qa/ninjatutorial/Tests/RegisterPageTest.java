package com.qa.ninjatutorial.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.Utilities.ExcelUtil;
import com.qa.ninjatutorial.base.BaseTest;

public class RegisterPageTest extends BaseTest {
	
	
@BeforeClass
public void  registerPageSetup() {
	registerpage=accountloginpage.navigatetoRegisterPage();
}

@DataProvider
public Object[][] getRegisterdata() {
Object data[][]=	ExcelUtil.getexceldata(Constants.RegisterSheetName);
return data;
}

@Test(dataProvider="getRegisterdata")
public void Userregistrationtest(String firtsname,String lastname,String telephone,String password,String subscribe,String email) {
	registerpage.accountregistratin(firtsname, lastname, email, password, telephone, subscribe);
}

}

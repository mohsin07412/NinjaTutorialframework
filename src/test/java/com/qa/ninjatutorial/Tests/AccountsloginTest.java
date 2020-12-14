package com.qa.ninjatutorial.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.base.BaseTest;

public class AccountsloginTest extends BaseTest{

		
		@Test(priority=1)
		public void verifyAccountsloginpagetitleTest(){
			String title=accountloginpage.getLoginpagetitle();
			System.out.println("page title is :" +title);
	Assert.assertEquals(title, Constants.ACCOUNTS_LOGIN_PAGE_TITLE);

	}
		
		@Test(priority=3)
		public void verifydoLoginTest() {
			accountloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		}
		@Test(priority=2)
		
		public void VerifyforgotPasswordlinkExist() {
			Assert.assertTrue(accountloginpage.forgotPasswordlinkexist());
		}
	}



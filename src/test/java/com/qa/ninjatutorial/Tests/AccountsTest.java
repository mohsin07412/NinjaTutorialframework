package com.qa.ninjatutorial.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AccountsTest extends BaseTest {
	
	@BeforeClass
	public void setUpMethod() {
	accountspage=	accountloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Description("accounts page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyAccountsPageTitleTest() {
	String title=	accountspage.getAccountPagetitle();
	System.out.println("the accounts page title is :" +title);
	Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}
	@Description("verify Headervalue Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyHeaderavalueTest() {
		String header=accountspage.getheadervalue();
		System.out.println("header value is :" +header);
		Assert.assertEquals(header, Constants.ACCOUNTS_PAGE_HEADER);
		
	}
	@Description("verify Accounts Sectioncount Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void verifyAccountsSectioncountTest() {
		Assert.assertTrue(accountspage.getAccountSectionsCount()==Constants.ACCOUNTS_SECTION_VALUE);
	}
	
	@Test(priority=4)
	@Description("verify Accounts Section list Test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyAccountsSectionListTest() {
		accountspage.getAccountSectionList();
		Assert.assertEquals(accountspage.getAccountSectionList(), Constants.accountSectionList());
	}
	@Test(priority=5)
	@Description("verify Accounts do search Test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySearchTest() {
		Assert.assertTrue(accountspage.doSearch("iMac"));
	}

}

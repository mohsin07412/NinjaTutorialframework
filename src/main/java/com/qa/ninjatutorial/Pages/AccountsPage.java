package com.qa.ninjatutorial.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ninjatutorial.Utilities.Constants;
import com.qa.ninjatutorial.Utilities.ElementUtil;
import com.qa.ninjatutorial.base.BasePage;

public class AccountsPage extends BasePage {
	private WebDriver driver;
	private ElementUtil elementutil;
	//By locators
	private By logo=By.cssSelector("div#logo a");
	private By accountSectionheaders=By.cssSelector("div#content h2");
	private By searchText=By.cssSelector("div#search input[name='search']");
	private By searchButton=By.cssSelector("div#search button[type='button']");
	private By searchitemresult=By.cssSelector(".product-layout .product-thumb");
	private By SearchResults=By.cssSelector(".product-thumb h4  a");
	
	//Constructors
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(driver);
		
	}
	public String getAccountPagetitle() {
		return elementutil.waitForTitlePresent(Constants.ACCOUNTS_PAGE_TITLE, 10);
	}
	public String getheadervalue() {
		if(elementutil.doIsDisplayed(logo)) {
			return elementutil.doGetText(logo);
					
		}
		return null;
		
	}
	public int getAccountSectionsCount() {

		//return driver.findElements(accountSectionheaders).size();
		return elementutil.getElements(accountSectionheaders).size();
	}
	public List<String> getAccountSectionList() {
		List<WebElement>accsectionlist= elementutil.getElements(accountSectionheaders);
		List<String>accountslist=new ArrayList<String>();
		
		for(WebElement ele:accsectionlist) {
			System.out.println(ele.getText());
		accountslist.add(ele.getText());
		}
		return accountslist;
	}
	public boolean doSearch (String productname) {
		//driver.findElement(searchText).sendKeys(productname);
		elementutil.doSendKeys(searchText, productname);
	//	driver.findElement(searchButton).click();
		elementutil.doClick(searchButton);
		if(elementutil.getElements(searchitemresult).size()>0) {
			return true;
		}
		return false;
		
	}
	public ProductsPage SelectProductfromResults(String productname) {
	List<WebElement>results=elementutil.getElements(SearchResults);	
	System.out.println("total no of results :" +results);
	 for(WebElement e:results) {
		 if(e.getText().equals(productname)) {
			 e.click();
			 break;
		 }
	 }
	 return new ProductsPage(driver);
		
	}
	

}

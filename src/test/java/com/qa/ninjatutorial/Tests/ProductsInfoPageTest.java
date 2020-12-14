package com.qa.ninjatutorial.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ninjatutorial.base.BaseTest;

public class ProductsInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void productInfoSetUp() {
		accountspage = accountloginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void verifyProductPageTitle() {
		accountspage.doSearch("iMac");

		productspage = accountspage.SelectProductfromResults("iMac");

		Assert.assertEquals(productspage.getPageTitle("iMac"),"iMac");
	}
	
	
	@Test(priority=1)
	public void verifyProductInfoTest_MacBook() {
		String productName = "MacBook Pro";

		Assert.assertTrue(accountspage.doSearch(productName));

		productspage = accountspage.SelectProductfromResults("MacBook Pro");

		Assert.assertTrue(productspage.getProductImages() == 4);

		Map<String, String> produtcInfoMap = productspage.Productinfofeatures();
		System.out.println(produtcInfoMap);
		//Brand=Apple, Availability=In Stock,
		//exl Tax price=$2,000.00, price=$2,000.00, 
		//name=MacBook Pro, Product Code=Product 18,
		//Reward Points=800
		Assert.assertEquals(produtcInfoMap.get("name"),"MacBook Pro");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("Availability"), "In Stock");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 18");
			
	}
	@Test(priority=2)
	public void verifyProductInfoTest_IMac() {
		String productName = "iMac";

		Assert.assertTrue(accountspage.doSearch(productName));

		productspage = accountspage.SelectProductfromResults("iMac");

		Assert.assertTrue(productspage.getProductImages() == 3);

		Map<String, String> produtcInfoMap = productspage.Productinfofeatures();
		System.out.println(produtcInfoMap);
	//	Brand=Apple, Availability=In Stock, exl Tax price=$100.00, price=$100.00, name=iMac, Product Code=Product 14}

		
		Assert.assertEquals(produtcInfoMap.get("name"),"iMac");
		Assert.assertEquals(produtcInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(produtcInfoMap.get("Product Code"), "Product 14");
			
	}
	@Test(priority=3)
	public void VerifyAddToCartTest() {
		productspage.AddToCart("iMac");
		
	}


}

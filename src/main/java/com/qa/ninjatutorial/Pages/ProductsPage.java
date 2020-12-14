package com.qa.ninjatutorial.Pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.ninjatutorial.Utilities.ElementUtil;
import com.qa.ninjatutorial.base.BasePage;

public class ProductsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementutil;
	private By productHeader=By.cssSelector("div#content h1");
	private By productMetadata=By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li"); 
    private By productQuantityData=By.id("#input-quantity");
    private By AddtoCart =By.xpath("//button[@id='button-cart' and @type='button']");
    private By productimages=By.cssSelector(".col-sm-8 li img");
    private By addtocartmsg=By.cssSelector(".alert  a:nth-of-type(1)");
    
    public ProductsPage(WebDriver driver) {
    	this.driver=driver;
    	elementutil=new ElementUtil(driver);		
    }
    public String getPageTitle(String productname) {
    return	elementutil.waitForTitlePresent(productname, 5);
    }
    
    public Map<String, String> Productinfofeatures() {
    	Map<String,String>productinfoMap=new HashMap<>();
    	
    	productinfoMap.put("name", elementutil.doGetText(productHeader));
    	List <WebElement>productMetaDataList=elementutil.getElements(productMetadata);
    	for(WebElement e:productMetaDataList) {
    	productinfoMap.put(e.getText().split(":")[0].trim(), e.getText().split(":")[1].trim());
    }
    	List <WebElement>productpriceList=elementutil.getElements(productPriceData);
    	productinfoMap.put("price", productpriceList.get(0).getText().trim());
    	productinfoMap.put("exl Tax price", productpriceList.get(1).getText().split(":")[1].trim());

    	return productinfoMap;
    }
    public void SelectQuantity(String quantity) {
    	elementutil.doSendKeys(productQuantityData, quantity);
    }
    public boolean AddToCart(String productname){
    elementutil.doActionsClick(AddtoCart);
	String message=elementutil.getElement(addtocartmsg).getText();
	if(message.equals(productname)) {
		return true;
	}
	return false;
		
    	
		 
    }
    public int getProductImages() {
    int imagecount=	elementutil.getElements(productimages).size();
    System.out.println("total number of images :"+imagecount);
    return imagecount;
    }
    
    
    
    
  
    	    	
   
  
    	
    }
    
    


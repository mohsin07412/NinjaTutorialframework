package com.qa.ninjatutorial.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String ACCOUNTS_LOGIN_PAGE_TITLE="Account Login";
    public static final String ACCOUNTS_PAGE_TITLE="My Account";
    public static final String ACCOUNTS_PAGE_HEADER="Your Store";
    public static final int ACCOUNTS_SECTION_VALUE= 4;
    public static final String addtocartmessage="Success: You have added MacBook to your shopping cart!"; 
    public static final String RegisterSheetName= "Sheet1";
    public static final String ACCOUNT_SUCCESS_MESSG="Your Account Has Been Created";
    
    public static  List<String> accountSectionList() {
    	List<String>accountlist=new ArrayList<String>();
    	accountlist.add("My Account");
    	accountlist.add("My Orders");
    	accountlist.add("My Affiliate Account");
    	accountlist.add("Newsletter");
    	return accountlist;
    }
}

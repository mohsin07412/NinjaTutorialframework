
package com.qa.ninjatutorial.Utilities;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	
	public OptionsManager(Properties prop) {
	this.prop=prop;	
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions co=new ChromeOptions();
		if (prop.getProperty("headless").trim().equals("true"))co.addArguments("--headless");
		if (prop.getProperty("incongnito").trim().equals("true"))co.addArguments("--incongnito");
		return co;
	}
	public FirefoxOptions getFireFoxOptions() {
		FirefoxOptions fo=new FirefoxOptions();
		if (prop.getProperty("headless").trim().equals("true"))fo.addArguments("--headless");
		if (prop.getProperty("incongnito").trim().equals("true"))fo.addArguments("--incongnito");
		return fo;
	}


}

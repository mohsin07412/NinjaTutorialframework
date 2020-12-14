package com.qa.ninjatutorial.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.ninjatutorial.Utilities.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
public WebDriver driver;
	
public 	Properties prop;
public static String highlight;


public OptionsManager optionsmanager;

public static ThreadLocal<WebDriver> tlDriver=new  ThreadLocal<WebDriver>();
	



	public WebDriver init_driver( String browser) {
		System.out.println("browser is :" +browser);
		highlight=prop.getProperty("highilight");
		
		optionsmanager=new OptionsManager(prop);
		if( browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
		//	driver=new ChromeDriver();normal launching browser
		//	tlDriver.set(new ChromeDriver() );//launching browser for extend report
			tlDriver.set(new ChromeDriver(optionsmanager.getChromeOptions()) );
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
		//	driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("safari")) {
			//driver=new SafariDriver();
			tlDriver.set(new SafariDriver());
			}
		else {
			System.out.println("plz give the right browser :" +browser);
		}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		return getDriver();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
	
	
	public Properties init_properties() {
		 prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(".\\src\\main\\java\\com\\qa\\ninjatutorial\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;		
				}
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

		
	}



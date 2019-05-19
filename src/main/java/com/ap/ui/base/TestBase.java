package com.ap.ui.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {
 
	//global envirnments variables// 
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver en_driver;  //This gives is selenium logs in our console for all the actions it performs//
	public static WebEventListener eventListener;   //this allows us to generete extendreports with the help of listeners class//
	
	
	//constructor to inniciliazed the variabels// 
	public TestBase() throws Exception {
		
		prop = new Properties(); //object for my properties file//
    	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\ap\\ui\\config\\config.properties");
    	prop.load(fis);  //loading the file in the object I created//
    	
		
	} 
	
    public static void initialization() throws Exception {
		
    	
    	String browserName = prop.getProperty("browser"); //holding in string and named it browserName
    	if(browserName.equalsIgnoreCase("chrome")) {
    		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\resources\\drivers\\chromedriver.exe");
			 driver = new ChromeDriver();
    	}
    	else if(browserName.equalsIgnoreCase("firefox")) {
    		System.setProperty("webdriver.gecko.driver", "C:\\Users\\abidk\\Desktop\\geckodriver.exe");
			 driver = new FirefoxDriver();
    	}
    	else if(browserName.equalsIgnoreCase("IE")) {
    		System.setProperty("webdriver.InternetExplorerDriver.driver", "C:\\Users\\abidk\\Desktop\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(); 
    	}
    	
    	//creating object for action thats occuring and sharing with driver
    	en_driver = new EventFiringWebDriver(driver);
    	//creating object of WebEventListner to register it with eventFirignWebDriver
    	eventListener = new WebEventListener();
    	//event can be captured based on the method we create WebEventListener class
    	en_driver.register(eventListener);
    	//since we drive object is for browser en_driver is for event,
    	//we are declaring with equal to each when they are exchaning the info//
    	driver = en_driver;
    	
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.get(prop.getProperty("url"));
    	
    	
    	
	

}
    
    
	
    
   

}
    
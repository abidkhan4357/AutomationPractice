package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ap.ui.base.TestBase;

public class TestUtil extends TestBase{
	
	
	public TestUtil() throws Exception {
		super();

	}

	
	public static Workbook book;
	public static Sheet sheet;
	public static long IMPLICIT_WAIT = 10; 
	public static long Page_Load = 10;
	public static String XL_SHEET_PATH = System.getProperty("user.dir")+ "\\src\\main\\resources\\testdata\\TestData.xlsx";
	public static JavascriptExecutor js;

	
	
	//this method is return 2 dimention array//
	public static void getTestData(String sheetName) throws Exception{
		
		FileInputStream file = null;
		
		file = new FileInputStream(XL_SHEET_PATH);
		
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet(sheetName);
		
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
	
	}
		
	

	//screenshot method//
	public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException
	{    
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDirect = System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(currentDirect + "/screenshot"+screenshotName + System.currentTimeMillis()+ ".png")); //using . gives the path at project level and I create da folder for called Screenshot to save it in my parametized String. 
		//so it will not override and delete old screenshots//  
	}
	
	
	//Jquery(JavaScript) this is used when the developer uses the Jquery this will get the Jquery to run the script//
	//the logic behind this method, is I want to capture any response when running our script//
	//this will create a file in my project where it creates a app log folder and it shows all your logs during run time//
	//so this is helpfull when the developer needs to check some error he can look at this log// 
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver; 
		
		//telling the script go the website and run the jquery//
		//1.gets the document for jquery//
		//2.gets the api for jquery form url//
		//3.
		//4.we need to wait at least some time to get the dependecies and load it that why we have the thread.sleep//
		js.executeScript("if (!windows.JQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript':"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js':"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(6000);	
	
		//this creates the log within the script// It takes it form the dev tools from the Network the HEADER response it captures the info
	   //and gets the response from the test case// //We can provide this info to the developer when reporting the bug///
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

				
				js.executeScript("$('head').append('<link rel=\"stylesheet\" "
						+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
				Thread.sleep(6000);
		
				//We are getting the info by using GET form the website//
				js.executeScript("$ growl({title: 'GET' , message: '/'});");
				   
				//if else statement we use because we want to separate the information form error, notice message, or a warning//
				//we always was to segregate this so it is easier to read//
					if(messageType.equals("error")) {
					   js.executeScript("$growl.error({ title: 'Error' message: '"+message+"'});");
				   }else if(messageType.equals("info")) {
					   js.executeScript("$growl.error({ title: 'Notice', message: 'your notice message will appear here'});");
				   }else if(messageType.equals("warning")) {
					   js.executeScript("$growl.warning({ title: 'Warning!!', message: 'your warning message will appear here'});");
				   }else
					   
					    System.out.println("Show NO Error Message");
				   }
	
	



}
	


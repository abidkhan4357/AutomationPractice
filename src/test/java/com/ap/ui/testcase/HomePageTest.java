package com.ap.ui.testcase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.util.TestUtil;

public class HomePageTest extends TestBase{
	public static LoginPage loginPage;      
	public static HomePage homePage; 
	public static TestUtil testutil;
	
	//constructor of homepageTest, so i can call my constructor using super keyword, so TestBase call will 
		//and my properties will be innizilized//
		public HomePageTest() throws Exception {
			super();
			
		}


		
		//first I inizilized and then I had to access homepage methods//
		@BeforeMethod
		public void setUp() throws Exception{
			initialization(); 
			testutil = new TestUtil();
			loginPage = new LoginPage(); 
			homePage = new HomePage(); //created to object to access to methods
		}
		
	
	@Test(priority=1)
	public void searchPageTest() throws Exception {
		homePage = new HomePage();
		homePage.searchProduct("Dress");
		
	}
		
	
	@Test(priority=2)
	public void SignntTest() throws Exception {
		homePage.ClickSignBtn();
		
	}
	
	@Test
	public void getTestDataTest() throws Exception {
		TestUtil.getTestData("Sheet1");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
}

package com.ap.ui.testcase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.SearchPage;

public class SearchItemTest extends TestBase{
		
	LoginPage loginpage;
	HomePage  homepage;
    SearchPage searchPage;
    
	
	
	public SearchItemTest() throws Exception {
		super();
		
	}

	
	
	@BeforeMethod
	public void setUpdriver() throws Exception {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		

	}
	
	
	
	@Test(priority=3)
	public void testSearchItem() throws Exception {
		String product = "Evening";
		homepage.ClickSignBtn();
		homepage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = homepage.searchProduct("Evening");
		String header = searchPage.getHeader();
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		homepage.logOut();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
		
	

		

}

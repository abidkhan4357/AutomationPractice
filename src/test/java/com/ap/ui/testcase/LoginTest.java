package com.ap.ui.testcase;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.util.TestUtil;

public class LoginTest extends TestBase{
		 LoginPage loginPage;  //declared LoginPage variables globally 
		 TestUtil testutils;
		  HomePage homepage;
		 
	//crated a constructor too use the varieables inside login page//
	public LoginTest() throws Exception {
		super();
		
	}
	
	
	@BeforeTest
	public void setup() throws Exception {
		initialization();
		loginPage = new LoginPage(); //created to object to access to methods
	}
	
	@Test(priority=1)
	public void validateUserIDTest() {
		Assert.assertTrue(loginPage.validateUserID());
	}
	
	@Test(priority=2)
	public void validateAPIImageTest() {
		Assert.assertTrue(loginPage.validateAPIImage());
	}

	
	@Test(priority=3)    //passing my username and password from my properties file/ and this returns me to homepage to I made it equal to homepage variable//
	public void validateLoginTest() throws Exception {
		homepage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password")); 
	
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	


}

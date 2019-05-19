package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.ProductDetailPage;
import com.ap.ui.pages.SearchPage;

public class AddWishlistTest extends TestBase{
	
LoginPage loginpage;
HomePage  homepage;
SearchPage searchPage;
ProductDetailPage productdetailsPage;





public AddWishlistTest() throws Exception {
	super();
	
}



@BeforeMethod
public void setUpdriver() throws Exception {
	initialization();
	loginpage = new LoginPage();
	homepage = new HomePage();
	

	
	
}



@Test
public void testAddProductToWishList() throws Exception {

	String product = "Printed Chiffon Dress";
	homepage.ClickSignBtn();
	homepage = loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	searchPage = homepage.searchProduct(product);
	String header = searchPage.getHeader();
	Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
	
	
	productdetailsPage.clickAddWishListButton();
	productdetailsPage.verifyAddWishListMsg();
	homepage.logOut();
	
}



@AfterMethod
public void tearDown() {
	driver.quit();
}





}

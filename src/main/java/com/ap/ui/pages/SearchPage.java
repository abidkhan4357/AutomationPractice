package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class SearchPage  extends TestBase{

	@FindBy(xpath="//input[contains(@id,'search_query_top')]")
	WebElement searchBox;
	
	
	@FindBy(xpath="//span[contains(.,'Add to cart')]")
	WebElement addtwoCart;
	
	@FindBy(xpath="//span[contains(.,'Proceed to checkout')]")
	WebElement proccedToCheckout;
	
	@FindBy(xpath="(//a[contains(.,'Printed Dress')])[3]")
	WebElement searchHeading;
	
	
	
	//created the constructor to access its super class methods//
	//used pagefactory to innilize the @Finby Webelements
	public SearchPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
	public ProductDetailPage selectProdcut(String productName) throws Exception {
		
		String locator = "[class='product-name'][title='" + productName + "']";
				driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailPage();
				
	}
	
	public String getHeader() {
		return  searchHeading.getText();
		
	}
	
	

	
		
	
	
	
		
}

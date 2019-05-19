package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailPage extends TestBase{

	@FindBy(css= "#color_13")
	WebElement qualityInput;
	
	@FindBy(xpath = "(//a[contains(@title,'Casual Dresses')])[1]")
	WebElement CasualDressOptn;
	
	@FindBy(id="group_1")
	WebElement sizeDropDown;
	
	@FindBy(xpath = "//span[contains(.,'Add to cart')]")
	WebElement AddtoCart;
	
	@FindBy(xpath = "//span[contains(.,'Proceed to checkout')]")
	WebElement ProccedtoCheckOut;
	
	@FindBy(xpath = "//a[@id='wishlist_button']")
	WebElement AddtoWish;
	
	@FindBy(xpath = "//a[@href='javascript:;']")
	WebElement AddtoWishCloseBtn;
	
	
	public ProductDetailPage() throws Exception {
		super();
		PageFactory.initElements(driver, this); //this means its pointing to the current class section//
		
	}
	

	public void verifyAddWishListMsg() {
		Assert.assertEquals(AddtoWish.getText(), "Added to your wishlist");
		AddtoWishCloseBtn.click();
		
	}
	
	
	public ProductDetailPage selectProductColor(String color) {
		String locator = "[name='"+color+"']"; //holding the color dynamic by whatever we pass from excel//
		driver.findElement(By.cssSelector(locator)).click();   //locator is our css locator
		return this;
	}
		
	
	public ProductDetailPage inputQuantityColor(String quantity) {
		qualityInput.click();
		qualityInput.sendKeys(quantity);
		return this;
	}
	
	public ProductDetailPage selectSize(String size) {
		 Select select = new Select(sizeDropDown);
				 select.selectByVisibleText(size);
				 return this;
	}
	
	
	public ProductDetailPage clickAddWishListButton() {
		 AddtoWish.click();
		 return this;
			

	}
	
	
	public OrderSummaryPage proceedCheckOut() throws Exception {
		ProccedtoCheckOut.click();
		return new OrderSummaryPage();
	
		
	}
	
	}
	
	



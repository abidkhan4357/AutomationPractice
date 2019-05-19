package com.ap.ui.pages;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase{

	
	//object for login, contact btn, searchfield, sumbit search, logout//
	
	//create method for searchpage, SignIN, contactbnt, Logout//
	
	
	@FindBy(xpath="//a[@title='Log in to your customer account']")
	WebElement SignInBtn;
	
	@FindBy(xpath = "//a[contains(@title,'Contact Us')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//input[contains(@id,'search_query_top')]")
	WebElement searchField;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?mylogout=']")
	WebElement SignOut;
	
	
	
	public HomePage() throws Exception {
		super();
		PageFactory.initElements(driver, this); //this means its pointing to the current class section//
		
	}
	
	
	
	public SearchPage searchProduct(String SearchItem) throws Exception {
		searchField.sendKeys(SearchItem);
		return new SearchPage();
		
	}
	
	public LoginPage ClickSignBtn() throws Exception {
		SignInBtn.click();
		return new LoginPage(); //after clicking on login in it returns me to login page, so I have create an object//
		
	}
	
	public ContactsPage validatecontactsLink() throws Exception {
		contactsLink.click();
		return new ContactsPage();  //after clicking on contacts link returns contatcs page//
	}
	
	
	public LoginPage validateSignout() throws Exception {
		SignOut.click();
		return new LoginPage(); //when clicking on signout it stays on login page//
		
	}
	
	public void logOut() {
		SignOut.click();
	}
	
	
	
	

}

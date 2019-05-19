package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath = "//a[contains(@title,'Contact Us')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath = "//select[@id='id_contact']")
	WebElement headingdropDown;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "//textarea[@id='message']")
	WebElement messageBox;
	
	@FindBy(xpath = "//span[contains(.,'Send')]")
	WebElement sendBtn;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement successMsg;

	
	
	public ContactsPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
	}

		
	public ContactsPage fillContatcsForm(String heading, String email, String message) {
			Select select = new Select(headingdropDown);
			select.selectByVisibleText(heading);
			emailInput.sendKeys(email);
			messageBox.sendKeys(message); 
			return this; //this is the same as   return new ContactsPage(); 
		
		
	}
	
	public String  getMessage() {
		return successMsg.getText();
		
	}
	
	public void submitMessage() {
		sendBtn.click();
	}
	
	
	
	

}

package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ap.ui.base.TestBase;

public class OrderSummaryPage extends TestBase{

	@FindBy(xpath = "(//span[contains(.,'Proceed to checkout')])[2]")
	WebElement proccesscheckoutbtn;
	
	@FindBy(xpath = "//input[@id='cgv']")
	WebElement termsandCondition;
	
	
	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//span[contains(.,'I confirm my order')]")
	WebElement OrderConfirm;
	
	@FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement ConfirmMsg;
	

	
	public OrderSummaryPage() throws Exception {
		super();
		
	}
	
	public OrderSummaryPage proccesscheckout() {
		proccesscheckoutbtn.click();
		return this;
	}
	
	public OrderSummaryPage procceedAddressCheckout() {
		proccesscheckoutbtn.click();
		return this;
		
	} 
	
	public OrderSummaryPage proceedShipping() {
		termsandCondition.click();
		proccesscheckoutbtn.click();
		return this;
	}
	
	public OrderSummaryPage cofirmOrder() {
		payByBankWire.click();
		OrderConfirm.clear();
		return this;
	}
	
	
	public String getConfirmationMessage() {
		return ConfirmMsg.getText();
	}
	
	

}

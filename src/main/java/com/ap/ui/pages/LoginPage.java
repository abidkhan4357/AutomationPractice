package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;


public class LoginPage  extends TestBase{

	
	//page factory//
	
	@FindBy(id="email")
	WebElement emailfield;
	
	@FindBy(id="passwd")
	WebElement paswrdfield;
	
	@FindBy(id="SubmitLogin")
	WebElement sumbitbnt;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement UserId;
	
	
	@FindBy(xpath="//img[@src='http://automationpractice.com/img/logo.jpg']")
	WebElement apLogo;
	
	
	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this); // We are innilizing the Webelements, and passing our driver 
												//and usig this keyword means its pointing to the current class section and also pointing to 
												//Webelements and turning them into driver.findElements//	
	}
	
	
	
	public boolean validateUserID() {
		return apLogo.isDisplayed();
		
	}
	

	 public boolean validateAPIImage() {
		 return apLogo.isDisplayed();
		 
	 }
	 
	 
		public HomePage validateLogin(String emil, String psswrd) throws Exception {
			emailfield.sendKeys(emil);
			paswrdfield.sendKeys(psswrd);
			sumbitbnt.click();
			
			 return new HomePage(); //next landing page///
			
		}
	

	
}


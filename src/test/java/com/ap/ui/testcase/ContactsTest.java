package com.ap.ui.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactsTest  extends TestBase{
  ContactsPage contactspage;
  HomePage  homepage;
	
	
	public ContactsTest() throws Exception {
		super();

	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization(); 
		contactspage = new ContactsPage();
		homepage  = new HomePage();
		
	}
	
	
	@Test
	public void tetsContacts() throws Exception {
		homepage.validatecontactsLink();
		contactspage  = contactspage.fillContatcsForm("Customer service", "johnsmith@aol.com", "This is test purpose");
		contactspage.submitMessage();
		
		contactspage.getMessage();
		String succesmsg = contactspage.getMessage();
		Assert.assertEquals(succesmsg, "Your message has been successfully sent to our team.");

	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package tests;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPageWtihDirectWay;
import pages.ContactUsPageWtihRobotWay;
import pages.HomePage;

public class ContactUs_happyScenario extends TestBase {
	HomePage homeObject;
	ContactUsPageWtihRobotWay contactUsObject;
	
	@Test
	public void testContactUs_WithAllVaildFields() throws InterruptedException, AWTException {
		homeObject = new HomePage(driver);
		contactUsObject = new ContactUsPageWtihRobotWay(driver);
		
		homeObject.openContactUsPage();
		Assert.assertEquals(contactUsObject.contactUsMessage.getText(), "GET IN TOUCH");
		Thread.sleep(3000);
		
		contactUsObject.userCanContactUs("Abdelrahman Osama", "abdelrahman@gmail.com", "Complain", "my order doesn't deliver yet");
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		Assert.assertEquals(alert.getText(), "Press OK to proceed!");
		
		alert.accept();
		Thread.sleep(3000);
		Assert.assertTrue(contactUsObject.successMessage.getText().contains("Success! Your details have been submitted successfully."));
	}

}

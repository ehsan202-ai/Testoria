package tests;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ContactUsPageWtihRobotWay;
import pages.HomePage;

public class ContactUs_NegativeScenario extends TestBase {

    HomePage homeObject;
    ContactUsPageWtihRobotWay contactUsObject;

    // ==========================
    // 🔹 DataProvider للحالات السلبية
    // ==========================
    @DataProvider(name = "invalidContactUsData")
    public Object[][] invalidData() {
        return new Object[][] {
            {"", "abdelrahman@gmail.com", "Complain", "Message here", "Please enter your name!"},
            {"Abdelrahman", "", "Complain", "Message here", "Please enter your email!"},
            {"Abdelrahman", "not-an-email", "Complain", "Message here", "Invalid email address!"},
            {"Abdelrahman", "abdelrahman@gmail.com", "", "Message here", "Please enter subject!"},
            {"Abdelrahman", "abdelrahman@gmail.com", "Complain", "", "Please enter your message!"}
        };
    }

    // ==========================
    // 🔹 Negative Test Using DataProvider
    // ==========================
    @Test(dataProvider = "invalidContactUsData")
    public void testContactUs_NegativeCases(String name, String email, String subject, String message,
                                            String expectedAlert) throws InterruptedException, AWTException {

        SoftAssert soft = new SoftAssert();

        homeObject = new HomePage(driver);
        contactUsObject = new ContactUsPageWtihRobotWay(driver);

        homeObject.openContactUsPage();
        soft.assertEquals(contactUsObject.contactUsMessage.getText(), "GET IN TOUCH",
                "Page header mismatch");

        Thread.sleep(2000);

        // Fill invalid data
        contactUsObject.userCanContactUs(name, email, subject, message);

        Thread.sleep(2000);

        // Read alert
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();

        soft.assertEquals(actualAlertText, expectedAlert,
                "Alert message mismatch for invalid input");

        alert.accept();

        soft.assertAll();
    }
}

    

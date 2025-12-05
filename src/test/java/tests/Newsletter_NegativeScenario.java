package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.NewsletterPage;
import pages.HomePage;

public class Newsletter_NegativeScenario extends TestBase {

    @Test(dataProvider = "newsletterData", dataProviderClass = data.NewsletterData.class)
    public void testNewsletter_Negative(String email, String expectedMessage) {
        // ننفذ فقط الحالات اللي فيها خطأ
        if (expectedMessage.contains("Success!")) return;

        SoftAssert soft = new SoftAssert();

        HomePage home = new HomePage(driver);
        NewsletterPage newsletter = new NewsletterPage(driver);

        home.openHomePage();
        newsletter.subscribe(email);

        soft.assertEquals(newsletter.messageText.getText(), expectedMessage);
        soft.assertAll();
    }
}

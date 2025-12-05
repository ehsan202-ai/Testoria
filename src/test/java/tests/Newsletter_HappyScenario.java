package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewsletterPage;
import pages.HomePage;

public class Newsletter_HappyScenario extends TestBase {

    @Test(dataProvider = "newsletterData", dataProviderClass = data.NewsletterData .class)
    public void testNewsletter_Happy(String email, String expectedMessage) {
        // ننفذ فقط الحالة الناجحة
        if (!expectedMessage.contains("Success!")) return;

        HomePage home = new HomePage(driver);
        NewsletterPage newsletter = new NewsletterPage(driver);

        home.openHomePage();
        newsletter.subscribe(email);

        Assert.assertEquals(newsletter.messageText.getText(), expectedMessage);
    }
}

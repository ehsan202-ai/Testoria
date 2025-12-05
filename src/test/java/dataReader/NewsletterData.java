package dataReader;

import org.testng.annotations.DataProvider;

public class NewsletterData {

    @DataProvider(name = "newsletterData")
    public static Object[][] getData() {
        return new Object[][] {
            // Email, Expected Message
            {"user@example.com", "Success! You are subscribed."}, // Happy
            {"", "Please enter your email!"},                    // Negative
            {"not-an-email", "Invalid email address!"}           // Negative
        };
    }
}

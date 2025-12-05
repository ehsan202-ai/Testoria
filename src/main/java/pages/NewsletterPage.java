package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsletterPage {
    WebDriver driver;

    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "newsletterEmail")
    public WebElement emailField;

    @FindBy(id = "subscribeButton")
    public WebElement subscribeButton;

    @FindBy(id = "newsletterMessage")
    public WebElement messageText;

    public void subscribe(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        subscribeButton.click();
    }
}

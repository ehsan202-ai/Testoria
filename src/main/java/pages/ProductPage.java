package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends PageBase {

    private WebDriverWait wait; 

    public ProductPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
    WebElement addtocartBtn;

    @FindBy(xpath = "//*[@id='cartModal']/div/div/div[3]/button")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[@id='cartModal']/div/div/div[2]/p[2]/a/u")
    WebElement viewCartBtn;

    @FindBy(id = "cartModal")
    WebElement cartModal;

 
 
    public void addProductToCart(String productName) {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + productName + "']/following-sibling::a[contains(@class,'add-to-cart')]")));
        addBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
        WebElement viewCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cartModal']//u[text()='View Cart']")));
        viewCartBtn.click();
    }
    
    public void ClickviewCart() {
		viewCartBtn.click();
	}
    
}

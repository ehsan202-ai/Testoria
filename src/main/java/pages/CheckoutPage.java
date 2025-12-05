package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
	 WebElement viewcartBtn;
	
	@FindBy(xpath = "//*[@id=\"do_action\"]/div[1]/div/div/a")
	WebElement ProceesToCheckoutBtn;
	
	@FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
	WebElement RegisterorLoginBtn;
	
	@FindBy(xpath = "//*[@id=\"ordermsg\"]/textarea")
	WebElement commentTextArea;
	
	//@FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	//WebElement placeOrderBtn;
	
	@FindBy(css = "a.btn.btn-default.check_out")
	WebElement placeOrderBtn;

	
	@FindBy(name = "name_on_card")
	public WebElement nameOnCardTxt;
	
	@FindBy(name = "card_number")
	public  WebElement cardNumberTxt;
	
	@FindBy(name = "cvc")
	public WebElement CVCTxt;
	
	@FindBy( name="expiry_month")
	public WebElement ExpirationMonthTxt;
	
	@FindBy(name = "expiry_year")
	public WebElement ExpirationYearTxt;
	
	@FindBy(id = "submit")
	WebElement payAndConfirmOrderBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p")
	public WebElement Successmassage;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/a")
	WebElement downloadInvoiceBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
	WebElement continueBtn;
	
	
	public void openCart() {
		viewcartBtn.click();
	}
	
	
	public void clickProceesToCheckout() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.check_out")));
	    checkoutBtn.click();
	}
	
	public void clickRegisterorLogin() {
		RegisterorLoginBtn.click();	
	}
	
	public void enterComment(String comment) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ordermsg']/textarea")));
        textArea.sendKeys(comment);
	}
	
	public void clickPlaceOrder() {
		placeOrderBtn.click();
	}
	
	public void enterPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
		nameOnCardTxt.sendKeys(name);
		cardNumberTxt.sendKeys(cardNumber);
		CVCTxt.sendKeys(cvc);
		ExpirationMonthTxt.sendKeys(month);
		ExpirationYearTxt.sendKeys(year);
	}
	public void confirmPayment() {
		payAndConfirmOrderBtn.click();
	}
	public void downloadInvoice() {
		downloadInvoiceBtn.click();
	}
	public void clickcontinue() {
		continueBtn.click();
	}
}

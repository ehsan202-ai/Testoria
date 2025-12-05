package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(linkText = "Proceed To Checkout")
	 WebElement ProceesToCheckoutBtn;
	
	@FindBy(css = "td.cart_description h4 a")
	 WebElement cartDescription;
	

	public void ProceesToCheckout() {
		ProceesToCheckoutBtn.click();
	}
	public boolean isProductDisplayedInCart() {
	    return cartDescription.isDisplayed();
	}
}

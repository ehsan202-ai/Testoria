package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.RegisterPage;

public class Download_Invoice_after_purchase_order extends TestBase {

    @Test
    public void testDownloadInvoiceAfterPurchase() throws InterruptedException {

     
        HomePage home = new HomePage(driver);
        home.openHomePage();
        Assert.assertTrue(home.homeBtn.isDisplayed(), "Home page not visible!");

        
        LoginPage login = new LoginPage(driver);
        home.openLoginPage();
        login.userCanLogin("ahmedTest0@example.com","12345678");


        RegisterPage register = new RegisterPage(driver);
        Assert.assertTrue(register.logoutBtn.isDisplayed());


        ProductPage product = new ProductPage(driver);
        product.addProductToCart("Men Tshirt");


        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayedInCart());
        cart.ProceesToCheckout();

   
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterComment("This is my first order");
        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("AhmedHassan","4111111111111111","123","12","2026");
        checkout.confirmPayment();
        Assert.assertTrue(checkout.Successmassage.isDisplayed());


        checkout.downloadInvoice();
        checkout.clickcontinue();
    }
}

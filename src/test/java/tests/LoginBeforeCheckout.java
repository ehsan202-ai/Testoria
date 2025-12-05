package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.RegisterPage;

public class LoginBeforeCheckout extends TestBase {

    @Test
    public void testLoginBeforeCheckout() throws InterruptedException {

 
        HomePage home = new HomePage(driver);
        home.openHomePage();
        Assert.assertTrue(home.homeBtn.isDisplayed(), "Home page not opened!");


        LoginPage login = new LoginPage(driver);
        home.openLoginPage();
        Assert.assertEquals(login.loginMessage.getText(), "Login to your account");
        login.userCanLogin("ahmedTest0@example.com", "12345678");

 
        RegisterPage register = new RegisterPage(driver);
        Assert.assertTrue(register.logoutBtn.isDisplayed(), "User is NOT logged in!");

 
        ProductPage product = new ProductPage(driver);
        product.addProductToCart("Blue Top");


        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isProductDisplayedInCart(), "Product not visible in cart!");
        cart.ProceesToCheckout();

   
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterComment("This is my first order");
        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("AhmedHassan", "4111111111111111", "123", "12", "2026");
        checkout.confirmPayment();
        Assert.assertTrue(checkout.Successmassage.isDisplayed(), "Order was NOT placed successfully!");

      
       // register.deleteAccount();
        //Assert.assertEquals(register.deleteSuccessMessage.getText(), "ACCOUNT DELETED!");
        
        register.userCanContinue();
    }
}

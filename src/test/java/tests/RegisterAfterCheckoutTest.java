package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.ProductPage;
import pages.CheckoutPage;
import pages.CartPage;

public class RegisterAfterCheckoutTest extends TestBase {

    @Test
    public void testRegisterBeforeCheckout() throws InterruptedException {


        HomePage home = new HomePage(driver);
        home.openHomePage();
        Assert.assertTrue(home.homeBtn.isDisplayed(), "Home page not opened!");

        home.openRegisterPage();
        RegisterPage register = new RegisterPage(driver);

        register.userCanSignUpNewUser("Ahmed", "ahmedTest27@example.com");
        Assert.assertEquals(register.enterAccountMessage.getText(), "ENTER ACCOUNT INFORMATION");
  
        
        register.userCanEnterAccountInformation(
                "123456789", "15", "September", "1995",
                "Ahmed", "Hassan", "Company",
                "Street 5", "Cairo",
                "United States", "NewYork",
                "TestAddress", "12345", "01000000000");
        
        Assert.assertEquals(register.successMessage.getText(), "ACCOUNT CREATED!");
        register.userCanContinue();
        

        Assert.assertTrue(register.logoutBtn.isDisplayed(), "User not logged in!");

        
        ProductPage product = new ProductPage(driver);
        product.addProductToCart("Grunt Blue Slim Fit Jeans");
        
        CartPage cart = new CartPage(driver);

        
        Assert.assertTrue(cart.isProductDisplayedInCart(), "Cart page is not displayed!");

        cart.ProceesToCheckout();


        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterComment("This is my first order");
        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("Ahmed Hassan","4111111111111111","123","12","2026");        
        checkout.confirmPayment();
        Assert.assertTrue(checkout.Successmassage.isDisplayed(),"Order was NOT placed successfully!");

        register.deleteAccount();
        Assert.assertEquals(register.deleteSuccessMessage.getText(), "ACCOUNT DELETED!");

        register.userCanContinue();
    }
}

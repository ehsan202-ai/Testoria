package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import pages.RegisterPage;

public class RegisterBeforeCheckoutTest extends TestBase { 

    @Test
    public void registerBeforeCheckout() {
        HomePage home = new HomePage(driver);
        home.openHomePage();

        ProductPage product = new ProductPage(driver);
        product.addProductToCart("Men Tshirt");
        
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.clickProceesToCheckout();
        checkout.clickRegisterorLogin();

        
        RegisterPage register = new RegisterPage(driver);
        register.userCanSignUpNewUser("Ahmed", "ahmedTest27@example.com");
        
        
        
        register.userCanEnterAccountInformation(
                "12345678", "15", "September", "1995",
                "Ahmed", "Hassan", "Company",
                "Street 5", "Cairo",
                "United States", "NewYork",
                "TestAddress", "12345", "01000000000");
               
       
        Assert.assertEquals(register.successMessage.getText(), "ACCOUNT CREATED!");
        register.userCanContinue();
        
  
        Assert.assertTrue(register.logoutBtn.isDisplayed(), "User is not logged in!");

        
        home.openHomePage();
        
        product.addProductToCart("Men Tshirt");
        
        checkout.clickProceesToCheckout();
        checkout.enterComment("This is my first order");
        checkout.clickPlaceOrder();
        checkout.enterPaymentDetails("Ahmed Hassan", "4111111111111111", "123", "12", "2025");
        checkout.confirmPayment();
        Assert.assertTrue(checkout.Successmassage.isDisplayed(), "Order not confirmed!");

        checkout.downloadInvoice();
        checkout.clickcontinue();
        
        
        register.deleteAccount();
        Assert.assertEquals(register.deleteSuccessMessage.getText(), "ACCOUNT DELETED!");
        
        checkout.clickcontinue();
        
    }
}


package hometask;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import hometask.CartPage;
import hometask.HomePage;
import hometask.LoginPage;

public class CartRemovalTest extends BaseTest {

    @Test(description = "Verify that items can be removed from cart and count updates correctly")
    public void verifyCartItemRemoval() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(0);
        homePage.addProductToCart(1);
        homePage.goToCart();

        CartPage cartPage = new CartPage(driver);
        int beforeRemoval = cartPage.getCartItemCount();

        cartPage.removeItem(0);
        int afterRemoval = cartPage.getCartItemCount();
             
        Assert.assertEquals(afterRemoval, beforeRemoval - 1,
                "Cart item removal did not update the count correctly.");
    
        System.out.println("Cart item removed successfully! Count updated from " + beforeRemoval + " to " + afterRemoval);
    }
}

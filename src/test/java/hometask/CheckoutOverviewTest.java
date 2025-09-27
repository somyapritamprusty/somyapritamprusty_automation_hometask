package hometask;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import hometask.*;

public class CheckoutOverviewTest extends BaseTest {

    @Test(description = "Verify that Checkout Overview page displays correct product and pricing details")
    public void verifyCheckoutOverviewDetails() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(0);
        homePage.goToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterCheckoutInfo("John", "Doe", "12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);

        Assert.assertTrue(overviewPage.getSubtotalText().contains("Item total"),
                "Subtotal not displayed correctly on overview page.");
        Assert.assertTrue(overviewPage.getTaxText().contains("Tax"),
                "Tax not displayed on overview page.");
        Assert.assertTrue(overviewPage.getTotalText().contains("Total"),
                "Total not displayed on overview page.");

        System.out.println("Checkout Overview displayed successfully!");
    }
}

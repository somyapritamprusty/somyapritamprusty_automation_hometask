package hometask;

import org.testng.Assert;
import org.testng.annotations.Test;
import hometask.HomePage;
import hometask.LoginPage;
import java.util.Collections;
import java.util.List;


public class SortingTest extends BaseTest {

    @Test(description = "Verify products are sorted by Price: Low to High and High to Low")
    public void testProductSorting() {
    // Login once
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");

    HomePage homePage = new HomePage(driver);

    // --- Price: Low to High ---
    homePage.selectSortOption("Price (low to high)");
    List<Double> actualPricesLowToHigh = homePage.getProductPrices();
    List<Double> expectedPricesLowToHigh = actualPricesLowToHigh.stream().sorted().toList();
    Assert.assertEquals(actualPricesLowToHigh, expectedPricesLowToHigh,
            "Products are not sorted correctly by price (Low to High).");
    System.out.println("Products sorted correctly by Price: Low to High");

    // --- Price: High to Low ---
    homePage.selectSortOption("Price (high to low)");
    List<Double> actualPricesHighToLow = homePage.getProductPrices();
    List<Double> expectedPricesHighToLow = actualPricesHighToLow.stream()
                                                               .sorted(Collections.reverseOrder())
                                                               .toList();
    Assert.assertEquals(actualPricesHighToLow, expectedPricesHighToLow,
            "Products are not sorted correctly by price (High to Low).");
    System.out.println("Products sorted correctly by Price: High to Low");
    }
}

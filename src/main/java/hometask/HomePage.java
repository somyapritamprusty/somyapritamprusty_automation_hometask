package hometask;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;
    private final By sortDropdown = By.className("product_sort_container");
    private final By productPrices = By.className("inventory_item_price");
    private final By addToCartButtons = By.cssSelector(".btn.btn_primary.btn_small.btn_inventory");
    private final By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        AlertUtils.acceptAlertIfPresent(driver, 5);
    }

    public void selectSortOption(String option) {
        Select sort = new Select(driver.findElement(sortDropdown));
        sort.selectByVisibleText(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        System.out.println("Selected sort option: " + option);
    }

    public List<Double> getProductPrices() {
        List<WebElement> prices = driver.findElements(productPrices);
        List<Double> values = new ArrayList<>();
        for (WebElement price : prices) {
            values.add(Double.parseDouble(price.getText().replace("$", "")));
        }
        return values;
    }

    public void addProductToCart(int index) {
        driver.findElements(addToCartButtons).get(index).click();
        System.out.println("Added product at index " + index + " to cart.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

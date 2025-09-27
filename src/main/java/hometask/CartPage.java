package hometask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    private final By cartItems = By.className("cart_item");
    private final By removeButtons = By.xpath("//button[contains(text(),'Remove')]");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeItem(int index) {
        driver.findElements(removeButtons).get(index).click();
        System.out.println("Item removed from cart.");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
        System.out.println("Proceeded to checkout.");
    }
}

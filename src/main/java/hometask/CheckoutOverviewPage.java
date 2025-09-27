package hometask;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutOverviewPage {

    private final WebDriver driver;
    private By inventoryItems = By.className("inventory_item_name"); 
    private By itemPrices = By.className("inventory_item_price");
    private final By subtotalLabel = By.className("summary_subtotal_label");
    private final By taxLabel = By.className("summary_tax_label");
    private final By totalLabel = By.className("summary_total_label");
    private By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInventoryItems() {
        System.out.println("Inventory items found: " + driver.findElements(inventoryItems).size());
        return driver.findElements(inventoryItems);
    }
    public List<WebElement> getItemPrices() {
        System.out.println("Item prices found: " + driver.findElements(itemPrices).size());
        return driver.findElements(itemPrices);
    }
    public String getSubtotalText() {
        return "Subtotal text found: " + driver.findElement(subtotalLabel).getText();
    }

    public String getTaxText() {
        return "Tax text found: " + driver.findElement(taxLabel).getText();
    }

    public String getTotalText() {
        return "Total text found: " + driver.findElement(totalLabel).getText();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }
}

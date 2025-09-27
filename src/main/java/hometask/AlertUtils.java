package hometask;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for handling browser alerts.
 */
public class AlertUtils {
    public static boolean acceptAlertIfPresent(WebDriver driver, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert detected with message: " + alert.getText());
            alert.accept(); // Click OK
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

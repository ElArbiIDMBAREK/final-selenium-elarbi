package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;
    By productTitle = By.cssSelector("span.sc-grid-item-product-title span");
    By quantityProduct = By.cssSelector(".a-dropdown-prompt");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitleInCart(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));
        return driver.findElements(productTitle).get(index).getText();
    }

    public int getQuantityProduct(int index) {
        return Integer.parseInt(driver.findElement(quantityProduct).getText());
    }

}

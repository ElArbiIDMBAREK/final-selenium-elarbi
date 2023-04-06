package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;

    By quantityButtonBy = By.cssSelector("#quantity");
    By addToCartButtonBy = By.cssSelector("#add-to-cart-button");
    By cartButtonBy = By.cssSelector("#attach-sidesheet-view-cart-button");
    By productTitle = By.cssSelector("#productTitle");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public ProductPage setQuantity(int index) {
        WebElement quantityButton = driver.findElement(quantityButtonBy);
        Select quantityDropdown = new Select(quantityButton);
        quantityDropdown.selectByIndex(index);
        return this;
    }

    public ProductPage addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonBy));
        addToCartButton.click();
        return this;
    }

    public CartPage openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartButtonBy));
        cartButton.click();
        return new CartPage(driver);
    }

}

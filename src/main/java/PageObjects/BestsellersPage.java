package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BestsellersPage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;

    By categoryButtonsBy = By.cssSelector("[role='treeitem'] a");
    By productBy = By.cssSelector("#gridItemRoot");

    public BestsellersPage(WebDriver driver) {
        this.driver = driver;
    }

    public BestsellersPage openCategory(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(categoryButtonsBy));
        List<WebElement> categoryButtons = driver.findElements(categoryButtonsBy);
        categoryButtons.get(index).click();
        return this;
    }

    public ProductPage openProduct(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        wait.until(ExpectedConditions.elementToBeClickable(productBy));
        List<WebElement> products = driver.findElements(productBy);
        products.get(index).click();
        return new ProductPage(driver);
    }

}

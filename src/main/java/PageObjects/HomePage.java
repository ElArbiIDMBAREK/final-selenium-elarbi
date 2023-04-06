package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage {

    static final int TIMEOUT_SIDE_PANEL = 5;

    WebDriver driver;
    By cookieBy = By.cssSelector("#sp-cc-accept");
    By bestsellersBy = By.cssSelector("[data-csa-c-content-id='nav_cs_bestsellers']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage closeCookiePopup() {
        driver.findElement(cookieBy).click();
        return this;
    }

    public BestsellersPage openBestsellers() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
        WebElement bestsellersButton = wait.until(ExpectedConditions.elementToBeClickable(bestsellersBy));
        bestsellersButton.click();
        return new BestsellersPage(driver);
    }

}

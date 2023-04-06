import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AmazonTest {

    public static final int HIGH_TECH_CATEGORY = 19;
    WebDriver driver;
    String urlPage = "https://www.amazon.fr";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlPage);
    }

    @Test
    public void firstAmazonTest() {
        int quantityProduct = 2;

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = homePage.closeCookiePopup()
                .openBestsellers()
                .openCategory(HIGH_TECH_CATEGORY) // index 19 for High Tech
                .openProduct(6);

        String productTitle = productPage.getProductTitle();

        CartPage cartPage = productPage.setQuantity(1)
                .addToCart()
                .openCart();


        Assert.assertEquals(cartPage.getProductTitleInCart(0), productTitle, "The product title is not '" + productTitle + "'");
        Assert.assertEquals(quantityProduct, cartPage.getQuantityProduct(0), "The quantity is not " + quantityProduct);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
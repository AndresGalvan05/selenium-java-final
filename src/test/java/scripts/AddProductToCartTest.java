package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoryMenu;
import pages.ProductSubCategoryPage;
import pages.ProductPage;
import pages.CartPage;

import java.time.Duration;

import static org.testng.Assert.*;

public class AddProductToCartTest {
    private WebDriver driver;
    private Actions actions;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
        String baseUrl = "http://magento-demo.lexiconn.com/";
        driver.get(baseUrl);
    }

    @Test(dataProvider = "products", dataProviderClass = dataProviders.ProductsData.class)
    public void testAddToCart(String subCategory, String product, String productColor, String productSize) {
        CategoryMenu categoryMenu = new CategoryMenu(driver, actions);

        ProductSubCategoryPage subCategoryPage = categoryMenu.clickMenSubCategory(subCategory);
        assertEquals(subCategoryPage.getSubCategoryPageTitle(), subCategory.toUpperCase());

        ProductPage productPage = subCategoryPage.selectProduct(product);
        assertEquals(productPage.getProductPageTitle(), product);

        productPage.selectColorAndSize(productColor, productSize);
        CartPage cartPage = productPage.addToCart();
        assertEquals(cartPage.getCartPageTitle(), "SHOPPING CART");
        assertEquals(cartPage.getProductName(product), product);

        takeScreenshot();
    }

    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception while closing the driver " + e.getMessage());
        }
    }

    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }
}
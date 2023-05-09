package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private static WebDriver driver;

    @FindBy(css = ".page-title h1")
    private WebElement cartPageTitle;

    @FindBy(css = "div.cart-totals-wrapper > div > ul > li > button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        CartPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get shopping cart page title")
    public String getCartPageTitle() {
        if (cartPageTitle.getText().equals("SHOPPING CART")) {
            return cartPageTitle.getText();
        } else {
            return null;
        }
    }

    @Step("Get product name")
    public String getProductName(String productName) {
        WebElement product = driver.findElement(By.linkText(productName.toUpperCase()));
        return product.getText();
    }

    @Step("Click checkout button")
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}

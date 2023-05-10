package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(css = ".page-title h1")
    private WebElement cartPageTitle;

    @FindBy(css = "div.cart-totals-wrapper > div > ul > li > button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get shopping cart page title")
    public String getCartPageTitle() {
        return cartPageTitle.getText();
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

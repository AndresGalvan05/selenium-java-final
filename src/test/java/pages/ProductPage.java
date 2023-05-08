package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    private static WebDriver driver;

    @FindBy(css = ".product-name .h1")
    private WebElement productTitle;

    @FindBy(id = "attribute92")
    private WebElement colorSelector;

    @FindBy(id = "attribute180")
    private WebElement sizeSelector;

    @FindBy(css = ".add-to-cart-buttons button")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        ProductPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get product title")
    public String getProductTitle() {
        return productTitle.getText();
    }

    @Step("Select color and size")
    public void selectColorAndSize(String color, String size) {
        colorSelector.click();
        new Select(colorSelector).selectByVisibleText(color);
        sizeSelector.click();
        new Select(sizeSelector).selectByVisibleText(size);
    }

    @Step("Add product to cart")
    public CartPage addToCart() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}

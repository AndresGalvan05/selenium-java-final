package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    @FindBy(css = ".product-name .h1")
    private WebElement productPageTitle;

    @FindBy(id = "attribute92")
    private WebElement colorSelector;

    @FindBy(id = "attribute180")
    private WebElement sizeSelector;

    @FindBy(css = "input[type='checkbox']")
    private WebElement checkBoxButton;

    @FindBy(css = ".add-to-cart-buttons button")
    private WebElement addToCartButton;

    @FindBy(css = ".add-to-links .link-wishlist")
    private WebElement addToWishlistButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get product title")
    public String getProductPageTitle() {
        return productPageTitle.getText();
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

    @Step("Add product to wishlist")
    public WishListPage addToWishlist() {
        addToWishlistButton.click();
        return new WishListPage(driver);
    }

    @Step("Check checkbox")
    public void checkCheckbox() {
        checkBoxButton.click();
    }
}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {
    @FindBy(css = ".page-title h1")
    private WebElement wishListPageTitle;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get wish list page title")
    public String getWishListPageTitle() {
        return wishListPageTitle.getText();
    }

    @Step("Get product name")
    public String getProductName(String productName) {
        WebElement product = driver.findElement(By.linkText(productName));
        return product.getText();
    }
}

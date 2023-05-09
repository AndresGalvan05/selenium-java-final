package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    private static WebDriver driver;

    @FindBy(css = ".page-title h1")
    private WebElement wishListPageTitle;


    private WebElement productName;

    public WishListPage(WebDriver driver) {
        WishListPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWishListPageTitle() {
        if (wishListPageTitle.getText().equals("MY WISHLIST")) {
            return wishListPageTitle.getText();
        } else {
            return null;
        }
    }

    @Step("Get product name")
    public String getProductName(String productName) {
        WebElement product = driver.findElement(By.linkText(productName));
        return product.getText();
    }
}

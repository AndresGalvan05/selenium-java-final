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
    private WebElement cartTitle;

    //table[@id='shopping-cart-table']/tbody/tr/td[2]/div
//    @FindBy(css = ".product-cart-sku")
//    private WebElement productCode;

    public CartPage(WebDriver driver) {
        CartPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get cart title")
    public String getCartTitle() {
        if (cartTitle.getText().equals("SHOPPING CART")) {
            return cartTitle.getText();
        } else {
            return null;
        }
    }

    @Step("Get product code")
    public String getProductCode(String productCode) {
        //*[@id="shopping-cart-table"]/tbody/tr[1]/td[2]/div
        //*[@id="shopping-cart-table"]/tbody/tr[3]/td[2]/div
        //*[@id="shopping-cart-table"]/tbody/tr[1]/td[2]/div/text()
        //*[@id="shopping-cart-table"]/tbody/tr[1]/td[2]/div/text()="+productCode+"
//        WebElement product = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td/div[text()='" + productCode + "']"));
//        WebElement product = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td/div/text()='" + productCode + "'"));
        WebElement product = driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr[1]/td[2]/div/text()="+productCode+""));
        return product.getText();
    }

}

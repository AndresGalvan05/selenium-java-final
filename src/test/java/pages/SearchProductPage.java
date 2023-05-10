package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {
    @FindBy(css = ".page-title h1")
    private WebElement searchPageTitle;

    public SearchProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get search page title")
    public String getSearchPageTitle(String product) {
        return searchPageTitle.getText();
    }

    @Step("Get product name")
    public String findProduct(String productName) {
        WebElement productFound = driver.findElement(By.linkText(productName));
        return productFound.getText();
    }
}

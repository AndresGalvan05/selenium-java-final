package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSubCategoryPage {
    private static WebDriver driver;

    @FindBy(css = ".page-title h1")
    private WebElement subCategoryPageTitle;

    public ProductSubCategoryPage(WebDriver driver) {
        ProductSubCategoryPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get sub category title")
    public String getSubCategoryPageTitle() {
        return subCategoryPageTitle.getText();
    }

    @Step("Select product")
    public ProductPage selectProduct(String product) {
        WebElement productElement = driver.findElement(By.linkText(product));
        productElement.click();
        return new ProductPage(driver);
    }
}

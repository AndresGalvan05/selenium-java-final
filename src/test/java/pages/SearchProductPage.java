package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchProductPage {
    private static WebDriver driver;

    @FindBy(css = ".page-title h1")
    private WebElement searchPageTitle;

    @FindBy(css = ".category-products > ul")
    private List<WebElement> products;

    public SearchProductPage(WebDriver driver) {
        SearchProductPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get search page title")
    public String getSearchPageTitle(String product) {
        if (searchPageTitle.getText().equals("SEARCH RESULTS FOR '" + product.toUpperCase() + "'")) {
            return searchPageTitle.getText();
        } else {
            return null;
        }
    }

    @Step("Get number of products")
    public int getNumberOfProducts() {
        return products.size();
    }
}

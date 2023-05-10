package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {
    @FindBy(css = ".welcome-msg")
    private WebElement welcomeMessage;

    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private WebElement accountLink;

    @FindBy(id = "search")
    private WebElement searchBar;

    @FindBy(css = "#header-account > div > ul > li.last > a[title='Log In']")
    private WebElement loginLink;

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Get welcome message")
    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    @Step("Click on Log In option")
    public LoginPage clickLogInOption() {
        accountLink.click();
        loginLink.click();
        return new LoginPage(driver);
    }

    @Step("Click on Log Out option")
    public LogOutPage clickLogOutOption() {
        accountLink.click();
        WebElement logOutButton = driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a[title='Log Out']"));
        logOutButton.click();
        return new LogOutPage(driver);
    }

    @Step("Search for a product")
    public SearchProductPage searchForProduct(String product) {
        searchBar.sendKeys(product);
        WebElement searchButton = driver.findElement(By.cssSelector("#search_mini_form > div.input-box > button"));
        searchButton.click();
        return new SearchProductPage(driver);
    }

    @Step("Clear search bar")
    public void clearSearchBar() {
        searchBar.clear();
    }
}

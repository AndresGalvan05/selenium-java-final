package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    private static WebDriver driver;

    @FindBy(css = "#header > div > div.skip-links > a.skip-link.skip-account")
    private WebElement accountLink;

    @FindBy(css = ".welcome-msg")
    private WebElement welcomeMessage;

    public HeaderPage(WebDriver driver) {
        HeaderPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on Log In option")
    public LoginPage clickLogInOption() {
        accountLink.click();
        WebElement loginLink = driver.findElement(By.linkText("Log In"));
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

    @Step("Get welcome message")
    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }
}
package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
    private static WebDriver driver;

    @FindBy(css = "div.main-container.col1-layout h1")
    private WebElement logOutMessage;

    public LogOutPage(WebDriver driver) {
        LogOutPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get log out message")
    public String getLogOutMessage() {
        return logOutMessage.getText();
    }
}

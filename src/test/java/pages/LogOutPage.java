package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {
    @FindBy(css = "div.main-container.col1-layout h1")
    private WebElement logOutMessage;

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get log out message")
    public String getLogOutMessage() {
        return logOutMessage.getText();
    }
}

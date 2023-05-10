package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "send2")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Set email and password")
    public void setEmailAndPassword(String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
    }
}

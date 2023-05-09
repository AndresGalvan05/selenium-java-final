package scripts;

import dataProviders.LoginData;
import org.testng.annotations.Test;
import pages.Header;
import pages.LogOutPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginData.class)
    public void loginTest(String email, String password, String customerName) {
        driver.get(baseUrl);
        String welcomeMessage = "Welcome, " + customerName + "!";

        Header header = new Header(driver);

        LoginPage loginPage = header.clickLogInOption();
        loginPage.setEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        assertEquals(header.getWelcomeMessage(), welcomeMessage.toUpperCase());

        takeScreenshot();

        LogOutPage logOutPage = header.clickLogOutOption();
        assertEquals(logOutPage.getLogOutMessage(), "YOU ARE NOW LOGGED OUT");
    }
}

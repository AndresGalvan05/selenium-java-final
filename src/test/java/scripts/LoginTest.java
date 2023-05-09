package scripts;

import dataProviders.LoginData;
import org.testng.annotations.Test;
import pages.Header;
import pages.LogOutPage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginData.class)
    public void loginTest(String email, String password, String customerName) {
        String welcomeMessage = "Welcome, " + customerName + "!";

        Header header = new Header(driver);

        LoginPage loginPage = header.clickLogInOption();
        loginPage.setEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        assertEquals(header.getWelcomeMessage(), welcomeMessage.toUpperCase());

        takeScreenshot();

        LogOutPage logOutPage = header.clickLogOutOption();
        assertNotNull(logOutPage.getLogOutMessage());
    }
}

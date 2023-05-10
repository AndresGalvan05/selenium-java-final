package scripts;

import dataProviders.LoginData;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Header;
import pages.LogOutPage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String baseUrl = "http://magento-demo.lexiconn.com/";
        driver.get(baseUrl);
    }
    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginData.class)
    public void loginTest(String email, String password, String customerName) {
        String expectedWelcomeMessage = "Welcome, " + customerName + "!";
        String expectedLogoutMessage = "YOU ARE NOW LOGGED OUT";

        Header header = new Header(driver);

        LoginPage loginPage = header.clickLogInOption();
        loginPage.setEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        assertEquals(header.getWelcomeMessage(), expectedWelcomeMessage.toUpperCase());

        takeScreenshot();

        LogOutPage logOutPage = header.clickLogOutOption();
        assertEquals(logOutPage.getLogOutMessage(), expectedLogoutMessage);
    }
    @AfterTest
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println("Exception while closing the driver " + e.getMessage());
        }
    }

    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }
}

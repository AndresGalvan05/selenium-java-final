package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private static WebDriver driver;

    @FindBy(css = ".page-title h1")
    private WebElement checkoutTitle;

    @FindBy(id = "billing-address-select")
    private WebElement billingAddressSelector;

    @FindBy(css = "#billing-buttons-container > button")
    private WebElement continueButton;

    @FindBy(id = "p_method_cashondelivery")
    private WebElement cashPaymentMethod;

    @FindBy(css = "#review-buttons-container > button")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        CheckoutPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get checkout title")
    public String getCheckoutTitle() {
        return checkoutTitle.getText();
    }

    @Step("Select billing address")
    public void selectBillingAddress() {
        billingAddressSelector.click();
        WebElement billingAddress = driver.findElement(By.id("billing-address-select"));
        billingAddress.click();
        continueButton.click();
    }

    @Step("Select cash payment method")
    public void selectCashPaymentMethod() {
        cashPaymentMethod.click();
        continueButton = driver.findElement(By.cssSelector("#payment-buttons-container > button"));
        continueButton.click();
    }

    @Step("Click place order button")
    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    @Step("Get order received message")
    public String getOrderReceivedMessage() {
        WebElement orderReceivedMessage = driver.findElement(By.cssSelector(".sub-title"));
        return orderReceivedMessage.getText();
    }
}

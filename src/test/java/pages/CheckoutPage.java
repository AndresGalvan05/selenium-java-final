package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(css = ".page-title h1")
    private WebElement checkoutPageTitle;

    @FindBy(css = ".sub-title")
    private WebElement thankYouMessage;

    @FindBy(id = "billing-address-select")
    private WebElement billingAddressSelector;

    @FindBy(css = "#billing-buttons-container > button")
    private WebElement billingContinueButton;

    @FindBy(css = "#payment-buttons-container > button")
    private WebElement paymentContinueButton;

    @FindBy(id = "p_method_cashondelivery")
    private WebElement cashPaymentMethod;

    @FindBy(css = "#review-buttons-container > button")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get checkout title")
    public String getCheckoutPageTitle() {
        return checkoutPageTitle.getText();
    }

    @Step("Select billing address")
    public void selectBillingAddress() {
        billingAddressSelector.click();
        WebElement billingAddress = driver.findElement(By.id("billing-address-select"));
        billingAddress.click();
        billingContinueButton.click();
    }

    @Step("Select cash payment method")
    public void selectCashPaymentMethod() {
        cashPaymentMethod.click();
        paymentContinueButton.click();
    }

    @Step("Click place order button")
    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    @Step("Get thank you for your purchase message")
    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }
}

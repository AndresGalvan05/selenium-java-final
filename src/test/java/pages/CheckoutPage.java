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
    private WebElement checkoutPageTitle;

    @FindBy(css = ".sub-title")
    private WebElement thankYouMessage;

    @FindBy(id = "billing-address-select")
    private WebElement billingAddressSelector;

    @FindBy(css = "#billing-buttons-container > button")
    private WebElement billingContinueButton;

    @FindBy(css = "#payment-buttons-container > button")
    private WebElement paymentContinueButton;

    @FindBy(css = "#shipping-method-buttons-container > button")
    private WebElement shippingContinueButton;

    @FindBy(id = "p_method_cashondelivery")
    private WebElement cashPaymentMethod;

    @FindBy(css = "#review-buttons-container > button")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        CheckoutPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Get checkout title")
    public String getCheckoutPageTitle() {
        if (checkoutPageTitle.getText().equals("CHECKOUT")) {
            return checkoutPageTitle.getText();
        } else {
            return null;
        }
    }

    @Step("Select billing address")
    public void selectBillingAddress() {
        billingAddressSelector.click();
        WebElement billingAddress = driver.findElement(By.id("billing-address-select"));
        billingAddress.click();
        billingContinueButton.click();
    }

    public void selectShippingMethod() {
        WebElement freeShipping = driver.findElement(By.id("checkout-shipping-method-load"));
        if (freeShipping != null) {
            shippingContinueButton.click();
        }
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
        if (thankYouMessage.getText().equals("THANK YOU FOR YOUR PURCHASE!")) {
            return thankYouMessage.getText();
        } else {
            return null;
        }
    }
}

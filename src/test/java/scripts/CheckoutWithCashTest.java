package scripts;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;

public class CheckoutWithCashTest extends BaseTest {
    @Test(dataProvider = "checkout", dataProviderClass = dataProviders.CheckoutData.class)
    public void testCheckoutWithCash(String email, String password, String subCategory, String product) {
        driver.get(baseUrl);

        // Login
        Header header = new Header(driver);
        LoginPage loginPage = header.clickLogInOption();
        loginPage.setEmailAndPassword(email, password);
        loginPage.clickLoginButton();

        // Add product to cart
        CategoryMenu categoryMenu = new CategoryMenu(driver, actions);
        ProductSubCategoryPage subCategoryPage = categoryMenu.clickHomeAndDecorSubCategory(subCategory);
        ProductPage productPage = subCategoryPage.selectProduct(product);
        productPage.checkCheckbox();
        CartPage cartPage = productPage.addToCart();

        // Checkout
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        assertEquals(checkoutPage.getCheckoutTitle(), "CHECKOUT");
        checkoutPage.selectBillingAddress();
        checkoutPage.selectCashPaymentMethod();
        checkoutPage.clickPlaceOrderButton();
        assertEquals(checkoutPage.getOrderReceivedMessage(), "THANK YOU FOR YOUR PURCHASE!");

        takeScreenshot();

        // Logout
        LogOutPage logOutPage = header.clickLogOutOption();
    }
}

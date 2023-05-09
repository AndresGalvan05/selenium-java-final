package scripts;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertNotNull;

public class CheckoutWithCashTest extends BaseTest {
    @Test(dataProvider = "checkout", dataProviderClass = dataProviders.CheckoutData.class)
    public void testCheckoutWithCash(String email, String password, String subCategory, String product) {
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
        assertNotNull(checkoutPage.getCheckoutPageTitle());
        checkoutPage.selectBillingAddress();
        checkoutPage.selectCashPaymentMethod();
        checkoutPage.clickPlaceOrderButton();
        assertNotNull(checkoutPage.getThankYouMessage());

        takeScreenshot();

        // Logout
        LogOutPage logOutPage = header.clickLogOutOption();
        assertNotNull(logOutPage.getLogOutMessage());
    }
}

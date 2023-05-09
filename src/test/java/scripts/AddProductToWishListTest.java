package scripts;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AddProductToWishListTest extends BaseTest {
    @Test(dataProvider = "checkout", dataProviderClass = dataProviders.CheckoutData.class)
    public void testAddToWishlist(String email, String password, String subCategory, String product) {
        driver.get(baseUrl);

        // Login
        Header header = new Header(driver);
        LoginPage loginPage = header.clickLogInOption();
        loginPage.setEmailAndPassword(email, password);
        loginPage.clickLoginButton();

        // Add to wishlist
        CategoryMenu categoryMenu = new CategoryMenu(driver, actions);
        ProductSubCategoryPage subCategoryPage = categoryMenu.clickHomeAndDecorSubCategory(subCategory);
        assertEquals(subCategoryPage.getSubCategoryPageTitle(), subCategory.toUpperCase());

        ProductPage productPage = subCategoryPage.selectProduct(product);
        assertEquals(productPage.getProductPageTitle(), product);

        WishListPage wishListPage = productPage.addToWishlist();
        assertNotNull(wishListPage.getWishListPageTitle());
        assertEquals(wishListPage.getProductName(product), product);

        takeScreenshot();

        // Logout
        LogOutPage logOutPage = header.clickLogOutOption();
        assertNotNull(logOutPage.getLogOutMessage());
    }
}

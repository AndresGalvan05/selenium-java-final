package scripts;

import org.testng.annotations.Test;
import pages.CategoryMenu;
import pages.ProductSubCategoryPage;
import pages.ProductPage;
import pages.CartPage;

import static org.testng.Assert.*;

public class AddProductToCartTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = dataProviders.ProductsData.class)
    public void testAddToCart(String subCategory, String product, String productColor, String productSize) {
        CategoryMenu categoryMenu = new CategoryMenu(driver, actions);

        ProductSubCategoryPage subCategoryPage = categoryMenu.clickMenSubCategory(subCategory);
        assertEquals(subCategoryPage.getSubCategoryPageTitle(), subCategory.toUpperCase());

        ProductPage productPage = subCategoryPage.selectProduct(product);
        assertEquals(productPage.getProductPageTitle(), product);

        productPage.selectColorAndSize(productColor, productSize);
        CartPage cartPage = productPage.addToCart();
        assertNotNull(cartPage.getCartPageTitle());
        assertEquals(cartPage.getProductName(product), product);

        takeScreenshot();
    }
}
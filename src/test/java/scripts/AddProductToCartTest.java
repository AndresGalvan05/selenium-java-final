package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductSubCategoryPage;
import pages.ProductPage;
import pages.CartPage;

import static org.testng.Assert.*;

public class AddProductToCartTest extends BaseTest {
    @Test(dataProvider = "products", dataProviderClass = dataProviders.ProductsData.class)
    public void testAddToCart(String subCategory, String product, String productColor, String productSize, String productCode) {
        driver.get(baseUrl);

        HomePage home = new HomePage(driver, actions);

        ProductSubCategoryPage subCategoryPage = home.clickMenSubCategory(subCategory);
        assertEquals(subCategoryPage.getSubCategoryTitle(), subCategory.toUpperCase());

        ProductPage productPage = subCategoryPage.selectProduct(product);
        assertEquals(productPage.getProductTitle(), product);

        productPage.selectColorAndSize(productColor, productSize);
        CartPage cartPage = productPage.addToCart();
        assertNotNull(cartPage.getCartTitle());
//        assertEquals(cartPage.getProductCode(productCode), productCode);

        takeScreenshot();
    }
}



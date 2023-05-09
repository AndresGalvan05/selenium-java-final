package scripts;

import org.testng.annotations.Test;
import pages.Header;
import pages.SearchProductPage;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class SearchProductTest extends BaseTest {
    @Test(dataProvider = "searchProducts", dataProviderClass = dataProviders.SearchData.class)
    public void testSearchProduct(String product) {
        Header header = new Header(driver);

        SearchProductPage searchPage = header.searchForProduct(product);
        assertNotNull(searchPage.getSearchPageTitle(product));
        assertTrue(searchPage.getNumberOfProducts() > 0);

        header.clearSearchBar();

        takeScreenshot();
    }
}

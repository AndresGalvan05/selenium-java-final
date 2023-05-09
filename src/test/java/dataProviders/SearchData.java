package dataProviders;

import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchProducts")
    public static Object[][] getSearchData() {
        return new Object[][]{
                {"Glasses"},
                {"Books"},
                {"Shirt"},
                {"Jean"},
                {"Bag"},
        };
    }
}

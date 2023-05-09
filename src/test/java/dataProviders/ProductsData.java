package dataProviders;

import org.testng.annotations.DataProvider;

public class ProductsData {
    @DataProvider(name = "products")
    public static Object[][] getProductsData() {
        return new Object[][]{
                {"Tees, Knits and Polos", "CORE STRIPED SPORT SHIRT", "Indigo", "S"},
                {"Pants & Denim", "FLAT FRONT TROUSER", "Silver", "31"},
        };
    }
}

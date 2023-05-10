package dataProviders;

import org.testng.annotations.DataProvider;

public class SearchData {
    @DataProvider(name = "searchProducts")
    public static Object[][] getSearchData() {
        return new Object[][]{
                {"Glasses", "RETRO CHIC EYEGLASSES"},
                {"Books", "A TALE OF TWO CITIES"},
                {"Shirt", "CORE STRIPED SPORT SHIRT"},
                {"Jean", "THE ESSENTIAL BOOT CUT JEAN"},
                {"Bag", "LARGE CAMERA BAG"},
        };
    }
}

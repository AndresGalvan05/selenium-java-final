package dataProviders;

import org.testng.annotations.DataProvider;

public class CheckoutData {
    @DataProvider(name = "checkout")
    public static Object[][] getCheckoutData() {
        return new Object[][]{
                {"Books & Music", "ALICE IN WONDERLAND"},
        };
    }
}

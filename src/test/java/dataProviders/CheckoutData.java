package dataProviders;

import org.testng.annotations.DataProvider;

public class CheckoutData {
    @DataProvider(name = "checkout")
    public static Object[][] getCheckoutData() {
        return new Object[][]{
                {"8il.andre@gmail.com", "Pass123", "Books & Music", "ALICE IN WONDERLAND"},
        };
    }
}

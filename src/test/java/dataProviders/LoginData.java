package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginData {
    @DataProvider(name = "loginCredentials")
    public static Object[][] getLoginCredentials() {
        return new Object[][]{
                {"8il.andre@gmail.com", "Pass123", "Andrés Galván"},
                {"gocom63106@pixiil.com", "Pass123", "An Ga"},
        };
    }
}

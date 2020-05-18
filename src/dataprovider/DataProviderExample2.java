package dataprovider;

import dataprovider.DataProviderExample;
import org.testng.annotations.Test;

public class DataProviderExample2 {
    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderExample.class)
    public void loginTest(String email, String password){
        System.out.println("email: " + email + ", password: " + password);
    }
}

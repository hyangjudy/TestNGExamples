package dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "LoginDataProvider")
    public Object[][] getData(){
        Object[][] data = {
                {"abc@gmail.com", "abc"},
                {"xyz@gmail.com", "xyz"},
                {"mno@gmail.com", "mno"},
        };
        return data;
    }

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String email, String password){
        System.out.println("email: " + email + ", password: " + password);
    }
}

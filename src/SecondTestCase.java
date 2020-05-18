import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestCase {

    @Test
    public void setup() {
        System.out.println("opening browser");
    }

    @Test
    public void searchCustomer() {
        System.out.println("This is search customer test");
        Assert.assertEquals(1, 2);
    }

    @Test
    public void addCustomer() {
        System.out.println("This is add customer test");
    }

    @Test
    public void tearDown() {
        System.out.println("closing browser");
    }

}

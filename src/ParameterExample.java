import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExample {

    @Test
    @Parameters({"browser"})
    public void testBrowser(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("The browser is firefox");
        }else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("The browser is chrome");
        }
    }
}

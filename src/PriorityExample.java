import org.testng.annotations.Test;

public class PriorityExample {
    @Test
    public void testZero() {
        System.out.println("This is test 0");
    }

    @Test(priority = 1)
    public void testOne() {
        System.out.println("This is test 1");
    }

    @Test(priority = 2, enabled = false)
    public void testTwo() {
        System.out.println("This is test 2");
    }
}

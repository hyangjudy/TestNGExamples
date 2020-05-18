import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {
    @Test
    void startCar() {
        System.out.println("This is start car test");
    }

    @Test(dependsOnMethods = {"startCar"})
    void driveCar() {
        System.out.println("This is drive car test");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"driveCar"})
    void stopCar() {
        System.out.println("This is stop car test");
    }

    @Test(dependsOnMethods = {"driveCar", "stopCar"}, alwaysRun = true)
    void parkCar() {
        System.out.println("This is park car test");
    }
}

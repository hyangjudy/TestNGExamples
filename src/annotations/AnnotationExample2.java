package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationExample2 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is called before the class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is called after the class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is called before every method is called");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("This is called after every method is called");
    }

    @Test
    public void test3() {
        System.out.println("This is test3");
    }

    @Test
    public void test4() {
        System.out.println("This is test4");
    }
}

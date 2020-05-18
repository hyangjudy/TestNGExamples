package annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationExample1 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is called before the suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is called after the suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is called before the test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is called after the test");
    }

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
    public void test1() {
        System.out.println("This is test1");
    }

    @Test
    public void test2() {
        System.out.println("This is test2");
    }
}

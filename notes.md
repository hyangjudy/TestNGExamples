# [TestNG with IntelliJ IDE](https://www.youtube.com/watch?v=MsIQmCJD0Hc)

## Tutorial 1: Setup environment
1. Create a java project named `TestNG`
2. Add dependency
    1. Go to [mvnrepository](https://mvnrepository.com)
    2. Search for `testng`
    3. Download the jar of the latest version
    4. Add the jar dependency into the project structure

## Tutorial 2: Creating & Run Tests using TestNG.xml
1. Install TestNG xml plugin
2. Invalid and restart IntelliJ
3. Add another class case 
    ```Java
    // src/SecondTestCase.java
    import org.testng.Assert;
    import org.testng.annotations.Test;

    public class SecondTestCase {

        @Test(priority = 1)
        public void setup() {
            System.out.println("opening browser");
        }

        @Test(priority = 3)
        public void searchCustomer() {
            System.out.println("This is search customer test");
            Assert.assertEquals(1, 2);
        }

        @Test(priority = 2)
        public void addCustomer() {
            System.out.println("This is add customer test");
        }

        @Test(priority = 4)
        public void tearDown() {
            System.out.println("closing browser");
        }

    }
    ```
4. Add TestNG XML file
    1. click project name, `New` -> `File`, add `testng.xml`
    2. In `testng.xml`, add
        ```xml
        <suite name="All Test Suite">
            <test name="testngTest">
                <classes>
                    <class name="FirstTestCase"/>
                    <class name="SecondTestCase"/>
                </classes>
            </test>
        </suite>
        ```
5. Click and run `testng.xml`
6. To add reports
    1. `Run` -> `Edit Configuration`
    2. Click `testng.xml` -> `Listeners`
    3. Click `+` add `org.testng.reporters.FailedReporter` and `org.testng.reporters.EmailableReporter`
    4. Run `testng.xml` again and the reports will be int `test-output` folder

## Tutorial 3: Annotations in TestNG

```xml
<!-- a -->
<suite name="All Test Suite">
    <!-- c -->
    <test name="annotationTest">
        <classes>
            <!-- e -->
            <class name="annotations.AnnotationExample1">
                <methods>
                    <!-- g -->
                    <include name="test1"/>
                    <!-- h -->
                    <include name="test2"/>
                </methods>
            </class>
            <!-- f -->
            <class name="annotations.AnnotationExample2">
                <methods>
                    <include name="test3"/>
                    <include name="test4"/>
                </methods>
            </class>
        </classes>
    </test>
    <!-- d -->
</suite>
<!-- b -->
```

| Annotation | When the method will be called |
| - | - | 
| BeforeSuite | a |
| BeforeTest | c |
| BeforeClass | e |
| BeforeMethod | g |
| AfterMethod | h |
| AfterClass | f |
| AfterTest | d |
| AfterSuite | b |

## Tutorial 4: Prioritizing & Disabling Tests
### Prioritizing
```Java
// src/PriorityExample.java
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

    @Test(priority = 2)
    public void testTwo() {
        System.out.println("This is test 2");
    }
}
```
The `priority` will set the order of tests

### Disabling
```Java
// src/PriorityExample.java
@Test(priority = 2, enabled = false)
public void testTwo() {
    System.out.println("This is test 2");
}
```

## Tutorial 5: Dependency Tests in TestNG & AlwaysRun property

| | |
| - | - |
| dependsOnMethods | specifies the tests that the method depends on |
| alwaysRun | `alwaysRun = true` forces the execution of the test even if its dependencies  fail |

## Tutorial 6: Grouping Tests
1. Define the groups
```Java
@Test(groups = {"...", "..."})
```

2. In `testng.xml`, define how to run the groups. E.g
```xml
<!-- testng.xml -->
<suite name="All Test Suite">
    <test name="groupingTest">
        <groups>
            <run>
                <include name="sanity"/>
                <exclude name="regression"/>
            </run>
        </groups>
        <classes>
            <class name="GroupingExample"/>
        </classes>
    </test>
</suite>
```

* Use cases: test for different version

## Tutorial 7: Assertions
[org.testng.Assert](https://www.javadoc.io/doc/org.testng/testng/6.8.17/org/testng/Assert.html)

## Tutorial 8: Paramters from testng.xml
E.g:
1. in `testng.xml`, add 
```xml
<parameter name="browser" value="chrome">
```
2. before the method add `@Parameters`, and take the parameters as arguments
```Java
@Parameters({"browser"})
public void testBrowser(String browser) {...}
```

## Tutorial 9: DataProvider in TestNG
1. DataProvider and DataProviderClass in the same file
```Java
// src/dataprovider.DataProviderExample.java
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
    // get the dataProvider by name
    public void loginTest(String email, String password){
        System.out.println("email: " + email + ", password: " + password);
    }
}
```

2. DataProvider and DataProviderClass in different files
```Java
// src/dataprovider.DataProviderExample2.java
import dataprovider.DataProviderExample;
import org.testng.annotations.Test;

public class DataProviderExample2 {
    @Test(dataProvider = "LoginDataProvider", dataProviderClass = DataProviderExample.class)
    // dataProviderClass denotes the location of dataProviderClass
    public void loginTest(String email, String password){
        System.out.println("email: " + email + ", password: " + password);
    }
}
```

## Tutorial 10: Parallel Tests
E.g.
1. Create two test classes
```Java
// src/parallel.ParallelExample1.java
import org.testng.annotations.Test;

public class ParallelExample1 {

    @Test
    public void test1() {
        System.out.println("ParallelExample1 ... test1 ...");
    }

    @Test
    public void test2() {
        System.out.println("ParallelExample1 ... test2 ...");
    }

    @Test
    public void test3() {
        System.out.println("ParallelExample1 ... test3 ...");
    }

    @Test
    public void test4() {
        System.out.println("ParallelExample1 ... test4 ...");
    }
}

// src/parallel.ParallelExample2.java
import org.testng.annotations.Test;

public class ParallelExample2 {

    @Test
    public void test1() {
        System.out.println("ParallelExample2 ... test1 ...");
    }

    @Test
    public void test2() {
        System.out.println("ParallelExample2 ... test2 ...");
    }

    @Test
    public void test3() {
        System.out.println("ParallelExample2 ... test3 ...");
    }

    @Test
    public void test4() {
        System.out.println("ParallelExample2 ... test4 ...");
    }
}
```
2. Set the testng xml
```xml
<!-- testng3.xml -->
<suite name="All Test Suite">
    <test name="parallelTest" parallel="classes" thread-count="2">
        <classes>
            <class name="parallel.ParallelExample1"/>
            <class name="parallel.ParallelExample2"/>
        </classes>
    </test>
</suite>
```
3. Check the results:
```
parallel.ParallelExample2 ... test1 ...
parallel.ParallelExample1 ... test1 ...
parallel.ParallelExample1 ... test2 ...
parallel.ParallelExample2 ... test2 ...
parallel.ParallelExample1 ... test3 ...
parallel.ParallelExample2 ... test3 ...
parallel.ParallelExample1 ... test4 ...
parallel.ParallelExample2 ... test4 ...
```
* parallel could be `"methods"`, `"classes"`, `"tests"`


## Tutorial 11: Listeners
E.g
1. Implement a customized listeners class 
```Java
// src/listeners/CustomListeners.java
package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Start test..." + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Passed test..." + iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Failed test..." + iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Skipped test..." + iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Start Test execution..." + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finish Test execution..." + iTestContext.getName());
    }
}
```

2. Check the result of the customized listeners
```Java
// src/listeners/ListenerTest.java
package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.CustomListeners.class)
// set the listeners
public class ListenerTest {
    @Test
    public void test1() {
        System.out.println("This is test 1");
        Assert.assertEquals("A", "A");
    }
    // STDOUT:
    // Start test...test1
    // This is test 1
    // Passed test...test1

    @Test
    public void test2() {
        System.out.println("This is test 2");
        Assert.assertEquals("A", "B");
    }
    // STDOUT:
    // Start test...test2
    // This is test 2
    // Failed test...test2

    @Test
    public void test3() {
        System.out.println("This is test 3");
        throw new SkipException("Skip test 3");
    }
    // STDOUT:
    // Start test...test3
    // This is test 3
    // Skipped test...test3
}
```

3. Another way to set the Listeners is in `testng.xml`
```xml
<!-- testng2.xml -->
<suite name="All Test Suite">
    <listeners>
        <listener class-name="listeners.CustomListeners"/>
    </listeners>
    <test name="listenersTest">
        <classes>
            <class name="listeners.ListenerTest"/>
        </classes>
    </test>
</suite>
```


# Use cases: 
[软件测试---2019 Testng数据驱动](https://www.bilibili.com/video/BV1EE411Z79j)
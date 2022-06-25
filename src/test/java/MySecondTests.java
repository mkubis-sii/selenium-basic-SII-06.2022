import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MySecondTests {
    @BeforeMethod
    public void setup(){
        System.out.println("I will run before each test");
    }

    @AfterMethod
    public void cleanUp(){
        System.out.println("I will run AFTER each test");
    }

    @Test
    public void shouldAddTwoNumbers(){
        Assert.assertEquals(add(2,3), 5);
    }

    @Test
    public void shouldMultiplyTwoNumbers(){
        Assert.assertEquals(multiply(2,3), 6);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b * b;
    }
}

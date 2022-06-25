import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {
    @BeforeMethod
    public void setup(){
        System.out.println("I will run before each test");
    }

    @AfterMethod
    public void cleanUp(){
        System.out.println("I will run AFTER each test");
    }

    @Test
    public void myFirstTest(){
        Assert.assertEquals(1,1);

        System.out.println(">>>> this is first test");
    }

    @Test
    public void mySecondTest(){
        System.out.println(">>>> this is start of second test");
        Assert.assertEquals(1,2);

        System.out.println(">>>> this is end of second test");
    }
}

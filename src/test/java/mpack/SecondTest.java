package mpack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class SecondTest {
    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    void test1() {
        driver.get("https://www.facebook.com/");
    }
    @Test(dependsOnMethods = "test1")
    void test2() {
        driver.get("https://www.google.com/");
    }
    @Test(dependsOnMethods = "test2")
    void test3() {
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
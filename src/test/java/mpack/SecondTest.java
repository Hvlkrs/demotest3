package mpack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
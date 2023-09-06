package mpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;

    @Test
    public void verifyTitle() {
//WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        driver=new ChromeDriver(options);
        driver.get("https://www.browserstack.com/");
        System.out.println("Title is: " +driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "App & Browser Testing Made Easy");
        driver.quit();
    }

}
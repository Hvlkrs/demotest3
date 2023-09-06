package mpack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    @Test
    public void mOne() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.de/");
        //  driver.findElement(By.id("//*[@id=\"a-autoid-0\"]")).click();
        //  driver.findElement(By.id("//*[@id=\"nav-logo-sprites\"]")).click();

        driver.close();

    }
}

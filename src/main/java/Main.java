import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Main {
    @Test
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromdriver_93.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com.ua");
        WebElement googleSearch = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        googleSearch.sendKeys("wiki");
        googleSearch.submit();

        WebElement googleCheck = driver.findElement(By.tagName("input"));
        Assert.assertTrue(googleCheck.isDisplayed(), "Username is NOT displayed");

        driver.close();
    }
}



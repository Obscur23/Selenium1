import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Obscur on 16.01.18.
 */


public class Test1 {
WebDriver driver;
String baseUrl;

    @Before
    public void beforeTest(){
 //   System.setProperty("webdriver.firefox.driver");
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    }

    @Test
    public void testInsurance(){

    }

    @After
    public void afterTest(){

    }
}

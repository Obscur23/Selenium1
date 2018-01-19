import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Obscur on 16.01.18.
 */


public class Test1 {
WebDriver driver;
String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriwer.gecko.driver", "drv/geckodriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);

    }

    @Test
    public void testInsurance(){
        System.setProperty("webdriwer.gecko.driver", "drv/geckodriver.exe");
    driver.findElement(By.xpath("//*[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//*[contains(text(), 'Застраховать себя')]")).click();
    driver.findElement(By.xpath("//*[contains(@class,'sbrf-div-list-inner --area bp-area overlays-container')]//*[contains(text(), 'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5,1000);
        wait.until(ExpectedCondition.)

    }

    @After
    public void afterTest(){
    driver.quit();

    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Obscur on 16.01.18.
 */


public class Test1 {
WebDriver driver;
String baseUrl;

    @Before
    public void beforeTest(){
        System.setProperty("webdriwer.gecko.driver", "C:/Users/user/IdeaProjects/Selenium1/drv/geckodriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);

    }

    @Test
    public void testInsurance(){
        System.setProperty("webdriwer.gecko.driver", "C:/Users/user/IdeaProjects/Selenium1/drv/geckodriver.exe");
      WebElement ele = driver.findElement(By.xpath("//span[contains(text(), 'Застраховать себя')]"));
       Actions action = new Actions(driver);
      action.moveToElement(ele).perform();


  //      WebElement elee = driver.findElement(By.xpath("//*[contains(@class,'sbrf-div-list-inner --area bp-area overlays-container')]//*[contains(text(), 'Страхование путешественников')]"));
   //     Actions action2 = new Actions(driver);

   //   action2.moveToElement(elee).click();


//   driver.findElement(By.xpath("//*[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//*[contains(text(), 'Застраховать себя')]"));
   driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/div/div/div[2]/div/a")).click();
       // Wait<WebDriver> wait = new WebDriverWait(driver, 5,1000);
       // wait.until(ExpectedCondition.)

    }

    @After
    public void afterTest(){
  //  driver.quit();

    }
}

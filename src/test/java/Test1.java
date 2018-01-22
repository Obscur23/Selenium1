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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.ArrayList;
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
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(baseUrl);

    }

    @Test
    public void testInsurance(){
       // System.setProperty("webdriwer.gecko.driver", "C:/Users/user/IdeaProjects/Selenium1/drv/geckodriver.exe");
        /**
      WebElement ele = driver.findElement(By.xpath("//span[contains(text(), 'Застраховать себя')]"));
       Actions action = new Actions(driver);
      action.moveToElement(ele).perform();
*/

  //      WebElement elee = driver.findElement(By.xpath("//*[contains(@class,'sbrf-div-list-inner --area bp-area overlays-container')]//*[contains(text(), 'Страхование путешественников')]"));
   //     Actions action2 = new Actions(driver);

   //   action2.moveToElement(elee).click();

        driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'Застраховать себя')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//a[contains(text(),'Страхование путешественников')]")).click();
    Wait<WebDriver> wait = new WebDriverWait(driver, 5,500);
        WebElement onlineBtn = driver.findElement(By.xpath("//div[contains(@data-pid,'SBRF-TEXT-1021974')]"));
      wait.until(ExpectedConditions.elementToBeClickable(onlineBtn)).click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

      //  driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")));
      //  driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@class,'b-form-box-block')]//div[(text()='Минимальная')]")));
      WebElement box = driver.findElement(By.xpath("//div[contains(@class,'b-form-box-block')]//div[(text()='Минимальная')]"));
       //wait.until(ExpectedConditions.elementToBeClickable(header)).click();
      wait.until(ExpectedConditions.visibilityOf(box)).click();
     //  driver.findElement(By.xpath("//*[contains(text(),'Минимальная')]")).click();
     driver.findElement(By.xpath("//*[contains(@ng-click,'save()')]")).click();






    }
    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);}
    @After
    public void afterTest(){
 //  driver.quit();

    }
}

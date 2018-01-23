import org.junit.After;
import org.junit.Assert;
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
    public void beforeTest() {
        System.setProperty("webdriwer.gecko.driver", "C:/Users/user/IdeaProjects/Selenium1/drv/chromedriver.exe");
        baseUrl = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @Test
    public void testInsurance() {
        driver.findElement(By.xpath("//span[@class='multiline']//*[contains(text(),'Застраховать себя')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'sbrf-div-list-inner --area bp-area header_more_nav')]//a[contains(text(),'Страхование путешественников')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 500);
        WebElement onlineBtn = driver.findElement(By.xpath("//div[contains(@data-pid,'SBRF-TEXT-1021974')]"));

       WebElement message = driver.findElement(By.xpath("//div[contains(@class,'sbrf-rich-outer')]/h1"));
       wait.until(ExpectedConditions.visibilityOf(message));
       Assert.assertEquals("Страхование путешественников", message.getText());


        wait.until(ExpectedConditions.elementToBeClickable(onlineBtn)).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));


        WebElement box = driver.findElement(By.xpath("//div[contains(@class,'b-form-box-block')]//div[(text()='Минимальная')]"));

        wait.until(ExpectedConditions.visibilityOf(box)).click();

        driver.findElement(By.xpath("//*[contains(@ng-click,'save()')]")).click();
        fillField(By.name("insured0_surname"), "Ivanov");
        fillField(By.name("insured0_name"), "Petr");
        fillField(By.name("insured0_birthDate"), "27.02.1983");
        fillField(By.name("surname"), "Иванов");
        fillField(By.name("name"), "Петр");
        fillField(By.name("middlename"), "Петрович");
        fillField(By.name("passport_series"), "1234");
        fillField(By.name("passport_number"), "123458");
        fillField(By.name("issueDate"), "27.02.2013");
        fillField(By.name("birthDate"), "27.07.1983");
        fillField(By.name("issuePlace"), "ОВД 78");
        driver.findElement(By.xpath("//*[contains(text(),'Продолжить')]")).click();
        WebElement messageIns = driver.findElement(By.xpath("//*[contains(@ng-show,'tryNext && myForm.$invalid')]"));
        wait.until(ExpectedConditions.visibilityOf(messageIns));
        Assert.assertEquals("Заполнены не все обязательные поля", messageIns.getText());


    }

    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
         driver.quit();

    }
}

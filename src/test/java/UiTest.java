import Helper.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class UiTest {

    @Before
    public void setup() {
        BasePage.driver();
    }

    @Test
    public void viewBasePage() {
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        BasePage.openWebSite();
        String result = BasePage.webDriver.getTitle();
        Assert.assertEquals(result,title);
    }

    @Test
    public void loginTest(){
        String loginUrl = "https://www.lcwaikiki.com/tr-TR/TR/giris";
        String title = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        BasePage.openASite(loginUrl);
        BasePage.webDriver.findElement(By.id("LoginEmail")).sendKeys("testyap5995@gmail.com");
        BasePage.webDriver.findElement(By.id("Password")).sendKeys("test5995");
        BasePage.webDriver.findElement(By.id("loginLink")).click();
        Assert.assertEquals(title,BasePage.webDriver.getTitle());
    }

    @Test
    public void searchTest() throws InterruptedException {
        BasePage.openWebSite();
        String title = "Bej XSIDE Slim Fit Gabardin Kargo Pantolon - 0WCT70Z8-KK7 - LC Waikiki";
        BasePage.webDriver.findElement(By.id("search_input")).click();
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.id("search_input")).sendKeys("pantolon");
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.xpath(".//button[text()='Ara']")).click();
        TimeUnit.SECONDS.sleep(5);
        JavascriptExecutor jse = (JavascriptExecutor) BasePage.webDriver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.xpath("//*[@id=\"divModels\"]/div[7]/div/div[4]/a")).click();
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.xpath("//*[@id=\"model_1039089_4636794\"]/div[1]/img[1]")).click();
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.xpath("//*[@id=\"option-size\"]/a[2]")).click();
        TimeUnit.SECONDS.sleep(5);
        BasePage.webDriver.findElement(By.xpath("//*[@id=\"pd_add_to_cart\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        String result = BasePage.webDriver.getTitle();
        Assert.assertEquals(result,title);
    }

    @After
    public void quit(){
        BasePage.quitDriver();
    }
}

package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    public static WebDriver webDriver;
    public static String testUrl = "https://www.lcwaikiki.com/tr-TR/TR";

    public static void driver(){
        System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    public static void openWebSite(){
        webDriver.navigate().to(testUrl);
    }

    public static void openASite(String toUrl){
        webDriver.get(toUrl);
    }

    public static void Actions(WebElement target){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(target).perform();
    }

    public static void quitDriver(){
        webDriver.quit();
    }
}

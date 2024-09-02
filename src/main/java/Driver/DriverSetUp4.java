package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetUp4 {
    public static void main(String[] args) {
        method1();
    }
    public static WebDriver method1(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        return driver;
    }
}

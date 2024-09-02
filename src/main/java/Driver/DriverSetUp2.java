package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUp2 {
    public static void main(String[] args) throws InterruptedException {
    setUpdriver();
        //
    }

    public static WebDriver setUpdriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.quit();
        return null;
    }


}

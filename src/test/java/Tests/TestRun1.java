package Tests;

import Driver.DriverSetUp1;
import Functions.Functions1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestRun1 {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;
    static Functions1 functions1;


    @BeforeClass
    public void SetUpdriver(){
        driver = DriverSetUp1.setUpdriver();
       functions1 = new Functions1(driver);
        //Functions1.driver.get("https://www.automationexercise.com/#google_vignette");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

    }

    @AfterClass
    public void quit(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public static void Test1() throws InterruptedException {
        Functions1 fun = new Functions1(driver);
        fun.RunMainPage();
        fun.MainPageVisible();
        fun.Signup();
        fun.ENTERACCOUNTINFOMRATION();
        fun.ADDRESSINFORMATION();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));



    }


    }



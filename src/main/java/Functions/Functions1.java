package Functions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Functions1 {

    private WebDriver driver;

    private WebDriverWait wait;

    public Functions1(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[contains(@href,'login')][1]")
    public WebElement login;

    @FindBy(xpath = "//h2[contains(text(), 'New User Signup!')]")
    public WebElement signuptext;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement Name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement Email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement SingUpButton;

    @FindBy(xpath = "//h2[contains(@class,'title text-center')][1]")
    public WebElement EnterAccountInformation;

    @FindBy(xpath = "//input[contains(@id,'id_gender1')][1]")
    public WebElement MR;

    @FindBy(xpath = "//input[contains(@class,'form-control')][1]")
    public WebElement EnterName;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    public WebElement EnterPassword;

    @FindBy(xpath = "//select[contains(@id,'days')]")
    public WebElement days;

    @FindBy(xpath = "//select[contains(@id,'months')]")
    public WebElement months;
    @FindBy(xpath = "//select[contains(@id,'years')]")
    public WebElement years;

    @FindBy(xpath = "//input[contains(@id,'newsletter')]")
    public WebElement newsletter;

    @FindBy(xpath = "//input[contains(@id,'optin')]")
    public WebElement partners;

    @FindBy(xpath = "//input[contains(@id,'first_name')]")
    public WebElement AddressfirstName;

    @FindBy(xpath = "//input[contains(@id,'last_name')]")
    public WebElement AddresslastName;

    @FindBy(xpath = "//input[contains(@id,'company')]")
    public WebElement Companyname;

    @FindBy(xpath = "//input[contains(@id,'address1')]")
    public WebElement CompanyAddress;

    @FindBy(xpath = "//input[contains(@id,'address2')]")
    public WebElement CompanyAddress2;

    @FindBy(xpath = "//select[contains(@id,'country')]")
    public  WebElement Country;

    @FindBy(xpath = "//input[contains(@id,'state')]")
    public WebElement State;

    @FindBy(xpath = "//input[contains(@id,'city')]")
    public WebElement City;

    @FindBy(xpath = "//input[contains(@id,'zipcode')]")
    public WebElement ZipCode;

    @FindBy(xpath = "//input[contains(@id,'mobile_number')]")
    public WebElement MobileNUmber;

    @FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
    public WebElement CreateButton;

    @FindBy(xpath = "//b[contains(@text,'')][1]")
    public WebElement CreateAccounttext;

    @FindBy(xpath = "//a[contains(@class,'btn btn-primary')]")
    public WebElement ContinueButtononCreateaccount;

    @FindBy(xpath = "//i[contains(@class, 'fa fa-user')]")
    public WebElement ActualUserName;

    @FindBy(xpath = "//a[contains(@href,'delete_account')]")
    public WebElement DeleteAccount;

    @FindBy(xpath = "//b[contains(text(), 'Account Deleted!')]")
    public WebElement Deleteaccounttext;

    @FindBy(xpath = "//a[contains(@class, 'btn btn-primary')]")
    public WebElement Continueclickondeletepage;



    public void RunMainPage(){
        driver.get("https://www.automationexercise.com/#google_vignette");

    }
    public void MainPageVisible() throws InterruptedException {
        WebElement MainPage = driver.findElement(By.xpath("//div[contains(@class,'container')]"));
        Assert.assertTrue(MainPage.isDisplayed(),"Main page is not visible");
        Thread.sleep(2000);
    }
    @Step("login user")
    public void Signup(){
        login.click();
        signuptext.isDisplayed();
        Name.sendKeys("Giorg");
        Email.sendKeys("Shaqarashvili2@gmail.com");
        SingUpButton.click();

    }
@Step("ENTER ACCOUNT INFORMATION")
    public void ENTERACCOUNTINFOMRATION() throws InterruptedException {
    Assert.assertEquals(EnterAccountInformation.getText(),"ENTER ACCOUNT INFORMATION");
    MR.click();
    //EnterName.sendKeys("Giorgi");
    EnterPassword.sendKeys("12341234");
    days.click();
    days.sendKeys("25");
    days.sendKeys(Keys.ENTER);
    months.click();
    months.sendKeys("june");
    months.sendKeys(Keys.ENTER);
    years.click();
    years.sendKeys("1995");
    years.sendKeys(Keys.ENTER);
    newsletter.click();
    partners.click();

    Thread.sleep(2000);
}
@Step("ADDRESS INFORMATION")
    public void ADDRESSINFORMATION(){
   AddressfirstName.sendKeys("Giorgi");
   AddresslastName.sendKeys("Shakarashvili");
   Companyname.sendKeys("Liberty Bank Georgia");
   CompanyAddress.sendKeys("Tbilis , chavchavadze N80");
   CompanyAddress2.sendKeys("stage 6 ");
   Country.click();
   Country.sendKeys("Canada");
   Country.sendKeys(Keys.ENTER);
   State.sendKeys("Georgia");
   City.sendKeys("Tbilis");
   ZipCode.sendKeys("0193");
   MobileNUmber.sendKeys("571097508");
   CreateButton.click();
   CreateAccounttext.isDisplayed();
   ContinueButtononCreateaccount.click();
   ActualUserName.isDisplayed();
   DeleteAccount.click();
   Deleteaccounttext.isDisplayed();
   Continueclickondeletepage.click();




}
}

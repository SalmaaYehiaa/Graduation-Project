package Tests;

import Pages.Login_Page;
import Pages.SecurePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CurrencyTestCases {
    WebDriver driver;
    WebDriverWait wait;
    Pages.Login_Page Login_Page;
    SecurePage securePage;


    @BeforeMethod
    public void precondition3() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
        Login_Page = new Login_Page(driver);
        securePage = new SecurePage(driver);
    }
 @Test
 //TC20

 public void LoggedUsersCouldSwitchCurrenciesToEuro(){
        Login_Page.CurrencyDropDownList().click();
        Login_Page.Currency_Euro_Selected().click();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        securePage.AssertCurrencyIsEuro();
 }
 @Test

 //TC21
 public void LoggedUsersCouldSwitchCurrenciesToUS(){
     Login_Page.CurrencyDropDownList().click();
     Login_Page.Currency_US_Selected().click();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
     securePage.AssertCurrencyIsUS();

 }

    @AfterMethod
    public void quiteBrowser() throws InterruptedException {
        driver.quit();
    }
}

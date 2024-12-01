package Tests;

import Pages.Login_Page;
import Pages.SecurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTestCases {
    WebDriver driver;
    WebDriverWait wait;
    Login_Page Login_Page;
    SecurePage securePage;

    @BeforeMethod
    public void precondition2() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
        driver.findElement(By.className("caret")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        Login_Page = new Login_Page (driver);
        securePage = new SecurePage(driver);
    }

    @Test
    //TC 12

    public void LoginWithValidCredential() throws InterruptedException {
        Login_Page.EMailAddress().sendKeys("fatm44@gmail.com");
        Login_Page.password().sendKeys("Fatmh1448");
        Login_Page.LoginButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        securePage.ValidLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    //TC13
    public void LoginWithEmptyEmailField() throws InterruptedException {
        Login_Page.EMailAddress().sendKeys("");
        Login_Page.password().sendKeys("Fat8");
        Login_Page.LoginButton().click();
        Thread.sleep(3000);
        securePage.validateErrorMessageAppearWhenLeavePasswordOrEmailFieldEmpty();


    }
  @Test
   //TC14
   public void LoginWithPasswordFieldEmpty() throws InterruptedException {
    Login_Page.EMailAddress().sendKeys("fatm4@gmail.com");
    Login_Page.password().sendKeys("");
    Login_Page.LoginButton().click();
      Thread.sleep(3000);
    securePage.validateErrorMessageAppearWhenLeavePasswordOrEmailFieldEmpty();



}
  @Test
   //TC15
   public  void  LoginWithUnregisteredEmail() throws InterruptedException {
      Login_Page.EMailAddress().sendKeys("reham@gmail.com");
      Login_Page.password().sendKeys("Fat1448");
      Login_Page.LoginButton().click();
      Thread.sleep(3000);
      securePage.validateErrorMessageAppearLoginWithUnregisteredEmail();
  }

      ///////////////////////////////////////////////////////ForgottenPassword/////////////////////////////////////////////////////////////////


      @Test
              //TC16
      public void ForgottenPasswordButtonIsClickable() {
          Login_Page.ForgottenPassword().click();
          securePage.validateClickOnForgottenPassword();
      }
@Test
  //TC17
          public void ValidateTheForgetPasswordFunctionalityWithValidEmail(){
        Login_Page.ForgottenPassword().click();
        securePage.validateClickOnForgottenPassword();
          Login_Page.ForgottenPasswordEmail().sendKeys("fatmh1448@gmail.com");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         Login_Page.ForgottenPasswordContinueButton().click();
          securePage.ValidateTheForgetPasswordFunctionalityWithValidEmail();

  }
@Test
      //TC18

public void ValidateTheForgetPasswordFunctionalityWithInvalidEmail(){
    Login_Page.ForgottenPassword().click();
    securePage.validateClickOnForgottenPassword();
    Login_Page.ForgottenPasswordEmail().sendKeys("fatmh1448@gmail");
    Login_Page.ForgottenPasswordContinueButton().click();
    securePage.ValidateTheForgetPasswordFunctionalityWithInvalidEmail();
}

    @AfterMethod
    public void quiteBrowser() throws InterruptedException {
        driver.quit();
    }

}


package Tests;

import Pages.Register_Page;
import Pages.SecurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTestCases {
       WebDriver driver;
       WebDriverWait wait ;
       Register_Page Register_Page;
       SecurePage securePage;

       @BeforeMethod

       public void Precondition() {
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
            wait =new WebDriverWait(driver,Duration.ofSeconds(5));
           driver.findElement(By.className("caret")).click();
           driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[1]/a")).click();
           Register_Page = new Register_Page(driver);
           securePage = new SecurePage(driver);
       }

       @Test
       //tc 1
       public void validRegister() {
           Register_Page.firstname().sendKeys("Fatema");
           Register_Page.lastname().sendKeys("Fathi");
           Register_Page.email().sendKeys("Fat23@gmail.com");
           Register_Page.telephone().sendKeys("01063847464");
           Register_Page.password().sendKeys("Fatmh1448");
           Register_Page.confirmPassword().sendKeys("Fatmh1448");
           Register_Page.Subscribe().click();
           Register_Page.PrivacyPolicy().click();
           Register_Page.ContinueButton().click();
           securePage.Valid_Register();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       }


       @Test
       //tc 2
         public void RegistrationWithAllFieldsEmpty(){
               Register_Page.firstname().sendKeys("");
               Register_Page.lastname().sendKeys("");
               Register_Page.email().sendKeys("");
               Register_Page.telephone().sendKeys("");
               Register_Page.password().sendKeys("");
               Register_Page.confirmPassword().sendKeys("");
               Register_Page.Subscribe().click();
               Register_Page.PrivacyPolicy().click();
               Register_Page.ContinueButton().click();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
               securePage.Validation_Error_Message_for_wrong_first_name();
               securePage.Validation_Error_Message_for_wrong_Last_name();
               securePage.Validation_Error_Message_for_wrong_Email();
               securePage.Validation_Error_Message_Appear_for_wrong_Telephone();
               securePage.Validation_Error_Message_Appear_for_Invalid_Password();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
           }
       @Test
       // tc 3
    public void RegistrationUsingInvalidCredential(){
        Register_Page.firstname().sendKeys("Fatemaqwertyuioplkjdsafzxcvbnmpoiuytrew");
        Register_Page.lastname().sendKeys("Fathioiuytrewqasdfjklmnbvcxzaqwert");
        Register_Page.email().sendKeys("Fatemaa@gmail");
        Register_Page.telephone().sendKeys("01");
        Register_Page.password().sendKeys("Fat");
        Register_Page.confirmPassword().sendKeys("Ft");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        securePage.Validation_Error_Message_for_wrong_first_name();
        securePage.Validation_Error_Message_for_wrong_Last_name();
        securePage.Validation_Error_Message_for_wrong_Email();
        securePage.Validation_Error_Message_Appear_for_wrong_Telephone();
        securePage.Validation_Error_Message_Appear_for_Invalid_Password();
        securePage.Validation_Error_Message_for_wrong_confirmation_password();
        securePage.Validation_Error_Message_Appear_for_Invalid_Password();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
       //tc4
       public void invalidRegistrationWithEmailAlreadyRegistered(){
          Register_Page.firstname().sendKeys("Fatema");
           Register_Page.lastname().sendKeys("Fathi");
           Register_Page.email().sendKeys("fatmh1448@gmail.com");
           Register_Page.telephone().sendKeys("01063847464");
           Register_Page.password().sendKeys("Fatmh1448");
           Register_Page.confirmPassword().sendKeys("Fatmh1448");
           Register_Page.Subscribe().click();
           Register_Page.PrivacyPolicy().click();
           Register_Page.ContinueButton().click();
           securePage.Validation_Error_Message_for_email_already_register();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       }

    @Test
    //tc 5
       public void RegistrationUsingInvalidFirstName() throws InterruptedException {
        Register_Page.firstname().sendKeys("Fatemaoiuytrewqasdfjklmnbvcxzaewwqwert");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatema@gmail.com");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh418");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_for_wrong_first_name();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        }
     @Test
     ///tc 6
        public void RegistrationUsingInvalidLastName() throws InterruptedException {
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathioiuytrewqasdfjklmnbvcxzaqwert");
        Register_Page.email().sendKeys("Fatema@gmail.com");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh418");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_for_wrong_Last_name();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    //tc 7
        public void RegistrationUsingInvalidEmail() throws InterruptedException {
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatema@gmail");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh1448");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_for_wrong_Email();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    //tc 8
        public void RegistrationUsingInvalidTelephone() throws InterruptedException {
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatema@gmail.com");
        Register_Page.telephone().sendKeys("01");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh1448");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_Appear_for_wrong_Telephone();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    /// tc 9
        public void RegistrationUsingInvalidPassword(){
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatemaa@gmail.com");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fat");
        Register_Page.confirmPassword().sendKeys("Fat");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_Appear_for_Invalid_Password();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }
    @Test
    //tc 10
       public void RegistrationUsingWrongConfirmationPassword() throws InterruptedException {
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatema@gmail.com");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh418");
        Register_Page.Subscribe().click();
        Register_Page.PrivacyPolicy().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_for_wrong_confirmation_password();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    /// tc 11
    public void RegistrationWithoutCheckPrivacyPolicy(){
        Register_Page.firstname().sendKeys("Fatema");
        Register_Page.lastname().sendKeys("Fathi");
        Register_Page.email().sendKeys("Fatemaa@gmail.com");
        Register_Page.telephone().sendKeys("01063847464");
        Register_Page.password().sendKeys("Fatmh1448");
        Register_Page.confirmPassword().sendKeys("Fatmh1448");
        Register_Page.Subscribe().click();
        Register_Page.ContinueButton().click();
        securePage.Validation_Error_Message_Appear_for_Check_PrivacyPolicy();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }


    @AfterMethod
        public void quitBrowser() {
               driver.quit();
           }

       }

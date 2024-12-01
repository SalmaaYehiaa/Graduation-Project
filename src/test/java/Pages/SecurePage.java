package Pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;
import java.util.Random;

public class SecurePage {
    WebDriver driver;
    WebDriverWait wait;

    public SecurePage(WebDriverWait wait) {
        this.wait = wait;
    }

    public SecurePage(WebDriver driver) {
        this.driver = driver;


    }

    public boolean Valid_Register() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        return (Objects.equals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success"));
    }

    /*public void Validation_Message_for_valid_register() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed());


    }*/

    public void Validation_Error_Message_for_email_already_register() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());
    }

    public void Validation_Error_Message_for_wrong_confirmation_password() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")).isDisplayed());
    }

    public void Validation_Error_Message_for_wrong_first_name() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).isDisplayed());

    }

    public void Validation_Error_Message_for_wrong_Last_name() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).isDisplayed());

    }

    public void Validation_Error_Message_for_wrong_Email() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).isDisplayed());
    }

    public void Validation_Error_Message_Appear_for_wrong_Telephone() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).isDisplayed());
    }

    public void Validation_Error_Message_Appear_for_Invalid_Password() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).isDisplayed());
    }


    public void Validation_Error_Message_Appear_for_Check_PrivacyPolicy() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());
    }


/////////////////////////////////// Login Page ////////////////////////////////////////////////////////////////////////

    public boolean ValidLogin() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account");
        return (Objects.equals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account"));
    }

    public void validateErrorMessageAppearWhenLeavePasswordOrEmailFieldEmpty() {
        String Expected = "Warning: No match for E-Mail Address and/or Password.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void validateErrorMessageAppearLoginWithUnregisteredEmail() {
        String Expected = "Warning: No match for E-Mail Address and/or Password.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));

    }

////////////////////////////////////////////////////////////////ForgottenPassword//////////////////////////////////////////////////////////////////

    public void validateClickOnForgottenPassword() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/forgotten");
    }

    public void ValidateTheForgetPasswordFunctionalityWithValidEmail() {
        String Expected = "An email with a confirmation link has been sent your email address.";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-login\"]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }


    public void ValidateTheForgetPasswordFunctionalityWithInvalidEmail() {
        String Expected = "Warning: The E-Mail Address was not found in our records, please try again!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }
    //////////////////////////////////////////////////////////////SearchFunctionality/////////////////////////////////////////////////////////////////

    public void FindTheIntendedProduct() {

        String Expected = "Search - iPhone";
        String Actual = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
        //Assert.assertTrue(driver.findElement(By.className("col-sm-6 text-right")).isDisplayed());
    }

//////////////////////////////////////////////////////////////Currency/////////////////////////////////////////////////////////////////

    public void AssertCurrencyIsUS() {
        String Expected = "$";
        String Actual = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void AssertCurrencyIsEuro() {
        String Expected = "€";
        String Actual = driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }
//////////////////////////////////////////Hover Main and Sub Categories /////////////////////////////////////////////

    public void SeeSubcategories() {
        String Expected = "Mac (1)";
        String Actual = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }
    //////////////////////////////////Add Items To Wishlist//////////////////////////////////////////////////

    public void SeeAWishlistConfirmationMsg() throws InterruptedException {
        String Expected = "Success: You have added iPhone to your wish list!";
        Thread.sleep(500);
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void CompareListConfirmationMsg() throws InterruptedException {
        String Expected = "Success: You have added iPhone to your product comparison!";
        Thread.sleep(500);
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void SeeAShippingCartConfirmationMsg() throws InterruptedException {
        String Expected = "Success: You have added iPhone to your shopping cart!";
        Thread.sleep(500);
        String Actual = driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

    public void CreateAnOrderWithASuccessfulPayment() {
        String Expected = "Your order has been placed!";
        String Actual = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        System.out.println("Expected: " + Expected);
        System.out.println("Actual: " + Actual);
        Assert.assertTrue(Actual.contains(Expected));
    }

}
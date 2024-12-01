package Tests;

import Pages.Login_Page;
import Pages.SecurePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectTestCases {
    WebDriver driver;
    WebDriverWait wait;
    Pages.Login_Page Login_Page;
    SecurePage securePage;
    Actions actions;


    @BeforeMethod
    public void precondition3() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Login_Page = new Login_Page(driver);
        securePage = new SecurePage(driver);
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
        driver.findElement(By.className("caret")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
        Login_Page.EMailAddress().sendKeys("fatm44@gmail.com");
        Login_Page.password().sendKeys("Fatmh1448");
        Login_Page.LoginButton().click();
        actions = new Actions(driver);

    }

  @Test
  //TC19

  public void LoggedUsersCouldSearchForAnyProduct(){
        Login_Page.ClicksOnSearchTextBox().click();
        Login_Page.UserEnterTheIntendedProduct().sendKeys("iPhone");
        Login_Page.ClicksOnSearchButton().click();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        securePage.FindTheIntendedProduct();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

 }
 //////////////////////////////////////////SwitchCurrencies/////////////////////////////////////////////////////////////
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
  //////////////////////////////////////////Hover Main and Sub Categories /////////////////////////////////////////////
    @Test
    //TC22

  public void UserCanHoverRandomlyToElements() throws InterruptedException {
     WebElement El1 =Login_Page.Hovering_Randomly_El1();
     WebElement El2 = Login_Page.Hovering_Randomly_El2();
     WebElement El3 =Login_Page.Hovering_Randomly_El3();
     WebElement El4 =Login_Page.Hovering_Randomly_El4();
      actions.moveToElement(El1).perform();
      Thread.sleep(1000);
      actions.moveToElement(El2).perform();
      Thread.sleep(1000);
      actions.moveToElement(El3).perform();
      Thread.sleep(1000);
      actions.moveToElement(El4).perform();
      Thread.sleep(1000);
      securePage.SeeSubcategories();

  }

  /////////////////////////////////////Users Can Select Main and Sub  Categories Randomly////////////////////////////////////////
  @Test
  //TC 23

  public void UsersCanSelectMainCategoriesRandomly() throws InterruptedException {
   Login_Page.SelectMainCategoriesRandomly();
   Thread.sleep(1000);
  }

  @Test
  //TC 24

  public void SelectMainAndSubCategoriesRandomly() throws InterruptedException {
        Login_Page.SelectMainAndSubCategoriesRandomly();
      Thread.sleep(1000);
  }
     //////////////////////////////////Add Items To Wishlist///////////////////////////////////////////////////////////////////////

    @Test
    //TC 25
public void  AddItemsToWishlist () throws InterruptedException {
        Login_Page.ClicksOnSearchTextBox().click();
        Login_Page.UserEnterTheIntendedProduct().sendKeys("iPhone");
        Login_Page.ClicksOnSearchButton().click();
        Login_Page.AddItemToWishlist().click();
        securePage.SeeAWishlistConfirmationMsg();
        Thread.sleep(1000);

    }
    //////////////////////////////////Add Items To CompareList///////////////////////////////////////////////////////////////////////
@Test
  //TC 26
 public void AddItemsToCompareList() throws InterruptedException {
    Login_Page.ClicksOnSearchTextBox().click();
    Login_Page.UserEnterTheIntendedProduct().sendKeys("iPhone");
    Login_Page.ClicksOnSearchButton().click();
    Login_Page.AddItemToCompareList().click();
    securePage.CompareListConfirmationMsg();
    Thread.sleep(1000);
}
    //////////////////////////////////Add Items To Shipping cart///////////////////////////////////////////////////////////////////////
    @Test
  //TC 27
    public void AddItemsToShippingCart() throws InterruptedException {
        Login_Page.ClicksOnSearchTextBox().click();
        Login_Page.UserEnterTheIntendedProduct().sendKeys("iPhone");
        Login_Page.ClicksOnSearchButton().click();
        Login_Page.AddItemToShippingCart().click();
        securePage.SeeAShippingCartConfirmationMsg();
        Thread.sleep(1000);

    }

    @Test
    //TC 28
    public void CreateAnOrderWithASuccessfulPayment() throws InterruptedException {
        Login_Page.ClicksOnSearchTextBox().click();
        Login_Page.UserEnterTheIntendedProduct().sendKeys("iPhone");
        Login_Page.ClicksOnSearchButton().click();
        Login_Page.AddItemToShippingCart().click();
        Thread.sleep(1000);
        Login_Page.GoToTheShippingCart().click();
        Login_Page.GoToTheCheckoutPage().click();


        // steps for first Time in Account
        /*
        Login_Page.enterValidFirstNameCheckout().sendKeys("Fatema");
        Login_Page.enterValidLastNameCheckout().sendKeys("Fathi");
        Login_Page.enterValidCompanyCheckout().sendKeys("Depi");
        Login_Page.enterValidCityCheckout().sendKeys("Mansoura");
        Login_Page.enterValidArAddress1Checkout().sendKeys("Aga");
        Login_Page.enterValidAddress2Checkout().sendKeys("Talkha");
        Login_Page.ChoosesValidCountryCheckout();
        securePage.userChoosesValidRegionCheckout();
       Login_Page.ClicksOnContinueButtonBillingCheckout().click();
       */
        Thread.sleep(5000);
       Login_Page.ClicksOnContinueButtonBillingCheckout().click();
        Thread.sleep(5000);
       Login_Page.ClicksOnContinueButtonDeliveryCheckout().click();
        Thread.sleep(5000);
       Login_Page.ClicksOnContinueButtonDeliveryMethodCheckout().click();
        Thread.sleep(5000);
       Login_Page.MarkOnAgreeToTheTermsAndConditions().click();
        Thread.sleep(5000);
       Login_Page.ClicksOnContinueButtonPaymentMethodCheckout().click();
        Thread.sleep(5000);
       Login_Page.ClicksOnContinueButtonConfirmOrderCheckout().click();
        Thread.sleep(5000);

    }

    @AfterMethod
    public void quiteBrowser() throws InterruptedException {
        driver.quit();
    }



}
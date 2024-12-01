package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Login_Page {
    WebDriver driver;
    WebDriverWait wait;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public Login_Page(WebDriverWait wait) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public WebElement EMailAddress() {
        return driver.findElement(By.id("input-email"));
    }

    public WebElement password() {
        return driver.findElement(By.id("input-password"));
    }

    public WebElement LoginButton() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input[1]"));
    }

    ///////////////////////////////////////////////////////////ForgottenPassword//////////////////////////////////////////

    public WebElement ForgottenPassword() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a"));

    }

    public WebElement ForgottenPasswordEmail() {
        return driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
    }

    public WebElement ForgottenPasswordContinueButton() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
    }
//////////////////////////////////////////////////////////////SearchFunctionality/////////////////////////////////////////////////////////////////

    public WebElement ClicksOnSearchTextBox() {
        return driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
    }

    public WebElement UserEnterTheIntendedProduct() {
        return driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
    }

    public WebElement ClicksOnSearchButton() {
        return driver.findElement(By.xpath("//*[@id=\"search\"]/span/button"));
    }

    //////////////////////////////////////////////////////////////Currency/////////////////////////////////////////////////////////////////
    public WebElement CurrencyDropDownList() {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div"));
    }

    public WebElement Currency_US_Selected() {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]"));
    }

    public WebElement Currency_Euro_Selected() {
        return driver.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]"));
    }

    //////////////////////////////////////////Hover Main and Sub Categories ///////////////////////////////////////////////////
    public WebElement Hovering_Randomly_El1() {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a"));
    }

    public WebElement Hovering_Randomly_El2() {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/div/ul/li[1]/a"));
    }

    public WebElement Hovering_Randomly_El3() {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]"));
    }

    public WebElement Hovering_Randomly_El4() {
        return driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a"));
    }


    public void SelectMainCategoriesRandomly() {
        // Locate the main category dropdown
        WebElement mainDropdown = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));
        mainDropdown.click(); // Click to open the dropdown

        // Get all options from the main category dropdown
        List<WebElement> mainOptions = driver.findElements(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));

        // Generate random index for main categories
        Random random = new Random();
        int randomMainIndex = random.nextInt(mainOptions.size());

        // Select a random main category
        System.out.println("Selected Main Category: " + mainOptions.get(randomMainIndex).getText());
        mainOptions.get(randomMainIndex).click(); // Click on the randomly selected option

    }

    public void SelectMainAndSubCategoriesRandomly() {

        // Locate the main category dropdown
        WebElement mainDropdown = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));
        mainDropdown.click(); // Click to open the dropdown

        // Get all options from the main category dropdown
        List<WebElement> mainOptions = driver.findElements(By.xpath("//*[@id=\"menu\"]/div[2]/ul"));
        Random random = new Random();
        int randomMainIndex = random.nextInt(mainOptions.size());

        // Select a random main category
        System.out.println("Selected Main Category: " + mainOptions.get(randomMainIndex).getText());
        mainOptions.get(randomMainIndex).click(); // Click on the randomly selected option

    }
    //////////////////////////////////Add Items To Wishlist//////////////////////////////////////////////////

    public WebElement AddItemToWishlist() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[2]"));
    }
    //////////////////////////////////Add Items To Compare List//////////////////////////////////////////////////


    public WebElement AddItemToCompareList() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[3]/i"));

    }
    //////////////////////////////////Add Items To Shipping Cart//////////////////////////////////////////////////


    public WebElement AddItemToShippingCart() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]"));
    }


    ////////////////////////////////// Create an order with a successful payment//////////////////////////////////////////////////

    public WebElement GoToTheShippingCart() {
        return driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span"));
    }

    public WebElement GoToTheCheckoutPage() {
        return driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a"));
    }


    /////
    public WebElement enterValidFirstNameCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]"));
    }

    public WebElement enterValidLastNameCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-lastname\"]"));
    }

    public WebElement enterValidCompanyCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-company\"]"));
    }

    public WebElement enterValidArAddress1Checkout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-address-1\"]"));
    }

    public WebElement enterValidAddress2Checkout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-address-2\"]"));
    }

    public WebElement enterValidCityCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-city\"]"));
    }

    public WebElement enterValidPostCodeCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"input-payment-postcode\"]"));
    }

    public void ChoosesValidCountryCheckout() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]"));
        Select List_ele = new Select(element);
        List_ele.selectByValue("62");
    }

    public void ChoosesValidRegionCheckout() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]"));
        Select List_ele = new Select(element);
        List_ele.selectByValue("1002");


    }

    public WebElement userChoosesValidRegionCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]"));
    }


    ////

    public WebElement ClicksOnContinueButtonBillingCheckout() {
        return driver.findElement(By.cssSelector("input[id=\"button-payment-address\"]"));           // done
    }

    public WebElement ClicksOnContinueButtonDeliveryCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]"));           // done
    }

    public WebElement ClicksOnContinueButtonDeliveryMethodCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]"));            // done
    }

    public WebElement ClicksOnContinueButtonPaymentMethodCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]"));            // done
    }

    public WebElement MarkOnAgreeToTheTermsAndConditions(){
        return driver.findElement(By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]"));            // done

    }

    public WebElement ClicksOnContinueButtonConfirmOrderCheckout() {
        return driver.findElement(By.xpath("//*[@id=\"button-confirm\"]"));            // done
    }
}
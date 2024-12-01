package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Register_Page {
    WebDriver driver ;
    WebDriverWait wait;

    public Register_Page(WebDriver driver) {
        this.driver = driver;
        this.wait =new WebDriverWait(driver,Duration.ofSeconds(5));

    }

    public WebElement firstname(){
          return driver.findElement(By.name("firstname"));
    }
    public WebElement lastname(){
        return driver.findElement(By.name("lastname"));
    }
    public WebElement email(){
        return  driver.findElement(By.name("email"));
    }
    public WebElement telephone(){
        return  driver.findElement(By.name("telephone"));
    }
    public WebElement password(){
        return driver.findElement(By.name("password"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.name("confirm"));
 }

    public WebElement Subscribe(){
        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input"));
 }
    public WebElement PrivacyPolicy(){
        return driver.findElement(By.name("agree"));
    }
    public WebElement ContinueButton(){
        return driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));

    }



}

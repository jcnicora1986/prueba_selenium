import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingRegisterPage extends BasePage {


    public BookingRegisterPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void fillingInvalidEmailSignIn(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String email = faker_data.name().firstName();
        System.out.println("---> utilizo el siguiente alias para dar error: " + email);
        driver.findElement(By.id("username")).sendKeys(email);

    }

    public void fillingValidEmailSignIn(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String email = faker_data.internet().emailAddress();
        System.out.println("---> utilizo el siguiente email: " + email);
        driver.findElement(By.id("username")).sendKeys(email);

    }

    public void clickOnContinueEmail(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Continue with email')]")).click();
    }


    public WebElement getErrorMsgEmailInvalid(){
        List<WebElement> errorMessageListEmail = driver.findElements(By.className("bui-form__error"));
        WebElement errMsg = errorMessageListEmail.get(0);
        return errMsg;
    }

    public void InvalidPassCreateAccount(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String pass1 = faker_data.internet().password();
        String pass2 = faker_data.internet().password();
        System.out.println("--->  " + pass1 + ">---" + pass2 );
        driver.findElement(By.id("new_password")).sendKeys(pass1);
        driver.findElement(By.id("confirmed_password")).sendKeys(pass2);

    }

    public WebElement getErrorPassDiferentes(){
        List<WebElement> errorMsgPassDiferentes = driver.findElements(By.id("confirmed_password-description"));
        WebElement errMsg = errorMsgPassDiferentes.get(0);
        return errMsg;
    }

    public void clickCreateAccount(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Create account')]")).click();
    }
}

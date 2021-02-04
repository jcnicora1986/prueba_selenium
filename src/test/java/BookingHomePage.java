import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingHomePage extends BasePage{

    public BookingHomePage selectLanguage(){
        driver.findElement(By.xpath("//img[@class='bui-avatar__image']")).click();
        driver.findElement(By.xpath("//div[@lang='en-us']")).click();
        BookingHomePage nextPage= new BookingHomePage(driver);
        return nextPage;
    }

    public BookingHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String validarTituloTest(){
        return driver.getTitle();
    }

    public List<WebElement> getLink(){
        return driver.findElements(By.tagName("a"));
    }

    public List<WebElement> getH1s(){
        return driver.findElements(By.tagName("h1"));
    }
    public List<WebElement> getH2s(){
        return driver.findElements(By.tagName("h2"));
    }

    public BookingHomePage clickBtnSignIn(){
        driver.findElement(By.xpath("(//span[@class='bui-button__text'][contains(text(), 'Sign in')])[1]")).click();
        BookingHomePage nextPage= new BookingHomePage(driver);
        return nextPage;
    }

    public BookingHomePage clickBtnRegister(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Register')]")).click();
        BookingHomePage nextPage= new BookingHomePage(driver);
        return nextPage;
    }




}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingHomePage extends BasePage{

    public BookingHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String validarTituloTest(){
        return driver.getTitle();
    }

    public List<WebElement> getLink(){
        return driver.findElements(By.tagName("a"));
    }


}

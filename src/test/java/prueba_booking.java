import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class prueba_booking {

    //WebDriver driver;

    @Test
    public void ingresarBooking(){
        System.setProperty("webdriver.chrome.driver", "");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.booking.com");
        //System.out.println(driver.getTitle());
        driver.close();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


}

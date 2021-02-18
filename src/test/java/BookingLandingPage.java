import org.openqa.selenium.WebDriver;

public class BookingLandingPage extends BasePage{


    public BookingLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public BookingRegisterPage navigateToBtnSignIn(){
        driver.navigate().to("https://account.booking.com/sign-in");
        BookingRegisterPage nextPage = new BookingRegisterPage(driver);
        return nextPage;
    }

    }

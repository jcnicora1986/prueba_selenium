import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class prueba_booking extends BasePage {

    @BeforeMethod
    public void ingresarBooking() {
        driver.get("https://www.booking.com");
    }

    @Test
    public void validarTitulo() {

        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        String tituloBooking = bookingHomePage.validarTituloTest();

        System.out.println(">---" + tituloBooking);

        Assert.assertEquals(tituloBooking, "Booking.com | Official site | The best hotels & accommodations");
    }

    @Test
    public void mostarLinksTest(){

        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        List<WebElement> linkList = bookingHomePage.getLink();
        System.out.println(linkList.size());

        for (WebElement link : linkList) {
            System.out.println(">---"+link.getAttribute("href"));
        }

        String url = "";
        List<String> brokenLinks= new ArrayList<String>();
        List<String> okLinks= new ArrayList<String>();

        HttpURLConnection httpConnection= null;
        int responseCode=200;
        Iterator<WebElement> it = linkList.iterator();

        while (it.hasNext()){
            url=it.next().getAttribute("href");
           if(url==null || url.isEmpty()){
            System.out.println(url + "url no tiene configurado o esta vacia");
            continue;
           }
           try{
               httpConnection= (HttpURLConnection)(new URL(url).openConnection());
               httpConnection.setRequestMethod("HEAD");
               httpConnection.connect();
               responseCode = httpConnection.getResponseCode();

               if(responseCode>400){
                   System.out.println("Error link---" +url );
                   brokenLinks.add(url);
               }else{
                   System.out.println("Ok Link---"+url);
                   okLinks.add(url);
               }
           }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("ok Links= "+okLinks.size() );
        System.out.println("broken Links= "+brokenLinks.size() );

        if(brokenLinks.size()>0){
            System.out.println("ERROR BROKEN LINKS");
            for (int i=0; i< brokenLinks.size(); i++) {
                System.out.println(">---"+ brokenLinks.get(i));

            }

        }
        }




    }



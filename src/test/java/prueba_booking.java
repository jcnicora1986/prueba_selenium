import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Test;

public class prueba_booking extends BasePage {

    @BeforeMethod
    public void ingresarBooking() {
        driver.get("https://www.booking.com");
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.selectLanguage();

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
    @Test
    public void mostarH1sTest(){

        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        List<WebElement> listH1 = bookingHomePage.getH1s();
        System.out.println("Total de H1 encontrados>---"+listH1.size());

        for (WebElement h1 : listH1) {
            System.out.println(">--"+h1.getText());
            //if (h1.getText().equals("Set up your store, pick a plan later")) {
              //  h1Found = true;
            }
        }
    @Test
    public void buscarGenteViajeraTest(){

        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        List<WebElement> listH2 = bookingHomePage.getH2s();
        System.out.println("Total de H2 encontrados>---"+listH2.size());
        boolean h2Found = false;

        for (WebElement h2 : listH2) {
            System.out.println(h2.getText());
            if (h2.getText().equals("Connect with other travellers")) {
                h2Found = true;
            }

        }Assert.assertTrue(h2Found);

        //*[contains(text(), 'Connect with other travellers')]

    }   @Test
        public void registroUsuarioTests(){
        //10.a
        BookingHomePage bookingHomePage = new BookingHomePage(driver);
        bookingHomePage.clickBtnSignIn();

        BookingRegisterPage bookingRegisterPage = new BookingRegisterPage(driver);
        bookingRegisterPage.fillingInvalidEmailSignIn();

        bookingRegisterPage.clickOnContinueEmail();

        WebElement errorMsgEmail = bookingRegisterPage.getErrorMsgEmailInvalid();
        System.out.println("El msj de error es: "+errorMsgEmail.getText());
        Assert.assertEquals(errorMsgEmail.getText(),"Make sure the email address you entered is correct.");
        //Make sure the email address you entered is correct.

        //No aparece:
        //la opcion para registrar
        //el error de que no esta asociada la cuenta.
        //10.b el boton para registrarse

        //10.c
        ingresarBooking();
        bookingHomePage.clickBtnRegister();
        bookingRegisterPage.fillingValidEmailSignIn();
        bookingRegisterPage.clickOnContinueEmail();
        //10.d
        bookingRegisterPage.InvalidPassCreateAccount();
        //10.e
        bookingRegisterPage.clickCreateAccount();
        WebElement errorMsgPassDiferentes = bookingRegisterPage.getErrorPassDiferentes();
        System.out.println("El msj de error es: "+errorMsgPassDiferentes.getText());
        Assert.assertEquals(errorMsgPassDiferentes.getText(),"The passwords you entered didn't match – try again");
    }



}






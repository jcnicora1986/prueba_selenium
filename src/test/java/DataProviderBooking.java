import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBooking {

    @DataProvider(name="emails")
    public Object[][] email(){
        return new Object[][] {
                {"", "false"},
                {"jj1com", "false"},
                {"jcarlos@.com", "false"}
        };
    }

    @Test (dataProvider = "emails")
    public void mostrarInfoTest(String nombre, Integer edad){
        System.out.println("Nombre: " + nombre + " y edad "+ edad);
    }

}

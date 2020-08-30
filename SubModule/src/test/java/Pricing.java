import api.SubModuleBase;
import org.testng.annotations.Test;

public class Pricing  extends SubModuleBase {


    @Test
    public void priceQuoteWithoutInput () throws Exception {

       priceQuote();
       takeTheScreenshot("priceQuoteWithoutInput");


    }
}

import api.SubModuleBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

/**
 * Author: Israt Uddin
 * Last Modified: 08/30/2020
 */

/**
 *Note:  I was told not to submit any form, so some actions are commented in logIn method. The login method can be enhanced to validate login functionality.
 *Verify "Email or mobile number is required" while attempting to login with no credentials.
 */

public class Login extends SubModuleBase  {


    @Test
    public void verifyLoginWithoutValidCredential() throws Exception {     // Change this loginWithoutAnyCredential to login or Userlogin

        logIn("7","2");   // These Data can be fetched from out side Source: Spreadsheet, Database

        {
            WebElement element = driver.findElement(By.cssSelector(".sc-kgoBCf"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
            sleepfor(1);

           /**
            * This will allow subit login form
            * driver.findElement(By.cssSelector(".sc-hzDkRC")).click();
            *sleepfor(1);
            *String actual =getTextByCss(".sc-hzDkRC");
            *Assert.assertEquals(LoginPage.expected_Error_Message_Invalid_Signin,actual);
            */

            takeTheScreenshot("Login");

    }

}
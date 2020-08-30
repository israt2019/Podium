import api.SubModuleBase;
import org.testng.annotations.Test;
import pageobject.AccountPage;

import pageobject.HomePage;
import pageobject.Learn;
import pageobject.LoginPage;


/**
 * Author: by Israt Uddin
 * Last Modified : 08/28/2020  @8:30 PM EST
 */


/**
 * The purpose of this class is to find & verify all the links available in the homepage.
 *
 */

public class HomePageLinkVerify extends SubModuleBase {


    @Test(priority = 1, enabled = false)//This is for Login link
    public void loginLink() throws InterruptedException {

        homePageLink(LoginPage.login_Button_LinkText,"Login");
    }

    @Test(priority = 2, enabled = true) //This is for Get Started Free link
    public void getStartedLink() throws InterruptedException {

        // This data can be fetched from spreadsheet
        homePageLink(AccountPage.getStartedFreeLink_LinkText,"Get Started Free Link");

    }


    @Test(priority = 3, enabled = true) //This is for Watch Demo link
    public void watchDemoLink() throws InterruptedException {

        homePageLink(Learn.watch_Demo_Link_Text,"Get Started Free Link");
    }


   @Test(priority = 4, enabled = true) // All home page link
   public void allHomePageLink() throws InterruptedException {

     homePageLink(HomePage.homePageLink_tag,"Home page");

    }

        }





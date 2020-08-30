package api;

import commonapi.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.AccountPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.PricingPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class SubModuleBase extends Base {

    /**
     * This testcase finds the valid and invalid links of home page
     * The first parameter is either tagname or link text. If it is for all the links tagName will be "a", or provide link text
     *The second parameter is the link name as to recognize where these link come from.
     */

    public void homePageLink(String locator, String linkName) throws InterruptedException {

        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = null;

        if(locator.contains("tag")){
            links = driver.findElements(By.tagName(locator));
        }

        else{
            links =  driver.findElements(By.linkText(locator));
        }



        Iterator<WebElement> it = links.iterator();

        int countBrokenLink=0;

        while(it.hasNext()){

            url = it.next().getAttribute("href");


            if(url == null || url.isEmpty()){
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }


            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();



                if(respCode >= 400){
                    System.out.println(url+" is a broken link");

                }
                else{
                    System.out.println(url+" is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("These are the links from "+ linkName);
        System.out.println("Broken Link: " +  countBrokenLink );


    }

    /**
     *
     * This method helps to log in
     */

    public void logIn(String emailORMobile, String password) throws InterruptedException {

        clickByLinkText(LoginPage.login_Button_LinkText); //Click in Login link
        typeById(LoginPage.emailMobile_Field_Id,emailORMobile);//Send email or phone input into Email or mobile field
        clickById(LoginPage.signIn_Button_Id); // Click Next button
        typeById(LoginPage.password_Field_Id,password);//Send password input into Password field
//        clickById(LoginPage.signIn_Button_Id); //Click on Sign in button


    }
    /**
     * This method allows to create an account
     */

    public void createAccount() throws Exception {

        clickByLinkText(AccountPage.getStartedFreeLink_LinkText); //Click Get Started Link
        typeById(AccountPage.firstName_Input_Field_Id,readFromExcel(testDataFilePath,"DataSheet","E3"));   // First Name : Data Source Spreadsheet
        typeById(AccountPage.lastName_Input_Field_Id,"");//data can be fetched from external source
        typeById(AccountPage.email_Input_Field_Id,"");//data can be fetched from external source
        typeById(AccountPage.phoneNum_Input_Field_Id,"");//data can be fetched from external source
        typeById(AccountPage.businessName_Input_Field_Id,"");//data can be fetched from external source
        clickById(AccountPage.createAccount_Button_Id);//Click Create account button

    }
    public void priceQuote () throws Exception {

        clickByLinkText(PricingPage.pricing_LinkText);// Click pricing link from footer
        typeById(PricingPage.firstName_Field_Id,readFromExcel(testDataFilePath,"DataSheet","E3")); //First Name field's input is fetched from Data Source Spreadsheet
        typeById(PricingPage.lastName_Field_Id,"");
        typeById(PricingPage.email_Field_Id,"");
        typeById(PricingPage.mobilePhone_Field_Id,"");
        typeById(PricingPage.company_Field_Id,"");
        /**
         * Click Get Pricing
         * clickByCss(PricingPage.getPricing_Css_Button);
         */

    }



}
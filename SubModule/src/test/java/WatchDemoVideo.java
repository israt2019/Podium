//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//
//import api.SubModuleBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;


import api.SubModuleBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobject.Learn;

import java.util.List;

public class WatchDemoVideo extends SubModuleBase {


    @Test(enabled = true)
    public void watchDemoVideoValidation() throws Exception {


        sleepfor(2);
        clickByLinkText(Learn.watch_Demo_Link_Text);// Click Watch Demo link
        clickByCss(".w-vulcan-v2-button > svg:nth-child(1)");// Click to hear sound
        sleepfor(5);
        clickByCss(".mktoButton");// Click continue watch button
        takeTheScreenshot("watchDemoVideoValidation");


    }
}





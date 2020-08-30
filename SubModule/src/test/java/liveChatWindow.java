import api.SubModuleBase;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobject.ChatBotPage;

import java.awt.*;
import java.util.List;

public class liveChatWindow extends SubModuleBase {
    @Test
    public void verifyliveChatWindow() throws Exception {
            sleepfor(1);
            driver.switchTo().frame(ChatBotPage.podium_Webchat_Widget_Bubble_IFrame_Id);
            sleepfor(1);
            driver.findElement(By.cssSelector(ChatBotPage.contactBubble_PolygonIcon_Button_CSSSelecto)).click();
            sleepfor(1);
            driver.findElement(By.cssSelector(ChatBotPage.contactBubble_CloseSvgIcon_Button_CSSSelector)).click();
            takeTheScreenshot("verifylivechat");
        }

}









package commonapi;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Israt Uddin
 */
public class Base {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(Base.class.getName());



    // File Path Variables. These paths need to changed based on file location

    public static String testDataFilePath = "C:\\Users\\Israt\\Desktop\\podium\\SubModule\\src\\main\\resources\\TestData\\Podium_Test_Data.xlsx";
    public static String chromeDriverPath = "C:\\Users\\Israt\\Desktop\\podium\\Generic\\src\\main\\resources\\drivers\\chromedriver.exe";
    public static String screenshotPath = "C:\\Users\\Israt\\Desktop\\podium\\SubModule\\src\\main\\resources\\TestResult\\Screenshot";


    @Parameters({"useSauceLab", "userName", "key", "appUrl", "os", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(boolean useSauceLab, String userName, String key, String appUrl, String os, String browserName, String browserVersion) throws IOException {
        if (useSauceLab == true) {
            getSauceLabDriver(userName, key, os, browserName, browserVersion);
        } else {
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(appUrl);
        driver.manage().window().maximize();
        log.info("browser loaded with App");
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        sleepfor(2);
        log.info("driver is quiting");
        sleepfor(2);
        driver.quit();
    }

    //get local driver
    public WebDriver getLocalDriver(String os, String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            } else {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "Generic\\selenium-browser- driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("htmlunit")) {
            //driver = new HtmlUnitDriver();
        }
        return driver;
    }

    //get cloud driver
    public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName, String
            browserVersion) throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browserName);
        cap.setCapability("version", browserVersion);
        driver = new RemoteWebDriver(new URL("http://" + userName + ":" + key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);
        return driver;
    }


    public void sleepfor(int value) throws InterruptedException {
        int initvalue = (value * 1000);
        Thread.sleep(initvalue);
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }

    public void getTitle() {
        driver.getTitle();
    }

    public void typeByCssThenEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String s, String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(s);
    }

    public void typeByCss(String locator, String text) {
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }


     public void clickByLinkText(String linkText) {
         driver.findElement(By.linkText(linkText)).click();
     }

//
    public String getText(String locator) {
        return  (driver.findElement(By.xpath(locator)).getText());
   }

    public String getTextByCss(String locator) {
        return  (driver.findElement(By.cssSelector(locator)).getText());
    }

    public void typeById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }


    public static String readFromExcel(String fileRef, String sheetRef, String cellRef) throws IOException {
        FileInputStream fis = new FileInputStream(fileRef);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetRef);
        DataFormatter formatter = new DataFormatter();
        CellReference cellReference = new CellReference(cellRef);
        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getCol());
        String value = "";
        if (cell != null) {
            value = formatter.formatCellValue(cell);//cell.getStringCellValue();
        }
        return value;
    }

    public static void writeFromExcel(String sheetRef, int rowRef, int colRef, String value) throws IOException {
        try {

            // Specify the file path which you want to create or write
            File src = new File(testDataFilePath);

            FileInputStream fis = new FileInputStream(src); // Load the file

            XSSFWorkbook wb = new XSSFWorkbook(fis);   // load the workbook


            XSSFSheet sh1 = wb.getSheetAt(0);   // get the sheet which you want to modify or create

            // here createCell will create column and setCellvalue will set the value
            sh1.getRow(rowRef).createCell(colRef).setCellValue(value);

            // here we need to specify where you want to save file
            FileOutputStream fout=new FileOutputStream(new File(testDataFilePath));

            wb.write(fout);  // finally write content

            fout.close();// close the file

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }


    public void takeTheScreenshot(String testCaseName) throws Exception {
        String name = "";
        System.out.println(name);

        System.out.println("------------------------------");
        Thread.sleep(3000);
        String screenShotLocation = screenshotPath;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
        Date date = new Date();
        String currentTime = dateFormat.format(date); //2016/11/16 12:08:43
        System.out.println("---------------------"+currentTime);

        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenShotLocation + testCaseName + "_" +currentTime + ".png");
        FileUtils.copyFile(SrcFile, DestFile);
    }

}


package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;


    public void setupAutomationSuite() {
        System.out.println("Start Automation test");
    }

    public void closeAutomationsuite() {
        System.out.println("Close Automation test");
    }

    @BeforeMethod
    public static void createDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

//    public static void createDriver(String driverType) {
//        switch (driverType.toLowerCase()) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                driver.manage().window().maximize();
//                //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
////                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
////                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//                //driver.get(string_URL);
//            }
//            case "firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                driver.manage().window().maximize();
//                //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//                //driver.get(string_URL);
//            }
//            case "edge" -> {
//                WebDriverManager.edgedriver().setup();
//                driver = new EdgeDriver();
//                driver.manage().window().maximize();
//                //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//                //driver.get(string_URL);
//            }
//            default -> {
//                System.out.println("Invalid browser input, start Chrome browser by default.");
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                driver.manage().window().maximize();
//                //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//                //driver.get(string_URL);
//            }
//        }
//    }

    @AfterMethod
    public static void closeDriver() {
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        if (driver != null) {
            driver.quit();
        }
    }

//    public WebElement waitForElementVisible(By by, int timeout){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
//        return driver.findElement(by);
//    }
}

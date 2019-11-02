package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * All will be initialized in this class:
 * WebDriver
 * Properties
 * Logs
 * ExtentReports
 * DB
 * Excel
 * Mail
 */
public class TestBase {

    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fileInputStream;

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {

        if (driver == null) {
            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resoureces\\properties\\Config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resoureces\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (config.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resoureces\\executables\\gecko.exe");
            driver = new FirefoxDriver();
        } else if (config.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resoureces\\executables\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("IE")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resoureces\\executables\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.get(config.getProperty("testSuitUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}

package TCAssignmentScenarios.TestHelpers;

import TCAssignmentHelpers.PagesHelpers.CheckoutPageHelper;
import TCAssignmentHelpers.PagesHelpers.SignUpHelper;
import TCAssignmentHelpers.PagesHelpers.StcLandingPageHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;

    public StcLandingPageHelper StcLanding;
    public SignUpHelper SignUp;

    public CheckoutPageHelper Checkout;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//TCAssignmentHelpers//Resources//GlobalData.properties");
        prop.load(fis);

        String BrowserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        if (BrowserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
 //           options.addArguments("--headless"); // Enable headless mode
//            options.addArguments("--no-sandbox"); // Enable for linux Jenkins
//            options.addArguments("--disable-gpu"); // Enable for linux Jenkins
//            options.setBinary("/usr/bin/google-chrome"); // Enable for linux Jenkins
            options.addArguments("--window-size=1920,1080"); 
            driver = new ChromeDriver(options);
        } else if (BrowserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true); // Enable headless mode
            driver = new FirefoxDriver(options);
        } else if (BrowserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless"); // Enable headless mode
            driver = new EdgeDriver(options);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        StcLanding = new StcLandingPageHelper(driver);
        SignUp = new SignUpHelper(driver);
        Checkout = new CheckoutPageHelper(driver);

        return driver;
    }

    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return testCaseName + ".png";
    }

    public static void cleanupExtentReport() {
        // Define the absolute path to the directory containing the reports
        String reportsDirectoryPath = System.getProperty("user.dir") + "/reports";

        // Create a File object representing the directory
        File reportsDirectory = new File(reportsDirectoryPath);

        // Check if the directory exists and delete it recursively
        if (reportsDirectory.exists()) {
            if (deleteDirectory(reportsDirectory)) {
                System.out.println("Reports directory and its contents deleted successfully.");
            } else {
                System.err.println("Failed to delete the reports directory.");
            }
        } else {
            System.out.println("Reports directory does not exist.");
        }
    }

    public static boolean deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);
                    } else {
                        if (!file.delete()) {
                            return false;
                        }
                    }
                }
            }
        }
        return directory.delete();
    }

    @BeforeSuite
    public void cleanUp() {
        cleanupExtentReport();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException{
        driver = initializeDriver();
        StcLanding.navigateToStc();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

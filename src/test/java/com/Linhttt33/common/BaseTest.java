package com.Linhttt33.common;

import com.Linhttt33.drivers.DriverManager;
import com.Linhttt33.helpers.PropertiesHelper;
import com.Linhttt33.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({TestListener.class})
public class BaseTest {

    @BeforeTest
    @Parameters({"browserName"})
    public void createDriver(@Optional("chrome") String browserName) {

        WebDriver driver;

        if (!PropertiesHelper.getValue("BROWSER").isEmpty() || PropertiesHelper.getValue("BROWSER") != null) {
            browserName = PropertiesHelper.getValue("BROWSER");
        }
        System.out.println(browserName);

        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver); //Set to ThreadLocal

        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"))));
    }

    @AfterTest
    public void closeDriver(ITestResult iTestResult) {
        DriverManager.quit();
    }

}

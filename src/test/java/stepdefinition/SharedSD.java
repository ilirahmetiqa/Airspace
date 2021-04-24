package stepdefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;
import java.util.concurrent.TimeUnit;

public class SharedSD {

    private static WebDriver driver = null;

    @Before
    public static void before() {
        ConfigReader ConfigReader = new ConfigReader();
            System.setProperty("webdriver.chrome.driver", ConfigReader.getDriverLocation());
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.get(ConfigReader.getUrl());
    }

    @After
    public static void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}

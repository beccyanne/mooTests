package com.moo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by amir on 13/12/2016.
 */
public class BaseTests {

    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        setChromeDriver();
        driver = new ChromeDriver();
    }

    private static void setChromeDriver() {
        String os = System.getProperty("os.name");
        String usrDir = System.getProperty("user.dir");

        if (os != null && os.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium_standalone_binaries/osx/googlechrome/64bit/chromedriver");
        }
        else if(os != null && os.contains("Win")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium_standalone_binaries/win/googlechrome/64bit/chromedriver");
        }
        else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/selenium_standalone_binaries/linux/googlechrome/64bit/chromedriver");
        }
    }

    @AfterTest
    public void tearDown() {
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

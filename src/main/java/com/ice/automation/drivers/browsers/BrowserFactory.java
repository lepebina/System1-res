package com.ice.automation.drivers.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Static factory for browser instantiation using one of the following drivers:
 * Safari
 * Chrome
 * Firefox
 */
@Service("BrowserFactory")
public class BrowserFactory {

    @Value("#{properties['chrome_driver_path']}")
    private String chromeDriverPath;

    /**
     * Static factory for Safari browser instantiation
     *
     * @return Instance of webDriver for Safari
     */
    private static WebDriver createSafariDriver() {
        return new SafariDriver();
    }

    /**
     * Static factory for Chrome browser instantiation
     *
     * @return Instance of webDriver for Chrome
     */
    private static WebDriver createChromeDriver() {
        return new ChromeDriver();
    }

    /**
     * Static factory for Firefox browser instantiation
     *
     * @return Instance of webDriver for Firefox
     */
    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
    }

    /**
     * Initialization of driver for the below setup properties:
     * 1. Timeout
     * 2. Browser position
     */
    private static void initBrowserSetup(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setPosition(new org.openqa.selenium.Point(0, 0));
    }

    /**
     * Instantiates webDriver based on input browser
     *
     * @return Instance of webDriver based on input browser
     */
    public WebDriver initBrowser(Browsers browser) {
        WebDriver driver;

        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = createChromeDriver();
                break;
            case SAFARI:
                driver = createSafariDriver();
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                break;
            default:
                driver = createFirefoxDriver();
                break;
        }
        initBrowserSetup(driver);
        return driver;
    }
}

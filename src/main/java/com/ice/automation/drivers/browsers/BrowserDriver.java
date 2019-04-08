package com.ice.automation.drivers.browsers;

import com.ice.automation.cache.InitialCachedData;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * WebDriver service used in order to access page objects through a browser's instance
 */
@Service("BrowserDriver")
public class BrowserDriver {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserDriver.class);
    @Autowired
    BrowserFactory browserFactory;
    @Value("#{properties['testBrowser']}")
    private String testBrowser;
    private WebDriver mDriver;


    /**
     * @return WebDriver instance based either property file value or cached data value
     */
    public synchronized WebDriver getCurrentDriver() {
        Browsers browser = null;
        if (mDriver == null) {

            browser = Browsers.getBrowserForName(testBrowser);

            }
            try {
                mDriver = browserFactory.initBrowser(browser);
            } catch (UnreachableBrowserException e) {
                mDriver = browserFactory.initBrowser(browser);
            } catch (WebDriverException e) {
                mDriver = browserFactory.initBrowser(browser);
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

        return mDriver;
    }

    /**
     * Closes the browser and destroys it's instance
     */
    public void close() {
        try {
            getCurrentDriver().quit();
            mDriver = null;
            LOGGER.info("closing the browser");
        } catch (UnreachableBrowserException e) {
            LOGGER.info("cannot close browser: unreachable browser");
        }
    }

    /**
     * Loads url on webDriver instance
     */
    public void loadPage(String url) {
        LOGGER.info("Directing browser to:" + url);
        getCurrentDriver().get(url);
    }

    /**
     * Terminates webDriver's thread
     */
    private class BrowserCleanup implements Runnable {
        public void run() {
            LOGGER.info("Closing the browser");
            close();
        }
    }


}

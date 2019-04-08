package com.ice.automation.utils;

import com.ice.automation.drivers.browsers.BrowserDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Implementation for ScreenShot generation from webDrivers browser
 * This is used mostly for debug and ticketing purposes
 */
@Service("ScreenShotMaker")
public class ScreenShotMaker {

    @Autowired
    BrowserDriver browserDriver;
    @Value("#{properties['screenshot_path']}")
    private File screenShotPath;

    /**
     * Generates screenShot file
     *
     * @return ScreenShot file
     */
    public File getScreenShot() {
        return ((TakesScreenshot) browserDriver.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
    }

    /**
     * Puts screenShot to specified location (i.e. screenShotPath)
     *
     * @throws IOException
     */
    public void addScreenShotToFile() throws IOException {
        FileUtils.copyFile(getScreenShot(), screenShotPath);
    }

}

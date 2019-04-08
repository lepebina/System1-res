package com.ice.automation.ui.pagecontrollers.impl;

import com.ice.automation.ui.pagecontrollers.PageController;
import com.ice.automation.drivers.browsers.BrowserDriver;
import com.ice.automation.ui.pages.GoogleSearchPage;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Page Controller for Google home search pageObject
 */
@Controller("genericPageController")
public class GenericPageControllerImpl implements PageController {

    @Autowired
    BrowserDriver browserDriver;
    @Autowired
    GoogleSearchPage googleSearchPage;

    /**
     * Initializes elements of google home search pageObject using Selenium's PageFactory
     */
    public void initializeElementsForAllPages() {
        PageFactory.initElements(browserDriver.getCurrentDriver(), googleSearchPage);
    }

}

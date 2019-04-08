package com.ice.automation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Service;

/**
 * Page Object for Google home search page
 */
@Service
public class GoogleSearchPage {

    /**
     * Element for search text box located by name
     */
    @FindBy(how = How.NAME, using = "q")
    public WebElement searchTextBox;

}

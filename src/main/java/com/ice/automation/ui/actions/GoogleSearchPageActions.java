package com.ice.automation.ui.actions;

import com.ice.automation.ui.pages.GoogleSearchPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("googleSearchPageActons")
public class GoogleSearchPageActions {

    @Autowired
    GoogleSearchPage googleSearchPage;

    /**
     * Enters text in google search text box and submits query
     *
     * @param text Query text for googling
     */
    public void searchFor(String text) {
        googleSearchPage.searchTextBox.sendKeys(text);
        googleSearchPage.searchTextBox.submit();
    }
}

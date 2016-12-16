package com.moo.modules;

import com.moo.pages.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by amir on 15/12/2016.
 */
public class SearchModule extends BaseModule {

    @FindBy(css = "input#query")
    private WebElement searchInputBox;

    @FindBy(css = "button[class^='search__btn']")
    private WebElement searchButton;

    public SearchModule(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchFor(String searchTerm) {
        searchInputBox.clear();
        searchInputBox.sendKeys(searchTerm);
        searchButton.click();
        SearchResultsPage srp = new SearchResultsPage(driver);
        srp.waitForSearchResultsToAppear();
        return srp;
    }
}

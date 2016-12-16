package com.moo.pages;

import com.moo.modules.BaseModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amir on 15/12/2016.
 */
public class SearchResultsPage extends BaseModule {

    @FindBy(css = "div[class='gsc-results gsc-webResult']")
    private WebElement resultsSection;

    @FindAll(@FindBy(css = "div[class='gsc-webResult gsc-result']"))
    private List<WebElement> resultsList;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSearchResultsToAppear() {
        waitForElementToAppear(resultsSection);
    }

    public int getNumberOfSearchResults() {
        return resultsList.size();
    }

    public boolean searchResultsPageShouldContainResults() {
        return getNumberOfSearchResults() > 1;
    }

    public boolean searchResultsTitleShouldContainSearchTerm(String searchTerm) {
        List<Boolean> containsSearchTerm = new ArrayList<>(0);

        for(WebElement element : resultsList) {
            String title = element.findElement(By.cssSelector("div.gs-title")).getText();
            System.out.println(title);
            containsSearchTerm.add(title.toLowerCase().contains(searchTerm.toLowerCase()));
        }

        return !containsSearchTerm.contains(Boolean.FALSE);
    }

    public boolean searchResultsShouldBeEmpty() {
        System.out.println(getNumberOfSearchResults());
        return getNumberOfSearchResults() == 1;
    }
}

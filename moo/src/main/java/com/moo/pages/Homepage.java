package com.moo.pages;

import com.moo.modules.BaseModule;
import com.moo.modules.SearchModule;
import org.openqa.selenium.WebDriver;

/**
 * Created by amir on 15/12/2016.
 */
public class Homepage extends BaseModule {

    public SearchModule searchModule;

    public Homepage(WebDriver driver) {
        super(driver);
        searchModule = new SearchModule(driver);
    }

    public Homepage navigateToHomepage() {
        driver.navigate().to("http://www.moo.com");
        return this;
    }
}

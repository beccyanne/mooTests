package com.moo.tests.search;

import com.moo.pages.Homepage;
import com.moo.pages.SearchResultsPage;
import com.moo.tests.BaseTests;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by amir on 15/12/2016.
 */
public class ProductSearchTests extends BaseTests {

    Homepage homepage;
    SearchResultsPage srp;

    @Test
    public void search_for_valid_product_should_return_results() {
        String searchTerm = "Business Card";
        homepage = new Homepage(driver);
        homepage.navigateToHomepage();
        srp = homepage.searchModule.searchFor(searchTerm);
        Assert.assertTrue("No search returned", srp.searchResultsPageShouldContainResults());
        Assert.assertTrue("Title didn't contain search term", srp.searchResultsTitleShouldContainSearchTerm(searchTerm));
    }

    @Test
    public void search_for_invalid_product_should_return_no_results() {
        homepage = new Homepage(driver);
        homepage.navigateToHomepage();
        srp = homepage.searchModule.searchFor("aldsfashsadf");
        Assert.assertTrue(srp.searchResultsShouldBeEmpty());
    }
}

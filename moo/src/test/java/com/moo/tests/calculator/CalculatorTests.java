package com.moo.tests.calculator;

import com.moo.pages.CalculatorPage;
import com.moo.pages.Homepage;
import com.moo.tests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by amir on 15/12/2016.
 */
public class CalculatorTests extends BaseTests {

    Homepage homepage;
    CalculatorPage calcPage;

    @Test
    public void selecting_order_options_should_display_cost_table() {
        calcPage = new CalculatorPage(driver);
        homepage = new Homepage(driver);

        homepage.navigateToHomepage(); //this is required to set the geoIP for calculator page
        calcPage.navigateToCalculatorPage()
                .selectProduct()
                .selectQuantity()
                .selectShippingCountry("United Kingdom")
                .clickCalculateButton();
        Assert.assertTrue(calcPage.deliveryOptionsAndPricesAreDisplayed());
    }
}

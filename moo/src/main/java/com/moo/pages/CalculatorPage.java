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
public class CalculatorPage extends BaseModule {

    @FindAll(@FindBy(css = "div[class*='chosen-container-active'] ul.chosen-results li[class*='active-result']"))
    private List<WebElement> activeContainer;

    @FindBy(css = "button[data-webdriver-automation-id='calculate-button']")
    private WebElement calculateButton;

    @FindAll(@FindBy(css = "table[data-webdriver-automation-id='cost-table'] tbody tr"))
    private List<WebElement> costTable;

    @FindBy(css = "div#deliverTo a.chosen-single")
    private WebElement country;

    @FindAll(@FindBy(css = "div#productItems a.chosen-single"))
    private List<WebElement> productAndQuantity;

    @FindBy(css = "div#loadingSpinner")
    private WebElement spinner;

    @FindBy(css = "div[class='results panel-body'][style='overflow: hidden; display: block;']")
    private WebElement tableLoading;

    private void waitForSpinnerToDisappear() {
        waitForElementToDisappear(By.cssSelector("div#loadingSpinner"));
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage navigateToCalculatorPage() {
        driver.navigate().to("https://www.moo.com/uk/help/faq/cost-calculator.html");
        waitForSpinnerToDisappear();
        return this;
    }

    /*
        For testing purposes, I'm selecting 5th item.
        Method should be modified to take as input either number or name of product
    */
    public CalculatorPage selectProduct() {
        productAndQuantity.get(0).click();
        activeContainer.get(5).click();
        return this;
    }

    /*
        For testing purposes, I'm selecting 5th item.
        Method should be modified to take as input either number or name of product
    */
    public CalculatorPage selectQuantity() {
        productAndQuantity.get(1).click();
        activeContainer.get(5).click();
        return this;
    }

    public CalculatorPage selectShippingCountry(String value) {
        country.click();
        for(WebElement country : activeContainer) {
            if(country.getText().equalsIgnoreCase(value)) {
                country.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage clickCalculateButton() {
        calculateButton.click();
        waitForSpinnerToDisappear();
        waitForElementToAppear(tableLoading);
        return this;
    }

    public boolean deliveryOptionsAndPricesAreDisplayed() {
        List<Boolean> cellHasData = new ArrayList<>(0);
        List<WebElement> td;

        for(WebElement tr : costTable) {
            td = tr.findElements(By.cssSelector("td"));
            for(WebElement tdData : td) {
                cellHasData.add(!tdData.getText().isEmpty());
            }
        }
        return !cellHasData.contains(Boolean.FALSE);
    }
}

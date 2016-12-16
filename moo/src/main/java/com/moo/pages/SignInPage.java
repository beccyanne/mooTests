package com.moo.pages;

import com.moo.modules.BaseModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by amir on 15/12/2016.
 */
public class SignInPage extends BaseModule {

    @FindBy(css = "input[data-webdriver-automation-id='signin-email']")
    private WebElement emailAddress;

    @FindBy(css = "input[data-webdriver-automation-id='signin-password']")
    private WebElement password;

    @FindBy(css = "button[data-webdriver-automation-id='signin-button']")
    private WebElement button;

    @FindBy(css = "div.has-error-msg p")
    private WebElement errorMessage;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage navigateToSignInPage() {
        driver.navigate().to("https://www.moo.com/uk/account/signin.php");
        return this;
    }

    public SignInPage enterEmailAddress(String emailAddress) {
        this.emailAddress.clear();
        this.emailAddress.sendKeys(emailAddress);
        return this;
    }

    public SignInPage enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        button.click();
    }

    public SignInPage loginAsInvalid(String emailAddress, String password) {
        enterEmailAddress(emailAddress).enterPassword(password).clickSignInButton();
        return this;
    }

    public boolean errorMessageIsDisplayed() {
        return !errorMessage.getText().isEmpty();
    }
}

package com.moo.tests.login;

import com.moo.pages.SignInPage;
import com.moo.tests.BaseTests;
import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created by amir on 15/12/2016.
 */
public class SignInTests extends BaseTests {

    SignInPage signInPage;

    @Test
    public void submitting_invalid_credentials_should_display_error_message() {
        signInPage = new SignInPage(driver);
        signInPage.navigateToSignInPage()
                .loginAsInvalid("amir@ghahrai.com", "1234567890");

        Assert.assertTrue(signInPage.errorMessageIsDisplayed());
    }
}

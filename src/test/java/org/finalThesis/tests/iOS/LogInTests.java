package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.HomePage;
import org.finalThesis.pageObjects.iOS.LogInPage;
import org.testng.annotations.Test;

public class LogInTests extends iOSBaseTest {
    @Test
    public void LogInWithEmail(){
        HomePage homePage = onboardingPage.tapContinue();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com","Test123!");
        logInPage.logIn();
    }
}

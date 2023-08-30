package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.finalThesis.pageObjects.iOS.EventsPage;
import org.finalThesis.pageObjects.iOS.HomePage;
import org.finalThesis.pageObjects.iOS.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends iOSBaseTest {
    @Test
    public void LogInWithEmail() throws InterruptedException {
        onboardingPage.allowNotifications();
        HomePage homePage = onboardingPage.tapContinue();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com","Test123!");
        EventsPage eventsPage = logInPage.logIn();

        Assert.assertTrue(
                driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Events'`][1]")).isDisplayed()
        );
    }
}

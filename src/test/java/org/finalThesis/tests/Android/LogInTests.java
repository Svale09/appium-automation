package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import io.appium.java_client.AppiumBy;
import org.finalThesis.pageObjects.Android.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends AndroidBaseTest {
    @Test
    public void LogIn(){
        HomePage homePage = onboardingPage.tapContinueButton();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com", "Test123!");
        EventsPage eventsPage = logInPage.tapContinueButton();

        Assert.assertTrue(eventsPage.isTitleDisplayed());
    }

    public void LogOut(){
        EventsPage eventsPage = new EventsPage(driver);
        ProfilePage profilePage = eventsPage.tapProfilePicture();

        SettingsPage settingsPage = profilePage.tapSettingsButton();

        settingsPage.
    }
}

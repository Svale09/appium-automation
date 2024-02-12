package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class LogInTests extends AndroidBaseTest {
    @Test(priority = 1, groups = {"AndroidReg"})
    public void LogIn(){
        HomePage homePage = onboardingPage.tapContinueButton();

        LogInPage logInPage = homePage.tapLogInButton();

        Map<String, String> credentials = RetrieveCredentials();
        logInPage.enterCredentials(credentials.get("email"), credentials.get("password"));
        HomefeedPage homefeedPage = logInPage.tapContinueButton();

        Assert.assertTrue(homefeedPage.isTitleDisplayed());
    }

    @Test(priority = 2, groups = {"AndroidReg"})
    public void LogOut(){
        EventsPage eventsPage = new EventsPage(driver);
        ProfilePage profilePage = eventsPage.tapProfilePicture();

        SettingsPage settingsPage = profilePage.tapSettingsButton();

        settingsPage.scrollToLogOutButton();
        HomePage homePage = settingsPage.tapLogOutButton();

        Assert.assertTrue(homePage.isTitleVisible());
    }
}

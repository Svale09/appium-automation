package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends AndroidBaseTest {
    @Test(priority = 1)
    public void LogIn(){
        HomePage homePage = onboardingPage.tapContinueButton();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com", "Test123!");
        EventsPage eventsPage = logInPage.tapContinueButton();

        Assert.assertTrue(eventsPage.isTitleDisplayed());
    }

    @Test(priority = 2)
    public void LogOut(){
        EventsPage eventsPage = new EventsPage(driver);
        ProfilePage profilePage = eventsPage.tapProfilePicture();

        SettingsPage settingsPage = profilePage.tapSettingsButton();

        settingsPage.scrollToLogOutButton();
        HomePage homePage = settingsPage.tapLogOutButton();

        Assert.assertTrue(homePage.isTitleVisible());
    }
}

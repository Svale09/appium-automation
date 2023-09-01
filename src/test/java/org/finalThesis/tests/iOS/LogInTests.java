package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends iOSBaseTest {
    @Test(priority = 1, groups = {"iOSReg"})
    public void LogInWithEmail(){
        onboardingPage.allowNotifications();
        HomePage homePage = onboardingPage.tapContinue();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com","Test123!");
        EventsPage eventsPage = logInPage.logIn();

        Assert.assertTrue(eventsPage.isTitleDisplayed());
    }
    @Test(priority = 2, groups = {"iOSReg"})
    public void LogOut(){
        EventsPage eventsPage = new EventsPage(driver);

        ProfilePage profilePage = eventsPage.tapProfilePicture();

        SettingsPage settingsPage = profilePage.tapSettingsButton();

        HomePage homePage = settingsPage.scrollToLogOutButton();

        Assert.assertTrue(homePage.isTitleDisplayed());
    }
}

package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import io.appium.java_client.AppiumBy;
import org.finalThesis.pageObjects.iOS.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTests extends iOSBaseTest {
    @Test(priority = 1)
    public void LogInWithEmail(){
        onboardingPage.allowNotifications();
        HomePage homePage = onboardingPage.tapContinue();

        LogInPage logInPage = homePage.tapLogInButton();

        logInPage.enterCredentials("svaleqa+zr@gmail.com","Test123!");
        EventsPage eventsPage = logInPage.logIn();

        Assert.assertTrue(eventsPage.isTitleDisplayed());
    }
    @Test(priority = 2)
    public void LogOut(){
        EventsPage eventsPage = new EventsPage(driver);

        ProfilePage profilePage = eventsPage.tapProfilePicture();

        SettingsPage settingsPage = profilePage.tapSettingsButton();
        settingsPage.scrollToLogInButton();

        HomePage homePage = settingsPage.tapLogOutButton();

        Assert.assertTrue(homePage.isTitleDisplayed());
    }
}

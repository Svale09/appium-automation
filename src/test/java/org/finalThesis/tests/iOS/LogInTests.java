package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import com.google.gson.JsonObject;
import org.finalThesis.pageObjects.iOS.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class LogInTests extends iOSBaseTest {
    @Test(priority = 1, groups = {"iOSReg"})
    public void LogInWithEmail() throws FileNotFoundException {
        onboardingPage.allowNotifications();
        HomePage homePage = onboardingPage.tapContinue();

        LogInPage logInPage = homePage.tapLogInButton();

        Map<String, String> credentials = RetrieveCredentials();
        logInPage.enterCredentials(credentials.get("email"), credentials.get("password"));
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

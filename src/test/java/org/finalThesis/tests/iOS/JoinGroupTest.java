package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.EventsPage;
import org.finalThesis.pageObjects.iOS.GroupDetailsPage;
import org.finalThesis.pageObjects.iOS.GroupsPage;
import org.finalThesis.pageObjects.iOS.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JoinGroupTest extends iOSBaseTest {
    @Test(groups = {"iOSReg"})
    public void JoinGroup() {
        EventsPage eventsPage = new EventsPage(driver);

        GroupsPage groupsPage = eventsPage.NavigateToGroupsSection();

        GroupDetailsPage groupDetailsPage = groupsPage.OpenGroupDetails();
        groupDetailsPage.JoinGroup();

        Assert.assertTrue(groupDetailsPage.IsInputFieldVisible());
    }

    @BeforeMethod(alwaysRun = true)
    public void LogIn() {
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogInWithEmail();
    }
}

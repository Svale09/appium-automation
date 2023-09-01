package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.EventsPage;
import org.finalThesis.pageObjects.Android.GroupDetailsPage;
import org.finalThesis.pageObjects.Android.GroupsPage;
import org.finalThesis.pageObjects.Android.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JoinGroupTest extends AndroidBaseTest {
    @Test(groups = {"AndroidReg"})
    public void JoinGroup(){
        EventsPage eventsPage = new EventsPage(driver);

        GroupsPage groupsPage = eventsPage.NavigateToGroupsSection();

        GroupDetailsPage groupDetailsPage = groupsPage.OpenGroupDetails();
        int initialMemberCount = groupDetailsPage.GetMemberCount();
        groupDetailsPage.JoinGroup();
        int currentMemberCount = groupDetailsPage.GetMemberCount();

        Assert.assertEquals(currentMemberCount, initialMemberCount+1);
    }

    @BeforeMethod(alwaysRun = true)
    public void LogIn(){
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogIn();
    }
}

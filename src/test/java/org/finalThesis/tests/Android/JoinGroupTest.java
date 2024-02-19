package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JoinGroupTest extends AndroidBaseTest {
    @Test(groups = {"AndroidReg"})
    public void JoinGroup(){
        HomefeedPage homefeedPage = new HomefeedPage(driver);
        GroupsPage groupsPage = homefeedPage.navigateToGroupsSection();

        FeaturedGroupsPage featuredGroupsPage = groupsPage.OpenFeaturedGroupList();
        //TODO investigate why is the locator for featuredGroups returning empty list
        GroupDetailsPage groupDetailsPage = featuredGroupsPage.OpenFeaturedGroupDetails();

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

package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatePostTest extends AndroidBaseTest {
    @Test(groups = {"AndroidReg"})
    public void CreatePost(){
        EventsPage eventsPage = new EventsPage(driver);

        GroupsPage groupsPage = eventsPage.NavigateToGroupsSection();

        GroupDetailsPage groupDetailsPage = groupsPage.OpenGroupDetails();

        CreatePostPage createPostPage = groupDetailsPage.TapPostInputField();
        createPostPage.InputPostText("This is a test post. Hello World :)");

        groupDetailsPage = createPostPage.PublishPost();

        groupDetailsPage.ScrollToPosts();

        Assert.assertEquals(groupDetailsPage.GetLatestPostTimestamp(), "moments ago");
    }

    @BeforeMethod(alwaysRun = true)
    public void LogIn(){
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogIn();
    }
}

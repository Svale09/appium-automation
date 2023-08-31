package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatePostTest extends iOSBaseTest {
    @Test
    public void CreatePost(){
        EventsPage eventsPage = new EventsPage(driver);

        GroupsPage groupsPage = eventsPage.NavigateToGroupsSection();

        GroupDetailsPage groupDetailsPage = groupsPage.OpenGroupDetails();

        groupDetailsPage.JoinGroup();

        CreatePostPage createPostPage = groupDetailsPage.TapPostInputField();
        createPostPage.InputPostText("This is an iOS test post, Hello Apple World :)");

        groupDetailsPage = createPostPage.PublishPost();

        Assert.assertTrue(groupDetailsPage.isPostVisible());
    }

    @BeforeMethod
    public void LogIn() {
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogInWithEmail();
    }
}

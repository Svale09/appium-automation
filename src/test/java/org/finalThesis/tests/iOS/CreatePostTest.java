package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class CreatePostTest extends iOSBaseTest {
    @Test(groups = {"iOSReg"})
    public void CreatePost(){
        EventsPage eventsPage = new EventsPage(driver);

        GroupsPage groupsPage = eventsPage.NavigateToGroupsSection();

        GroupDetailsPage groupDetailsPage = groupsPage.OpenGroupDetails();

        CreatePostPage createPostPage = groupDetailsPage.TapPostInputField();
        createPostPage.InputPostText("This is an iOS test post, Hello Apple World :)");

        groupDetailsPage = createPostPage.PublishPost();

        Assert.assertTrue(groupDetailsPage.isPostVisible());
    }

    @BeforeMethod(alwaysRun = true)
    public void LogIn() throws FileNotFoundException {
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogInWithEmail();
    }
}

package org.finalThesis.tests.Android;

import TestUtilities.AndroidBaseTest;
import org.finalThesis.pageObjects.Android.EventDetailsPage;
import org.finalThesis.pageObjects.Android.EventsPage;
import org.finalThesis.pageObjects.Android.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReserveEventSpotTest extends AndroidBaseTest {
    @Test(groups = {"AndroidReg"})
    public void ReserveSpotForRegularEvent(){
        EventsPage eventsPage = new EventsPage(driver);
        EventDetailsPage eventDetailsPage = eventsPage.tapEventCard();

        int initialAttendees = eventDetailsPage.GetNumberOfAttendees();

        eventDetailsPage.TapReserveSpot();

        int currentAttendees = eventDetailsPage.GetNumberOfAttendees();

        Assert.assertEquals(initialAttendees + 1, currentAttendees);
    }
    @BeforeMethod(alwaysRun = true)
    public void LogIn(){
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogIn();
    }
}

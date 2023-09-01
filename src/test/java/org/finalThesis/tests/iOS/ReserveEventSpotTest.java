package org.finalThesis.tests.iOS;

import TestUtilities.iOSBaseTest;
import org.finalThesis.pageObjects.iOS.EventDetailsPage;
import org.finalThesis.pageObjects.iOS.EventsPage;
import org.finalThesis.pageObjects.iOS.OnboardingPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReserveEventSpotTest extends iOSBaseTest {
    @Test(groups = {"iOSReg"})
    public void ReserveSpotForRegularEvent(){
        EventsPage eventsPage = new EventsPage(driver);

        EventDetailsPage eventDetailsPage = eventsPage.tapEventCard();
        eventDetailsPage.TapReserveSpot();

        Assert.assertTrue(eventDetailsPage.IsAddToCalendarVisible());
    }

    @BeforeMethod(alwaysRun = true)
    public void LogIn(){
        LogInTests logInTests = new LogInTests();
        logInTests.onboardingPage = new OnboardingPage(driver);
        logInTests.LogInWithEmail();
    }
}

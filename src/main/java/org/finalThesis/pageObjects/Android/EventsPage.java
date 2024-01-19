package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventsPage extends AndroidBasePage {
    AndroidDriver driver;

    public EventsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/header")
    private WebElement eventsTitle;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/profile_avatar")
    private WebElement profilePicture;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/in_person_events_list")
    private WebElement inPersonEventCarousel;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/in_person_events_list']//*[@class='androidx.cardview.widget.CardView']")
    private List<WebElement> eventCards;
    @AndroidFindBy(accessibility = "Groups")
    private WebElement groupsIcon;

    public boolean isTitleDisplayed() {
        return eventsTitle.isDisplayed();
    }

    public ProfilePage tapProfilePicture() {
        Tap(profilePicture);
        return new ProfilePage(driver);
    }

    public EventDetailsPage tapEventCard() {
        waitForElementToAppearByElement(inPersonEventCarousel, driver);
        Tap(eventCards.get(0));
        return new EventDetailsPage(driver);
    }

    public GroupsPage NavigateToGroupsSection() {
        Tap(groupsIcon);
        return new GroupsPage(driver);
    }
}

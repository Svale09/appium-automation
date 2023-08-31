package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventsPage extends AndroidActions {
    AndroidDriver driver;

    public EventsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/header")
    private WebElement eventsTitle;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/profile_avatar")
    private WebElement profilePicture;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/in_person_events_list']//*[@class='androidx.cardview.widget.CardView']")
    private List<WebElement> eventCards;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/in_person_header")
    private WebElement inPersonTitle;

    public boolean isTitleDisplayed(){
        return eventsTitle.isDisplayed();
    }
    public ProfilePage tapProfilePicture(){
        profilePicture.click();
        return new ProfilePage(driver);
    }

    public EventDetailsPage tapEventCard(){
        eventCards.get(0).click();
        return new EventDetailsPage(driver);
    }
}

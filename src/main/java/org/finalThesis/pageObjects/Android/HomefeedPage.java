package org.finalThesis.pageObjects.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomefeedPage extends AndroidBasePage{
    AndroidDriver driver;

    public HomefeedPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //TODO locate elements
    @AndroidFindBy(xpath = "//*[contains(@text, 'Hello')]")
    private WebElement homefeedTitle;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"User Avatar\"])[1]")
    private WebElement profilePicture;

    @AndroidFindBy(id = "the.phoenix.android.qa:id/events")
    private WebElement eventsNavigationIcon;

    @AndroidFindBy(accessibility = "Spaces")
    private WebElement groupsNavigationIcon;

    //TODO implement isTitleDisplayed method used in LogIn tests
    public boolean isTitleDisplayed() {
        waitForElementToAppearByElement(homefeedTitle, driver);
        return homefeedTitle.isDisplayed();
    }

    public ProfilePage tapProfilePicture(){
        Tap(profilePicture);
        return new ProfilePage(driver);
    }

    public EventsPage navigateToEventsSection(){
        Tap(eventsNavigationIcon);
        return new EventsPage(driver);
    }

    public GroupsPage navigateToGroupsSection(){
        Tap(groupsNavigationIcon);
        return new GroupsPage(driver);
    }
}

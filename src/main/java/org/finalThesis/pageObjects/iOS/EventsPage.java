package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventsPage extends iOSActions {
    IOSDriver driver;

    public EventsPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Events'`][1]")
    private WebElement eventsTitle;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    private WebElement profilePicture;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView[4]/XCUIElementTypeCell[1]")
    private WebElement eventCard;

    public ProfilePage tapProfilePicture(){
        profilePicture.click();
        return new ProfilePage(driver);
    }
    public Boolean isTitleDisplayed(){
        return eventsTitle.isDisplayed();
    }

    public EventDetailsPage tapEventCard(){
        eventCard.click();
        return new EventDetailsPage(driver);
    }
}

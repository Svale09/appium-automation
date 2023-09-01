package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EventDetailsPage extends iOSBasePage {
    IOSDriver driver;

    public EventDetailsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Reserve Spot\"`]")
    private WebElement reserveSpotButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Add To Calendar\"`]")
    private WebElement addToCalendarButton;

    public void TapReserveSpot() {
        Tap(reserveSpotButton);
    }

    public boolean IsAddToCalendarVisible() {
        return addToCalendarButton.isDisplayed();
    }
}

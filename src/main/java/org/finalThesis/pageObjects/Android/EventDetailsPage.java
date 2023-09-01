package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EventDetailsPage extends AndroidActions {
    AndroidDriver driver;

    public EventDetailsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/button_background")
    private WebElement reserveSpotButton;
    @AndroidFindBy(xpath = "//*[@resource-id='the.phoenix.android.qa:id/attendees_info']//*[@resource-id='the.phoenix.android.qa:id/value_label']")
    private WebElement attendesCounter;

    public void TapReserveSpot(){
        waitForElementToAppearByElement(reserveSpotButton,driver);
        reserveSpotButton.click();
    }

    public int GetNumberOfAttendees(){
        return Integer.parseInt(GetText(attendesCounter));
    }
}

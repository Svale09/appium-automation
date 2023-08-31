package org.finalThesis.pageObjects.Android;

import Utilities.AppiumUtilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EventsPage extends AppiumUtilities {
    AndroidDriver driver;

    public EventsPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/header")
    private WebElement eventsTitle;

    public boolean isTitleDisplayed(){
        return eventsTitle.isDisplayed();
    }
}

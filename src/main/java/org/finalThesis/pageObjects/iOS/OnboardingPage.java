package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage extends iOSBasePage {
    IOSDriver driver;

    public OnboardingPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    private WebElement continueButton;
    @iOSXCUITFindBy(accessibility = "Allow")
    private WebElement allowNotificationPopUp;

    public HomePage tapContinue() {
        continueButton.click();
        return new HomePage(driver);
    }

    public void allowNotifications() {
        Tap(allowNotificationPopUp);
    }
}

package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends iOSBasePage {
    IOSDriver driver;

    public SettingsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Log out'`]")
    private WebElement logOutButton;

    public HomePage tapLogOutButton() {
        Tap(logOutButton);
        return new HomePage(driver);
    }

    public void scrollToLogInButton() {
        ScrollToElement(logOutButton);
    }
}

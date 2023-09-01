package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends iOSBasePage {
    IOSDriver driver;
    public ProfilePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "ic settings")
    private WebElement settingsButton;
    @iOSXCUITFindBy(accessibility = "Test Update")
    private WebElement profileName;

    public SettingsPage tapSettingsButton(){
        Tap(settingsButton);
        return new SettingsPage(driver);
    }
}

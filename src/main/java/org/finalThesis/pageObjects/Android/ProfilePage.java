package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends AndroidBasePage {
    AndroidDriver driver;

    public ProfilePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/settings_button")
    private WebElement settingsButton;

    public SettingsPage tapSettingsButton(){
        Tap(settingsButton);
        return new SettingsPage(driver);
    }
}

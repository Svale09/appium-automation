package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AndroidBasePage {
    AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/logout_button")
    public WebElement logOutButton;

    public HomePage tapLogOutButton(){
        Tap(logOutButton);
        return new HomePage(driver);
    }

    public void scrollToLogOutButton(){
        scrollToElement("Log out");
    }
}

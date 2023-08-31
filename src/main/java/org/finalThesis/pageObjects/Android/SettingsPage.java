package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import com.sun.org.apache.xpath.internal.operations.And;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends AndroidActions {
    AndroidDriver driver;

    public SettingsPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/logout_button")
    public WebElement logOutButton;

    public HomePage tapLogOutButton(){
        logOutButton.click();
        return new HomePage(driver);
    }

    public void scrollToLogOutButton(){

    }
}

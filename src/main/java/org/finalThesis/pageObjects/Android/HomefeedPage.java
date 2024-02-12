package org.finalThesis.pageObjects.Android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomefeedPage extends AndroidBasePage{
    AndroidDriver driver;

    public HomefeedPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //TODO locate elements


    //TODO implement isTitleDisplayed method used in LogIn tests
    public boolean isTitleDisplayed(){
        return true;
    }
}

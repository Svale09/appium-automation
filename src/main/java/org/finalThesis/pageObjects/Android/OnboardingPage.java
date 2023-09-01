package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage extends AndroidBasePage {
    AndroidDriver driver;
    public OnboardingPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/continue_button")
    private WebElement continueButton;

    public HomePage tapContinueButton(){
        Tap(continueButton);
        return new HomePage(driver);
    }
}

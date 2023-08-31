package org.finalThesis.pageObjects.Android;

import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage extends AppiumUtilities {
    AndroidDriver driver;
    public OnboardingPage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/continue_button")
    private WebElement continueButton;

    public HomePage tapContinueButton(){
        continueButton.click();
        return new HomePage(driver);
    }
}

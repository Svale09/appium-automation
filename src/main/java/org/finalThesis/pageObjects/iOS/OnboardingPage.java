package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OnboardingPage extends AppiumUtilities {
    IOSDriver driver;

    public OnboardingPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(className = "XCUIElementTypeButton")
    private WebElement continueButton;

    public HomePage tapContinue(){
        continueButton.click();
        return new HomePage(driver);
    }
}

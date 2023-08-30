package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AppiumUtilities {
    IOSDriver driver;

    public HomePage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sign Up With Email'`]")
    private WebElement signUpButton;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Log In With Email'`]")
    private WebElement logInButton;

    public LogInPage tapLogInButton(){
        logInButton.click();
        return new LogInPage(driver);
    }
}
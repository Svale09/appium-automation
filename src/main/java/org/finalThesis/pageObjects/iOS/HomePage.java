package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends iOSBasePage {
    IOSDriver driver;

    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Sign Up With Email'`]")
    private WebElement signUpButton;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Log In With Email'`]")
    private WebElement logInButton;
    @iOSXCUITFindBy(accessibility = "Welcome")
    private WebElement title;

    public LogInPage tapLogInButton(){
        Tap(logInButton);
        return new LogInPage(driver);
    }
    public Boolean isTitleDisplayed(){
        return title.isDisplayed();
    }
}

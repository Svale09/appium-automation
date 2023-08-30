package org.finalThesis.pageObjects.iOS;

import Utilities.AppiumUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends AppiumUtilities {
    IOSDriver driver;
    public LogInPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == 'Enter email'`]")
    private WebElement emailInputField;
    @iOSXCUITFindBy(className = "XCUIElementTypeSecureTextField")
    private WebElement passwordInputField;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Continue' AND type == 'XCUIElementTypeButton'")
    private WebElement continueButton;



    public void enterCredentials(String email, String password){
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
    }
    public EventsPage logIn(){
        continueButton.click();
        return new EventsPage(driver);
    }

}
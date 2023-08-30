package org.finalThesis.pageObjects.Android;

import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AppiumUtilities {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy()
    private WebElement logInButton;
    @AndroidFindBy()
    private WebElement signUpButton;

    public LogInPage tapLogInButton(){
        logInButton.click();
        return new LogInPage(driver);
    }
}

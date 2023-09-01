package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AndroidBasePage {
    AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "the.phoenix.android.qa:id/login")
    private WebElement logInButton;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/continue_with_email_bttn")
    private WebElement signUpButton;
    @AndroidFindBy(id = "the.phoenix.android.qa:id/title")
    private WebElement title;

    public LogInPage tapLogInButton(){
        Tap(logInButton);
        return new LogInPage(driver);
    }

    public boolean isTitleVisible(){
        return title.isDisplayed();
    }
}

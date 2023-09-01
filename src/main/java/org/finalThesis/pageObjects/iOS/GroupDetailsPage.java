package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class GroupDetailsPage extends iOSBasePage {
    IOSDriver driver;

    public GroupDetailsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND (NOT (value CONTAINS 'group')) AND value CONTAINS 'members'")
    private WebElement memberCounter;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Join Group\"`]")
    private WebElement joinGroupButton;

    @iOSXCUITFindBy(accessibility = "What's on your mind?")
    private WebElement postInputField;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Right now\"`]")
    private WebElement latestPostTimestamp;

    public void JoinGroup() {
        Tap(joinGroupButton);
    }

    public boolean IsInputFieldVisible() {
        return postInputField.isDisplayed();
    }

    public CreatePostPage TapPostInputField() {
        Tap(postInputField);
        return new CreatePostPage(driver);
    }

    public boolean isPostVisible() {
        waitForElementToAppearByElement(latestPostTimestamp, driver);
        return latestPostTimestamp.isDisplayed();
    }
}

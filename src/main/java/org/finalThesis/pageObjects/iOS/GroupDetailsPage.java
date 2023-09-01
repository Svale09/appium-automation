package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class GroupDetailsPage extends iOSActions {
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

    /*public int GetMemberCount() {
        String members = GetText(memberCounter);
        String[] memberCounter = members.split(" ");
        return Integer.parseInt(memberCounter[0]);
    }*/

    public void JoinGroup() {
        joinGroupButton.click();
    }

    public boolean IsInputFieldVisible(){
        return postInputField.isDisplayed();
    }

    public CreatePostPage TapPostInputField() {
        postInputField.click();
        return new CreatePostPage(driver);
    }

    public boolean isPostVisible(){
        return latestPostTimestamp.isDisplayed();
    }
}

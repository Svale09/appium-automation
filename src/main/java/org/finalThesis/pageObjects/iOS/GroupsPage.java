package org.finalThesis.pageObjects.iOS;

import Utilities.iOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupsPage extends iOSActions {
    IOSDriver driver;

    public GroupsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell")
    private List<WebElement> featuredGroupCards;

    public GroupDetailsPage OpenGroupDetails() {
        featuredGroupCards.get(0).click();
        return new GroupDetailsPage(driver);
    }
}

package org.finalThesis.pageObjects.Android;

import Utilities.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupsPage extends AndroidBasePage {
    AndroidDriver driver;

    public GroupsPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Featured']")
    private WebElement FeaturedTitle;

    public GroupDetailsPage OpenGroupDetails(){
        //TODO implement new way of opening the details page
        return new GroupDetailsPage(driver);
    }

    public FeaturedGroupsPage OpenFeaturedGroupList(){
        Tap(FeaturedTitle);
        return new FeaturedGroupsPage(driver);
    }
}

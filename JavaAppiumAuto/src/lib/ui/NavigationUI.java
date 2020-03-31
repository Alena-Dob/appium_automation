package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject{

    private static final String
    MY_LISTS_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementPresent(
                By.xpath(MY_LISTS_LINK),
                "Cannot find navigation button to My Lists",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LISTS_LINK),
                "Cannot click to My Lists",
                5
        );
    }
}
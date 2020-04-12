package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static String
    MY_LISTS_LINK,
    EXPLORE_LINK;

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyLists()
    {
        this.waitForElementPresent(
                MY_LISTS_LINK,
                "Cannot find navigation button to My Lists",
                5
        );

        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot click to My Lists",
                5
        );
    }
    public void clickExplore()
    {
        this.waitForElementPresent(
                EXPLORE_LINK,
                "Cannot find navigation button to Explore",
                5
        );

        this.waitForElementAndClick(
                EXPLORE_LINK,
                "Cannot click to Explore",
                5
        );
    }
}

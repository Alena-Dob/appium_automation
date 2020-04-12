package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']";
        SECOND_ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[@name='{SECOND_TITLE}']";
        CLOSE_BUTTON_IN_WINDOW_ON_SAVED_ARTICLES = "xpath://XCUIElementTypeButton[@name='Close']";
    }
    public IOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}

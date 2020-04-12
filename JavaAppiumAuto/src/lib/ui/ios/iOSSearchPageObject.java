package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT ="xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT ="xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON ="id:Cancel";
        SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT ="xpath://XCUIElementTypeStaticText";
        SEARCH_EMPTY_RESULT_ELEMENT ="xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_INPUT_DEFAULT_TEXT ="id:Search Wikipedia";
        SEARCH_RESULT_LIST ="xpath://XCUIElementTypeCollectionView";
        SEARCH_RESULTS_LIST_TITLE ="id:XCUIElementTypeStaticText";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}

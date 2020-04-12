package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Java (programming language)";
        SECOND_TITLE = "id:Java version history";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "xpath://XCUIElementTypeButton[@name='Wikipedia, return to Explore']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/list_of_lists']//*[@text='{SUBSTRING}']";
        SAVED_TO_BY_LIST_BUTTON = "id:Saved. Activate to unsave.";
    }

    public IOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}

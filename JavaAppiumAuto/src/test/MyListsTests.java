package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";

    @Test
    public void testSaveFirstArticleToMyList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        if (Platform.getInstance().isIOS()) {
            MyListsPageObject.closeWindowOnMyListsScreen();
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticlesToOneList() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();

        String name_of_first_title = "Java (programming language)";
        String name_of_second_title = "Java version history";

        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(name_of_first_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String name_of_folder = "Java articles";

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(name_of_second_title);
        ArticlePageObject.waitForTitleElement();
        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addAnotherArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }

        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        if (Platform.getInstance().isIOS()) {
            MyListsPageObject.closeWindowOnMyListsScreen();
        }

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.swipeByArticleToDelete(name_of_first_title);
        }
        if (Platform.getInstance().isIOS()) {
            MyListsPageObject.swipeBySecondArticleToDelete(name_of_first_title);
        }

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.clickByArticle(name_of_second_title);
            String article_title = ArticlePageObject.getArticleTitle();

            assertEquals(
                    "We see unexpected title!",
                    name_of_second_title,
                    article_title
            );
        }
        if (Platform.getInstance().isIOS()) {
            NavigationUI.clickExplore();
            SearchPageObject.initSearchInput();
            SearchPageObject.typeSearchLine("Java");
            SearchPageObject.clickByArticleWithSubstring(name_of_second_title);
            ArticlePageObject.waitSavedToMyListButtonOnArticleScreen();

        }

    }
}

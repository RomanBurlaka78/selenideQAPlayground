package selenidetests.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.OpenNewTabPage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class OpenNewTabTest extends BaseTest {

    @Test
    public void  testOpenNewTab() {
        getHomePage()
                .open()
                .goToPage("New Tab", new OpenNewTabPage())
                .pageTitleShouldBeSameAs("Test New Tab")
                .openNewTabPage("New Page")
                .pageTitleShouldBeSameAs("New Page");


    }

}

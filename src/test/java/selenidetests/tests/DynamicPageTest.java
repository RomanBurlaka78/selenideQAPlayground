package selenidetests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.example.pages.DynamicPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

import static com.codeborne.selenide.CollectionCondition.size;

public class DynamicPageTest extends BaseTest {
    @Test
    public void testDynamic() {
        new HomePage()
                .open()
                .goToPage("Dynamic Table", new DynamicPage())
                .getItemTableItems("Black Widow")
                .pageTitleShouldBeSameAs("Test Dynamic Table");
    }

    @Test
    public void testGetSizeOfTable() {
        new HomePage()
                .open()
                .goToPage("Dynamic Table", new DynamicPage())
                .shouldHaveSize(8);


    }
}

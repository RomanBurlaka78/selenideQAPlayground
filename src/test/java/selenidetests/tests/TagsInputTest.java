package selenidetests.tests;

import org.example.pages.HomePage;
import org.example.pages.TagsInputPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

import java.util.List;

public class TagsInputTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test
    public void testAddOneTag() {
        homePage
                .open()
                .goToPage("Tags Input Box", new TagsInputPage())
                .addOneTag("one");

    }

    @Test
    public void testAddFewTags() {
        homePage
                .open()
                .goToPage("Tags Input Box", new TagsInputPage())
                .addFewTags("two  three  four five six seven")
                .shouldHaveTags(8);

    }

    @Test
    public void testRemoveAllTags() {
        homePage
                .open()
                .goToPage("Tags Input Box", new TagsInputPage())
                .removeAllTags()
                .shouldHaveTags(0);

    }

    @Test
    public void testRemoveAllTagsByButton() {
        homePage
                .open()
                .goToPage("Tags Input Box", new TagsInputPage())
                .clickRemoveButton()
                .shouldHaveTags(0);
    }

    @Test
    public void testGetTagsRemaining() {
    int remaining = homePage
                .open()
                .goToPage("Tags Input Box", new TagsInputPage())
                .clickRemoveButton()
                .tagsRemaining();

        Assert.assertEquals(remaining, 10);
    }
}

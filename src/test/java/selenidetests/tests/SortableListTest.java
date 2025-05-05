package selenidetests.tests;

import org.example.pages.SortableListPage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class SortableListTest extends BaseTest {

    @Test
    public  void testGetTitle() {
        getHomePage()
                .open()
                .goToPage("Sortable List", new SortableListPage())
                .pageTitleShouldBeSameAs("Test Sortable List");
    }

    @Test
    public  void testGetMoveItem() {
        String name = "Mark Zuckerberg";
        int number = 1;
        getHomePage()
                .open()
                .goToPage("Sortable List", new SortableListPage())
                .getMoveItem(name, number)
                .elementShouldHaveName(number, name);
    }
}

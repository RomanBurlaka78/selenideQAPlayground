package selenidetests.tests;

import org.example.pages.NestedFramePage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class NestedFrameTest extends BaseTest {

    @Test
    public  void testShowNestedFrame(){
        getHomePage()
                .open()
                .goToPage("Nested Iframe", new NestedFramePage())
                .pageTitleShouldBeSameAs("Test nested iframe");
    }

    @Test
    public  void testGoToSecondNestedFrame(){
        getHomePage()
                .open()
                .goToPage("Nested Iframe", new NestedFramePage())
                .clickButton()
                .messageShouldBe("Button Clicked");
    }


}

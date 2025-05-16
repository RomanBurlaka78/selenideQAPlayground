package selenidetests.tests;

import org.example.pages.NestedFramePage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class NestedFrameTest extends BaseTest {

    @Test
    public  void showNestedFrame(){
        getHomePage()
                .open()
                .goToPage("Nested Iframe", new NestedFramePage())
                .pageTitleShouldBeSameAs("Test nested iframe");
    }

    @Test
    public  void goToSecondNestedFrame(){
        getHomePage()
                .open()
                .goToPage("Nested Iframe", new NestedFramePage())
                .clickButton()
                .messageShouldBe("Button Clicked");
    }


}

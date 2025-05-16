package selenidetests.tests;

import org.example.pages.ShadowDomPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class ShadowDomTest extends BaseTest {

    @Test
    public void testGetValueProgressBar() {
        getHomePage()
                .open()
                .goToPage("Shadow DOM", new ShadowDomPage())
                .getPercent();


    }

    @Test
    public void testImproveProgressBar() {
        getHomePage()
                .open()
                .goToPage("Shadow DOM", new ShadowDomPage())
                .clickButton()
                .percentShouldBe("95");

    }
}

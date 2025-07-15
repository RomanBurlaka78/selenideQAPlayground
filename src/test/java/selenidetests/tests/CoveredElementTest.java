package selenidetests.tests;

import org.example.pages.CoveredPage;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class CoveredElementTest extends BaseTest {

    @Test
    public void testFindCoveredElement() {
     String msg = getHomePage()
                .open()
                .goToPage("Covered Elements", new CoveredPage())
                .findCoveredElement();

        Assert.assertEquals(msg, "Mission accomplished");
    }
}

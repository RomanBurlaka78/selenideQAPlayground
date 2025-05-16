package selenidetests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.example.pages.PopUpWindowPage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;
@Epic("QA Playground Tests")
@Feature("Pop-Up Window validation")
@Owner("Roman Burlaka")
@Tag("smoke")

public class PopUpWindowTest extends BaseTest {

    @Test
    @Story("Pop-Up")
    @Description("get pop-up window")
    @Severity(SeverityLevel.NORMAL)
    public void testPopUpWindowShown() {
        getHomePage()
                .open()
                .goToPage("Pop-up Window", new PopUpWindowPage())
                .showPopUpWindow("pop-up")
                .pageTitleShouldBeSameAs("pop-up");

    }

    @Test
    public void testPopUpWindowClose() {
        getHomePage()
                .open()
                .goToPage("Pop-up Window", new PopUpWindowPage())
                .showPopUpWindow("pop-up")
                .closePopUp();

    }
}

package selenidetests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.example.pages.PopUpWindowPage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class PopUpWindowTest extends BaseTest {

    @Test
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

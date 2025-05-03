package selenidetests.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import org.example.pages.BasePage;
import org.example.pages.DynamicPage;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Listeners()
public class HomPageTest extends BaseTest {


    @Test
    public void testVerifyHomePage() {
        getHomePage()
                .open()
                .pageTitleShouldBeSameAs("Playground for the QA automation engineers");

    }
}

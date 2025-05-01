package selenidetests.tests;

import org.example.pages.AccountPage;
import org.example.pages.HomePage;
import org.testng.annotations.Test;
import selenidetests.base.BaseTest;

public class AccountPageTest extends BaseTest {
    HomePage homePage = new HomePage();

    @Test
    public void testVerifyTitle() {
        homePage
                .open()
                .goToPage("Verify Your Account", new AccountPage())
                .pageTitleShouldBeSameAs("Test Verify Account Flow");
    }

    @Test
    public void testVerifyAccount() {
        homePage
                .open()
                .goToPage("Verify Your Account", new AccountPage())
                .fillCode()
                .assertShouldBe("Success");

    }
}

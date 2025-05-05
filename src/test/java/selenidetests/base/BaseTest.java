package selenidetests.base;

import com.codeborne.selenide.Configuration;


import org.example.pages.HomePage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import selenidetests.tests.HomPageTest;
import selenidetests.utils.DriverManager;
import selenidetests.utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {

    public  HomePage getHomePage() {
        HomePage homePage = new HomePage();
        return homePage;
    }


    protected final DriverManager driverManager = DriverManager.getInstance();


    @BeforeSuite
    public void createDriver() {
        Configuration.baseUrl = "https://qaplayground.dev";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.webdriverLogsEnabled = true;
        Configuration.headless = false;
        Configuration.timeout = 10000;

        driverManager.initDriver();
    }

}

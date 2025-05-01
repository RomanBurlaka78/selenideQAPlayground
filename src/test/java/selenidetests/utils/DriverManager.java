package selenidetests.utils;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {
    private static  DriverManager instance;
    private WebDriver driver;


    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public void initDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            WebDriverManager.chromedriver().clearDriverCache().clearResolutionCache().setup();
            WebDriverManager.chromedriver().clearDriverCache().setup();

        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            WebDriverRunner.closeWebDriver(); // Очистка Selenide
        }
    }
}
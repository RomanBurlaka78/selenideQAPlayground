package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class OpenNewTabPage extends BasePage<OpenNewTabPage>{

    @Step("open new tab : {name}")
    public OpenNewTabPage openNewTabPage(String title) {
      SelenideElement tab = $("a[id='open']");
      tab.click();
      String name = tab.getText();

      switchTo().window(title);

      return this;
    }
}

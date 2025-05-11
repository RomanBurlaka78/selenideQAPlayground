package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class OpenNewTabPage extends BasePage<OpenNewTabPage> {
    SelenideElement tab = $("a[id='open']");

    @Step("open new tab : {title}")
    public OpenNewTabPage openNewTabPage(String title) {
        tab.click();
        String name = tab.getText();
        switchTo().window(title);

        return this;
    }

    @Step("color should be same as: {color}")
    public void colorShouldBeSameAs(String color) {
        tab.hover().shouldHave(Condition.cssValue("background", color));
    }
}

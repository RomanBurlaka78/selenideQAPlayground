package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PopUpWindowPage extends BasePage<PopUpWindowPage>{
    SelenideElement openButton = $("a[id='login']");
    SelenideElement closePopUp = $("button[onclick = 'window.close()']");
    @Step("pop-up window : {title} is shown")
    public PopUpWindowPage showPopUpWindow(String title) {
        openButton.click();
        switchTo().window(title);

        return this;

    }

    @Step("close pop-up")
    public PopUpWindowPage closePopUp() {
        closePopUp.click();
        closePopUp.should(Condition.not(Condition.visible));

        return this;

    }
}

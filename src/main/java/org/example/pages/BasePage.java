package org.example.pages;

import io.qameta.allure.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public abstract class BasePage<T>  {
    public T page;

    public T open() {
        Selenide.open("/");

        return (T) this;
    }

    /**
     *
     * @param title - title of page
     * @return this page
     */
    @Step("The title of the page should be : {title}")
    public T pageTitleShouldBeSameAs(String title) {
        $(By.tagName("title")).shouldBe(Condition.innerText(title));

        return (T) this;
    }
    @Attachment("attachment show : [{title}]")
    @Step("h1 should have title : {title}")
    public T h1ShouldHaveTitle(String title) {
        $("h1").shouldHave(Condition.innerText(title));

        return (T) this;
    }

    @Step("switch to page {title}")
    public T switchToFrame(String title) {
        switchTo().frame(title);

        return (T) this;
    }


}

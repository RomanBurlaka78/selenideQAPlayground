package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import  com.codeborne.selenide.impl.JavaScript;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;



public class ShadowDomPage extends BasePage<ShadowDomPage> {
    SelenideElement progressBar = $("progress-bar");
    SelenideElement button = $("progress-bar").find("button");

    @Step("default  percent should be : [{percent}]")
    public ShadowDomPage getPercent() {
        String percent = progressBar.attr("percent");
        return this;
    }

    @Step("click boost -button")
    public ShadowDomPage clickButton() {
        progressBar.getShadowRoot().findElement(By.cssSelector("button")).click();

        return this;
    }

    @Step("percent should be [{value}]")
    public void percentShouldBe(String value) {
        progressBar.shouldHave(Condition.attribute("percent")).is(Condition.exactText(value), Duration.ofSeconds(6));


    }

}

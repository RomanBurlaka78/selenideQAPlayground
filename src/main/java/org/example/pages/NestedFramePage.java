package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class NestedFramePage extends BasePage<NestedFramePage> {
    ElementsCollection legendCollection = $$("legend");
    SelenideElement clickButton = $(By.xpath("//a[text()='Click Me']"));
    SelenideElement msg = $("p[id= 'msg']");

    @Step("go to iframe [{name}]")
    public NestedFramePage goToIframe(String name) {
        legendCollection.find(Condition.innerText(name));
        switchTo().frame(1);

        return  this;
    }

    @Step("click  button in nested iframe")
    public NestedFramePage clickButton() {
        switchTo().innerFrame("frame1", "frame2");
        clickButton.click();
        return  this;
    }
    @Step("message should be [{message}]")
    public NestedFramePage messageShouldBe(String message) {
        msg.shouldHave(Condition.innerText(message));

        return this;
    }


}

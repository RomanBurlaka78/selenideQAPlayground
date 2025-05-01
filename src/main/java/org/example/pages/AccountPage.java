package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AccountPage extends BasePage<AccountPage> {
//    String numbers = $("small[class='info']").getText().replaceAll("[^0-9]", "");
    @Step("Verify your account")
    public AccountPage confirmAccount() {
//        System.out.println(numbers);
        return this;
    }
    @Step("Fill code")
    public AccountPage fillCode() {
        ElementsCollection list =  $$("input[class ='code']");
        list.forEach(i->i.setValue("9"));

        return this;

    }
    @Step("Assert should be {message}")
    public void assertShouldBe(String message) {
        SelenideElement success= $(By.xpath("//small[@class ='info success']")).shouldBe(Condition.visible);
        success.shouldBe(Condition.innerText(message));
    }
}

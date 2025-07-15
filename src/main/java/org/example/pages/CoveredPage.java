package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CoveredPage extends BasePage<CoveredPage> {

    @Step("find covered element")
    public String findCoveredElement() {
        $("a[id='fugitive']").scrollTo().click();

        return $("p[id = 'info']").scrollTo().getText();
    }


}

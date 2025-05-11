package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;


public class MultiLevelDropDownPage extends BasePage<MultiLevelDropDownPage> {
    ElementsCollection icons = $$("a[class ='icon-button']");

    ElementsCollection meuItem = $$("a[class ='menu-item']");

    @Step("check dropdown {name} {items}")
    public MultiLevelDropDownPage getDropdown(String name, String items) {
        SelenideElement shevron = icons.get(3);
        shevron.click();
        meuItem.find(Condition.innerText(name)).click();
        meuItem.shouldHave().find(Condition.innerText(items)).click();

        return this;
    }

    @Step("show dropdown items : {items}")
    public void showDropDownItems() {
        SelenideElement shevron = icons.get(3);
        shevron.click();
        meuItem.forEach(SelenideElement::text);

    }
}

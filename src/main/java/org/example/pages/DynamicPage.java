package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.CollectionCondition.size;

import static com.codeborne.selenide.Selenide.$$;

public class DynamicPage extends BasePage{
    private ElementsCollection itemsList= $$("tbody[id= 'tbody'] tr");

    /**
     *
     * @param name - for search in table
     * @return this page
     */
    @Step("Find item with name : {name} in table")
    public DynamicPage getItemTableItems(String name) {
        SelenideElement item =itemsList.find(Condition.innerText(name));

        return this;

    }

    /**
     *
     * @return  ElementsCollection of items in table
     */
    @Step("Collections of elements in  table have size : {length}")
    public ElementsCollection shouldHaveSize(int length) {

         return itemsList.shouldHave(size(length));

    }
}

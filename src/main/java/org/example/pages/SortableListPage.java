package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SortableListPage extends BasePage<SortableListPage>{
    ElementsCollection draggableList = $$("div[class='draggable']");
    @Step("drag and drop element : {name}")
    public SortableListPage getMoveItem(String name, int number) {
        draggableList.find(Condition.innerText(name)).dragAndDrop(to(draggableList.get(number)));

        return this;
    }

    @Step("element {number} should have name {name}")
    public void elementShouldHaveName(int number, String name) {
        draggableList.get(number).shouldBe(Condition.innerText(name));

    }

}

package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.CollectionCondition.size;

public class TagsInputPage extends BasePage<TagsInputPage> {
    ElementsCollection allTags = $$("div[class='content'] ul li i");
    SelenideElement input = $("div[class='content'] ul input");
    SelenideElement removeButton = $(By.xpath("//button[text()]"));

    @Step("add one tag : {name}")
    public void addOneTag(String name) {
        input.setValue(name).pressEnter();
    }

    @Step("add few tags")
    public TagsInputPage addFewTags(String str) {
        String s1 = str.replace(" ", ",");
        String[] s2 = s1.split(",");
        for (String s : s2) {
            input.setValue(s).pressEnter();
        }

        return this;
    }

    @Step("remove all tags")
    public TagsInputPage removeAllTags() {
       allTags.forEach(e -> e.click());

       return this;
    }
    @Step("size should be : {length}")
    public void shouldHaveTags(int length) {
        allTags.shouldHave(size(length));
    }

    @Step("remove all from click button")
    public TagsInputPage clickRemoveButton(){
        removeButton.click();

        return this;
    }

    @Step("{number} tags are remaining")
    public int tagsRemaining(){
       String getTags =  $("div[class = 'details'] p").getText();
       String resultTags =getTags.replaceAll("[^0-9]", "");
       int number = Integer.parseInt(resultTags);
       return number;
    }
}

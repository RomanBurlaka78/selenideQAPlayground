package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;


import static com.codeborne.selenide.Selenide.$$;


public class HomePage extends BasePage<HomePage>{


    /**
     *
     * @param name - name of required page
     * @param page - new page for should be open
     * @return
     * @param <T> type of method
     */
    public <T> T goToPage(String name, T page) {
        ElementsCollection itemsApp = $$("div[class ='card-content']");
        itemsApp.find(Condition.innerText(name)).click();

        return  page;
    }




}

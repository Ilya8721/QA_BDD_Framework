package ru.qa.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.qa.at.utils.web.annotations.Name;
import ru.qa.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;

@Name(value = "Google")
public class GooglePage extends WebPage {

    @Name("поле поиска")
    private SelenideElement searchField = $("textarea[title='Поиск']");

    @Name("кнопка поиска")
    private SelenideElement searchButton = $("input[aria-label='Поиск в Google']");
}

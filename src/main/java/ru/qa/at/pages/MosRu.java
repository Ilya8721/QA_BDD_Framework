package ru.qa.at.pages;

import com.codeborne.selenide.SelenideElement;
import ru.qa.at.utils.web.annotations.Name;
import ru.qa.at.utils.web.pagecontext.WebPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Name(value = "MosRu")
public class MosRu extends WebPage {

    @Name("mos.ru – Официальный сайт Мэра Москвы")
    private final SelenideElement mosRuLogo = $("[aria-label='mos.ru – Официальный сайт Мэра Москвы']");

    @Name("кнопка поиска")
    private final SelenideElement searchButtonMagnifyingGlass = $("button[aria-label='Поиск по сайту']");

    @Name("выпадающее меню поиска")
    private final SelenideElement search_modal = $x("//*[contains(@class,'Search_modal')]");

    @Name("поле поиска")
    private final SelenideElement searchField = search_modal.$("input[type='search']");

    @Name("кнопка найти")
    private final SelenideElement searchButton = search_modal.$("button[aria-label='Найти']");

    @Name("Поиск - заголовок")
    private final SelenideElement searchHeader = $x("//h1[text()='Поиск']");

    @Name("Все о карте москвича - заголовок")
    private final SelenideElement allAboutTheMoskvichCardHeader = $x("//h1[text()='Все о карте москвича']");
}

package ru.qa.at.steps.web;


import io.cucumber.java.ru.Если;
import ru.qa.at.utils.web.pagecontext.PageManager;

public class DebugWebSteps extends AbstractWebSteps {

    public DebugWebSteps(PageManager pageManager) {
        super(pageManager);
    }

    @Если("ШАГ № {string}")
    public void stepNumber(String stepNum) {
        LOGGER.info("Шаг номер " + stepNum);
    }
}

package ru.qa.at.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Анализатор для автоматического перезапуска упавших тестов.
 * По умолчанию перезапускает тест 1 раз при падении.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int counter = 0;
    private static final int RETRY_LIMIT = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (counter < RETRY_LIMIT) {
            counter++;
            return true;
        }
        return false;
    }
}

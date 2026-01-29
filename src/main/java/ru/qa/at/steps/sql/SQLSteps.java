package ru.qa.at.steps.sql;

import io.cucumber.java.ru.Тогда;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.at.steps.web.AbstractWebSteps;
import ru.qa.at.utils.web.pagecontext.PageManager;
import ru.qa.at.utils.web.properties.Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Шаги для работы с базой данных PostgreSQL.
 */
public class SQLSteps extends AbstractWebSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLSteps.class);

    private final Configurations conf = ConfigFactory.create(Configurations.class);
    private final String dbUrl = conf.getDatabaseURL();
    private final String dbLogin = conf.getLoginDatabase();
    private final String dbPassword = conf.getPasswordDatabase();

    private static final QueryRunner runner = new QueryRunner();

    public SQLSteps(PageManager pageManager) {
        super(pageManager);
    }

    @Тогда("Подключиться к БД")
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL Driver не найден", e);
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при подключении к базе данных", e);
        }
    }

    @Тогда("Проверить что результат запроса {string} равен {string}")
    public void checkThatTheResultOfTheQueryIsEqualToText(String query, String expectedText) {
        try {
            Object result = runner.query(getConnection(), query, new ScalarHandler<>());

            if (result == null) {
                Assert.fail("Результат запроса пустой!");
            } else {
                String actualResult = String.valueOf(result);
                Assert.assertEquals(actualResult, expectedText,
                        "Ожидаемое значение '" + expectedText + "' не совпадает с фактическим '" + actualResult + "'");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при выполнении запроса: " + e.getMessage(), e);
        }
    }
}

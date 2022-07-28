package prartikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final Boolean expectedName;

    public AccountTest(String name, boolean expectedName) {
        this.name = name;
        this.expectedName = expectedName;
    }

    @Parameterized.Parameters
    public static Object[] getName() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"ТимотиШаламе", false},
                {" ТимотиШаламе", false},
                {"ТимотиШаламе ", false},
                {"Тимоти Шаламе Игоревич", false},
                {"Timothee Chalamet", true},
                {"Т", false},
                {"Т Ш", true},
                {"ТШ", false},
                {"Тимотиии Шаламееее", true},
                {"Тимотииии Шаламееее", true},
                {"Тимотииии Шаламеееее", false},
                {"", false},
        };
    }

    @Test
    @DisplayName("Проверка корректности введенных данных")
    public void checkValidName() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expectedName, actual);
    }
}
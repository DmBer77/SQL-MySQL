package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static SelenideElement login = $("[data-test-id=login] input");
    private static SelenideElement password = $("[data-test-id=password] input");
    private static SelenideElement loginButton = $("[data-test-id=action-login]");
    private static SelenideElement error = $("data-test-id=error-notification");

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login.setValue(info.getLogin());
        password.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void getError() {
        error.shouldBe(Condition.visible);
    }

    public static void cleaning() {
        login.doubleClick().sendKeys(Keys.BACK_SPACE);
        password.doubleClick().sendKeys(Keys.BACK_SPACE);
    }
}
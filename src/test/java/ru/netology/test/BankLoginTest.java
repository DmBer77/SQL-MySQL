package ru.netology.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;

import static ru.netology.data.SQLHelper.cleanDatabase;
import static com.codeborne.selenide.Selenide.open;

public class BankLoginTest {

    @AfterAll
    static void tearDown() {
        cleanDatabase();
    }

    @Test
    void shouldSuccessfullyLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

//    @Test
//    void shouldGetErrorNotificationIfLoginWithRandomUserWithoutAddingToBase() {
//        var loginPage = open("http://localhost:9999", LoginPage.class);
//        var authInfo = DataHelper.generateRandomUser();
//        loginPage.validLogin(authInfo);
//        loginPage.verifyErrorNotificationVisiblity();
//    }

}
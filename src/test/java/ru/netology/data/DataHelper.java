package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private DataHelper() {
    }

    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }

    private static Faker faker = new Faker(new Locale("en"));

    private static String getRandomLogin() {
        return faker.name().username();
    }

    private static String getRandomPassword() {
        return faker.internet().password();
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getRandomUser() {
        return new AuthInfo(getRandomLogin(), getRandomPassword());
    }

    public static VerificationCode getRandomVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class VerificationCode {
        String code;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthCode {
        private String id;
        private String user_id;
        private String code;
        private String created;
    }
}
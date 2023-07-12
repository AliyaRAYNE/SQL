package ru.netology.data;
import com.github.javafaker.Faker;
import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
public class DataHelper {
    private static final Faker faker = new Faker(new Locale("en"));
    private DataHelper() {
    }
    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }
    public static AuthInfo getAuthInfoWithWrongPass() {
        return new AuthInfo("vasya", "qwerty");
    }
    private static String generateRandomLogin() {
        return faker.name().username();
    }
    private static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    public static VerificationCode generateRandomVerificationCode() {
        return new VerificationCode(faker.numerify("######"));
    }
    @Value
    public static class VerificationCode {
        String code;
    }
    @Value
    public static class AuthInfo {
        String login;
        String password;
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
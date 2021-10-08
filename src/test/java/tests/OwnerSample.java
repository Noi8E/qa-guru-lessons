package tests;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class OwnerSample {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    @Test
    void readCredentials() {
        String login = credentials.login();
        String password = credentials.password();

        String message = format("my login is %s and password %s", login,password);
        System.out.println(message);


    }
}

package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.CredentialsConfig;
import helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase extends TestData {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    public static String selenoidRemoteAddress = System.getProperty("selenoidRemoteAddress", "selenoid.autotests.cloud/wd/hub/");


    @BeforeAll
    static void beforeAll() {
        System.out.println("Hi this is simple test for demo.qa\n");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        String login = credentials.login();
        String password = credentials.password();
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = String.format("https://%s:%s@%s",login, password, selenoidRemoteAddress);
    }

    @AfterEach
    public void tearDown() {
        Attach.addVideo();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.screenshotAs("screenshot");
    }

    @AfterAll
    static void sayGoodBye() {
        System.out.println("Bye guys!");
        Selenide.closeWebDriver();
    }

}

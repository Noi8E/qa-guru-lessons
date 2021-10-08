package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.Attach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase extends TestData {
    public static String loginForSelenoid = System.getProperty("login", "user1");
    public static String passwordForSelenoid = System.getProperty("password", "1234");
    public static String selenoidRemoteAddress = System.getProperty("selenoidRemoteAddress", "selenoid.autotests.cloud/wd/hub/");


    @BeforeAll
    static void sayHello() {
        System.out.println("Hi this is simple test for demo.qa\n");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        Configuration.remote = String.format("https://%s:%s@%s", loginForSelenoid,passwordForSelenoid,selenoidRemoteAddress);
    }

    protected static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
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

package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestBase extends TestData {

    @BeforeAll
    static void sayHello() {
        System.out.println("Hi this is simple test for demo.qa\n");
        Configuration.startMaximized = true;
    }
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void sayGoodBye() {
        System.out.println("Bye guys!");
        Selenide.closeWebDriver();
    }

}

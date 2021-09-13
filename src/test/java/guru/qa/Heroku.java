package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Heroku {
    @BeforeAll
    static void sayHello() {
        System.out.println("Hi this is simple test for demo.qa\n");
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void sayGoodBye() {
        System.out.println("Bye guys!");
        Selenide.closeWebDriver();
    }
    @Test
    void openSomeSite() {
        open("https://ru.wikipedia.org/wiki/%D0%9E%D0%B2%D0%B5%D0%BD%D0%B4%D0%B5%D0%BD,_%D0%93%D1%80%D1%8D%D0%BC");
        $("div > h2").shouldBe(Condition.exist);
        $("div").$("h2").shouldBe(Condition.exist);
    }
}

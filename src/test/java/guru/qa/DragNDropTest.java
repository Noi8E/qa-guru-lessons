package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragNDropTest extends TestBase {

    @Test
    void DragNDropIsWorked() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldBe(Condition.visible);
        $("#column-a").dragAndDropTo("#column-b").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));
    }
}

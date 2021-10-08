package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/*
* Овет на первый вопрос:
* Нет, нет разницы.
* В примере $("h1 div") - в стринге передается поиск всех div внутри h1, без обертки от селенида. Строка передается в вебдрайвер
* и срабатывает поиск напрямую ( если я правильно выражаюсь)
* В примере  $("h1").$("div") - по сути происходит тоже самое, только через StringBuilder.
*
* Ниже по коду у меня есть обращение к кнопке "Show 2 more pages"
* $(".Box-row.wiki-more-pages-link").$(By.tagName("button")).click();
*
* Если бы я юзал первый способ и просто передавал стрингу в метод, то было бы что-то вроде
* $(".Box-row.wiki-more-pages-link [type='button']")
*
* Т.е. во втором способе я напрямую прописываю команду для веб-драйвера, а в первом за меня это делает селенид.
*
*
* */


public class SelenideWikiTest extends TestBase {

    @Test
    void canOpenSelenidePageOnGithub() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".Box-row.wiki-more-pages-link").$(By.tagName("button")).click();
        $(By.partialLinkText("SoftAssert")).shouldBe(Condition.visible);
    }
    @Test
    void canSeeJunit5ExampleInSoftAssertWikiPage(){
        open("https://github.com/selenide/selenide/wiki/SoftAssertions");
        $(By.xpath("//*[contains(text(),'Using JUnit5')]")).shouldBe(Condition.visible);
        $(By.xpath("//*[contains(text(),'ExtendWith')]")).shouldBe(Condition.visible);
    }
}

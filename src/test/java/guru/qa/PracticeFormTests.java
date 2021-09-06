package guru.qa;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class PracticeFormTests {
    String firstName = "someFirstName";
    String lastName = "someLastName";
    String userEmail = "test@test.ru";
    String phone = "7908111111";
    String monthBirth = "June";
    String yearBirth = "1922";
    String dateOfBirth = "16 November,1922";
    String subjects = "Computer Science, Maths";
    String hobbies = "Sports, Reading";
    String picture = "BoJack-on-Behance.png";
    String studentGender = "Male";
    String currentAddress = "Vorkuta, Russia, 169980";
    String stateAndCity = "Haryana Panipat";

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
    void canSubmitForm() {
        open("https://demoqa.com/automation-practice-form");
        //обращение по айдишнику
        $x("//*[@id='firstName']").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(studentGender)).click();
        $x("//*[@class='custom-control custom-radio custom-control-inline']//*[@id='gender-radio-3']/..").click();
        $("[for=gender-radio-2]").click();
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(monthBirth)).click();
        $x("//*[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']//*[text()='November']").click();
        $(".react-datepicker__year-select").$(byText(yearBirth)).click();
        $x("//*[@class='react-datepicker__day react-datepicker__day--016']").click();
        $("#subjectsInput").setValue("com").pressEnter();
        $("#subjectsInput").setValue("a").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/BoJack-on-Behance.png"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").find("input").setValue("Har").pressEnter();
        $("#city").find("input").setValue("Pan").pressEnter();
        $("#submit").scrollTo().click();


        //Проверяем что окно с информацией отображается
        $(".modal-content").shouldBe(Condition.visible);
        //Проверяем наличие введенных параметров
        $(".modal-content").$(byText(firstName + " " +  lastName)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(userEmail)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(studentGender)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(phone)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(dateOfBirth)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(subjects)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(hobbies)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(picture)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(currentAddress)).shouldBe(Condition.exist);
        $(".modal-content").$(byText(stateAndCity)).shouldBe(Condition.exist);


    }
}

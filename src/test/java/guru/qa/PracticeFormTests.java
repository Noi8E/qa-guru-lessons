package guru.qa;

import com.codeborne.selenide.Condition;
import guru.qa.pages.RegistrationPage;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.SubjectComponent;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendar = new CalendarComponent();
    SubjectComponent subject = new SubjectComponent();



    String monthBirth = "June";
    String yearBirth = "1922";
    String dateOfBirth = "16 November,1922";
    String subjects = "Computer Science, Maths";
    String hobbies = "Sports, Reading";
    String picture = "BoJack-on-Behance.png";
    String currentAddress = "Vorkuta, Russia, 169980";
    String stateAndCity = "Haryana Panipat";



    @Test
    void canSubmitForm() {

        beforeAll();

        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);

        registrationPage.setGender(studentGender);
        registrationPage.setPhoneNumber(phoneNumber);


        calendar.setDate(dayCalendar,monthCalendar,yearCalendar);

        subject.setSubject(subjectValue1,subjectValue2);





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
//        $(".modal-content").$(byText(firstName + " " +  lastName)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(userEmail)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(studentGender)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(phone)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(dateOfBirth)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(subjects)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(hobbies)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(picture)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(currentAddress)).shouldBe(Condition.exist);
//        $(".modal-content").$(byText(stateAndCity)).shouldBe(Condition.exist);


    }
}

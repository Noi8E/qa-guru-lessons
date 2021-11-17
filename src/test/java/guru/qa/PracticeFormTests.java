package guru.qa;

import guru.qa.pages.RegistrationPage;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.HobbiesComponent;
import guru.qa.pages.components.SubjectComponent;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendar = new CalendarComponent();
    SubjectComponent subject = new SubjectComponent();
    HobbiesComponent hobbiesComponent = new HobbiesComponent();

    Map<String, String> expectedData = new HashMap<>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", userEmail);
        put("Gender", studentGender);
        put("Mobile", phoneNumber);
        put("Date of Birth", dayCalendar + " " + monthCalendar + "," + yearCalendar);
        put("Subjects", subjectValue1 + ", " + subjectValue2);
        put("Hobbies", rndHobbies1 + ", " + rndHobbies2);
        put("Picture", picture);
        put("Address", rndAddres);
        put("State and City", rndState + " " + rndCity);
    }};

    @Test
    void registrationFormTest() {

        registrationPage.openPage();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.setGender(studentGender);
        registrationPage.setPhoneNumber(phoneNumber);
        calendar.setDate(dayCalendar, monthCalendar, yearCalendar);
        subject.setSubject(subjectValue1, subjectValue2);
        hobbiesComponent.setHobbies(rndHobbies1, rndHobbies2);
        registrationPage.getUploadPicture(new File("src/test/resources/BoJack-on-Behance.png"));
        registrationPage.setAddress(rndAddres);
        registrationPage.setState(rndState);
        registrationPage.setCity(rndCity);

        registrationPage.getSubmit();

        //Проверяем что окно с информацией отображается
        registrationPage.checkModalWindowHeader();

        //Проверка корректности введенных данных
        registrationPage.checkFinalTable(expectedData);
        // Хотел через Map, но так и не понял - как это сделать.
//        registrationPage.checkFinalTable("Student Name", firstName + " " + lastName);
//        registrationPage.checkFinalTable("Student Email", userEmail);
//        registrationPage.checkFinalTable("Gender", studentGender);
//        registrationPage.checkFinalTable("Mobile", phoneNumber);
//        registrationPage.checkFinalTable("Date of Birth", dayCalendar + " " + monthCalendar + "," +
//                yearCalendar);
//        registrationPage.checkFinalTable("Subjects", subjectValue1 + ", " + subjectValue2 );
//        registrationPage.checkFinalTable("Hobbies", rndHobbies1 + ", " + rndHobbies2);
//        registrationPage.checkFinalTable("Picture", "BoJack-on-Behance.png");
//        registrationPage.checkFinalTable("Address", rndAddres);
//        registrationPage.checkFinalTable("State and City", rndState + " " + rndCity);
    }
}
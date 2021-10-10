package tests;

import guru.qa.pages.RegistrationPage;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.HobbiesComponent;
import guru.qa.pages.components.SubjectComponent;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendar = new CalendarComponent();
    SubjectComponent subject = new SubjectComponent();
    HobbiesComponent hobbiesComponent = new HobbiesComponent();

    @Test
    void canSubmitForm() {

        beforeAll();
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.setGender();
        registrationPage.setPhoneNumber(phoneNumber);
        calendar.setDate(dayCalendar,monthCalendar,yearCalendar);
        subject.setSubject(subjectValue1,subjectValue2);
        hobbiesComponent.setHobbies(rndHobbies1,rndHobbies2);
        registrationPage.getUploadPicture(new File("src/test/resources/images/BoJack.png"));
        registrationPage.setAddress(rndAddres);
        registrationPage.setState(rndState);
        registrationPage.setCity(rndCity);
        registrationPage.getSubmit();

        //Проверяем что окно с информацией отображается
        registrationPage.checkModalWindowHeader();
        //Проверка корректности введенных данных
        // Хотел через Map, но так и не понял - как это сделать.
        registrationPage.checkFinalTable("Student Name", firstName + " " + lastName);
        registrationPage.checkFinalTable("Student Email", userEmail);
        registrationPage.checkFinalTable("Gender", studentGender);
        registrationPage.checkFinalTable("Mobile", phoneNumber);
        registrationPage.checkFinalTable("Date of Birth", dayCalendar + " " + monthCalendar + "," + yearCalendar);
        registrationPage.checkFinalTable("Subjects", subjectValue1 + ", " + subjectValue2 );
        registrationPage.checkFinalTable("Hobbies", rndHobbies1 + ", " + rndHobbies2);
        registrationPage.checkFinalTable("Picture", "BoJack.png");
        registrationPage.checkFinalTable("Address", rndAddres);
        registrationPage.checkFinalTable("State and City", rndState + " " + rndCity);


    }
}

package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    protected static final String URL = "/automation-practice-form"; ;
    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $x("//*[@id='firstName']"),
            lastNameInput = $x("//*[@id='lastName']"),
            emailInput = $("#userEmail"),
            genterInput = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber");



    public void openPage(){
        open(URL);
        formTitle.shouldHave(text(FORM_TITLE));
    }
    public void typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }
    public void typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }
    public void typeEmail(String email) {
        emailInput.setValue(email);
    }
    public void setGender(String gender){
        $(byText(gender)).click();
    }
    public  void setPhoneNumber(String phone){
        phoneNumberInput.setValue(phone);
    }





}

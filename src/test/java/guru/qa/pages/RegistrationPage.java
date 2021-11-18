package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationPage {

    protected final static String URL = "/automation-practice-form";

    private final static String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $x("//*[@id='firstName']"),
            lastNameInput = $x("//*[@id='lastName']"),
            emailInput = $("#userEmail"),
          //genterInput = $("[name=gender][value=Male]"), //больше не нужен, т.к метод немного поменялся
            phoneNumberInput = $("#userNumber"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state").find("input"),
            cityInput = $("#city").find("input"),
            submitButton = $("#submit"),
            modalWindowHeader = $("#example-modal-sizes-title-lg");


    public void openPage() {
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

    public RegistrationPage setGender(String gender) {
        $(format("[name=gender][value=%s]", gender)).parent().click();
        return this;
    }

    public void setPhoneNumber(String phone) {
        phoneNumberInput.setValue(phone);
    }

    public void getUploadPicture(File file) {
        uploadPicture.uploadFile(file);
    }

    public void setAddress(String address) {
        addressInput.setValue(address);
    }

    public void setState(String state) {
        stateInput.setValue(state).pressEnter();
    }

    public void setCity(String city) {
        cityInput.setValue(city).pressEnter();
    }

    public void getSubmit() {
        submitButton.scrollTo().click();
    }

    public void checkModalWindowHeader() {
        modalWindowHeader.shouldBe(Condition.visible);
        modalWindowHeader.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkFinalTable(Map<String, String> expectedData) {
        ElementsCollection popupResults = $$(".table-responsive tbody tr").snapshot();

        SoftAssertions softly = new SoftAssertions();

        for (SelenideElement popupResult : popupResults) {
            String line = popupResult.$("td").text();
            String expectedValue = expectedData.get(line);
            String actualValue = popupResult.$("td", 1).text();

            softly.assertThat(actualValue)
                    .as(format("Result in line %s was %s, but expected %s", line, actualValue, expectedValue))
                    .isEqualTo(expectedValue);
        }
        softly.assertAll();
    }

//    public void checkFinalTable(String name, String value) {
//        $x("//td[text()=" + "'" + name + "'" + "]/following-sibling::td").shouldHave(text(value));
//    }
}
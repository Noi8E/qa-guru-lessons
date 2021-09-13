package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectComponent {
    public void setSubject(String val1, String val2){
        $("#subjectsInput").setValue(val1).pressEnter();
        $("#subjectsInput").setValue(val2).pressEnter();
    }
}

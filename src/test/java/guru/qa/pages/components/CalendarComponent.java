package guru.qa.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $x("//*[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']//*[text()='" +
                        month + "']").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();

//        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
//
////        String.format
//        String selector = ".react-datepicker__day--028:not(.react-datepicker__day--outside-month)";
//        $(selector).click();
//
//        String selector1 = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
//        String formatedSelector = String.format(selector1, day);
//        $(formatedSelector).click();
//
//
//        String bigtext = "apple %s banana %s ananas %s %s";
//        String b = "and";
//        String c = "not";
//
//        System.out.println(String.format(bigtext, b, c, b, c));
    }
}

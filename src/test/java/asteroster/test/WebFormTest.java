package asteroster.test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebFormTest {

    @Test
    void demoqaWebTest() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

        open("/automation-practice-form");
        $("#firstName").setValue("Johny");
        $("#lastName").setValue("Mnemonic");
        $("#userEmail").setValue("johnmnc@test.com");
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue("8572918374");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $(".react-datepicker__day--028:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Bio").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/Rattus.jpg");
        $("#currentAddress").setValue("some address");
        $("#stateCity-wrapper").$("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#city").$(byText("Panipat")).click();
        $("#submit").click();
        $(".modal-dialog").should(Condition.appear);
        $(".modal-content").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Johny Mnemonic")).parent()
                .shouldHave(text("Student Name"));
        $(".table-responsive").$(byText("johnmnc@test.com")).parent()
                .shouldHave(text("Student Email"));
        $(".table-responsive").$(byText("Other")).parent()
                .shouldHave(text("Gender"));
        $(".table-responsive").$(byText("8572918374")).parent()
                .shouldHave(text("Mobile"));
        $(".table-responsive").$(byText("28 June,1988")).parent()
                .shouldHave(text("Date of Birth"));
        $(".table-responsive").$(byText("Biology")).parent()
                .shouldHave(text("Subjects"));
        $(".table-responsive").$(byText("Sports")).parent()
                .shouldHave(text("Hobbies"));
        $(".table-responsive").$(byText("Rattus.jpg")).parent()
                .shouldHave(text("Picture"));
        $(".table-responsive").$(byText("some address")).parent()
                .shouldHave(text("Address"));
        $(".table-responsive").$(byText("Haryana Panipat")).parent()
                .shouldHave(text("State and City"));
        }
}

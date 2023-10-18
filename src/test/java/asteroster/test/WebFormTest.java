package asteroster.test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebFormTest {

    @BeforeAll
    public static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;

    }
    @Test
    void demoqaWebTest() {


        open("/automation-practice-form");
        $("#firstName").setValue("Johny");
        $("#lastName").setValue("Mnemonic");
        $("#userEmail").setValue("johnmnc@test.com");
        $("#genterWrapper").$(byText("Other")).click();
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
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("Johny Mnemonic"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text("johnmnc@test.com"));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("8572918374"));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("28 June,1988"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("Rattus.jpg"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text("some address"));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));
        }
}
